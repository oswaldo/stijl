package stijl

trait CubeMaterializer:
  def materialize(cube: CubeDefinition): CubeRuntime

trait DatabaseConfig

enum DatabaseDialect:
  case PostgreSQL

case class DatabaseCubeMaterializer(val config: DatabaseConfig):
  def materialize(cube: CubeDefinition): CubeRuntime = ???
