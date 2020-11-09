package stijl

import scala.language.implicitConversions

import stijl.CubeImplicits._
import stijl.CubeImplicits.{given _}

@main def app: Unit = {
  //In the future, this will take some arguments to parse a json or yaml cube definition and materialize it over some data storage backend
  //Just calling some functions for now to demo some aspect of the library...
  println("a".withDimensions("d1".asDimension.withLevels("d1l1"), "d2".asDimension.withLevels("d2l1".asIntAttribute)).isValid)
}
