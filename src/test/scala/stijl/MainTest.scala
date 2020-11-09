package stijl

import scala.language.implicitConversions

import collection.mutable.Stack
import org.scalatest._
import flatspec._
import matchers._

class MainTest extends AnyFlatSpec with should.Matchers:
  
  "The Main.app method" should "run without problems" in
    stijl.app
