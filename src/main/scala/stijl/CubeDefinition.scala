package stijl

trait CubeElement(val name: String):
  def isValid: Boolean

private def validList(list: List[_ <: CubeElement]): Boolean = list.nonEmpty && list.forall(_.isValid)

enum AttributeDefinition(override val name: String) extends CubeElement(name):

  override def isValid: Boolean = true

  case StringAttributeDefinition(override val name: String)  extends AttributeDefinition(name)

  case IntAttributeDefinition(override val name: String)  extends AttributeDefinition(name)

case class HierarchyDefinition(override val name: String, levels: List[AttributeDefinition] = List.empty) extends CubeElement(name):

  override def isValid: Boolean = validList(levels)

  def withLevels(levels: AttributeDefinition*) = copy(levels = levels.toList)

object DimensionDefinition:
  val DefaultHierarchy = HierarchyDefinition("default")

case class DimensionDefinition(override val name: String, hierarchies: List[HierarchyDefinition] = List(DimensionDefinition.DefaultHierarchy)) extends CubeElement(name):

  override def isValid: Boolean = validList(hierarchies)

  def withHierarchies(hierarchies: HierarchyDefinition*) = copy(hierarchies = hierarchies.toList)

  def withLevels(levels: AttributeDefinition*) = withHierarchies(DimensionDefinition.DefaultHierarchy.withLevels(levels: _*))

case class CubeDefinition(override val name: String, dimensions: List[DimensionDefinition] = List.empty, measures: List[AttributeDefinition] = List.empty) extends CubeElement(name):

  override def isValid: Boolean = validList(dimensions) && validList(measures)

  def withDimensions(dimensions: DimensionDefinition*) = copy(dimensions = dimensions.toList)

object CubeImplicits:
  
  extension (s: String)
    def asDimension = DimensionDefinition(s)
    def asStringAttribute = AttributeDefinition.StringAttributeDefinition(s)
    def asIntAttribute = AttributeDefinition.IntAttributeDefinition(s)
  
  given cubeDefFromString as Conversion[String, CubeDefinition] = CubeDefinition(_)
  
  given dimensionDefFromString as Conversion[String, DimensionDefinition] = DimensionDefinition(_)
  
  given hierarchyDefFromString as Conversion[String, HierarchyDefinition] = HierarchyDefinition(_)
  
  given levelDefFromString as Conversion[String, AttributeDefinition] = AttributeDefinition.StringAttributeDefinition(_)
