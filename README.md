# stijl

Hypercubes for all

> WIP
> 
> Free time pet project to experiment with Dotty (Scala3) prototyping a standaline "micro OLAP engine"
>
> Iterations
> 1. ~~Basic data structures to define a (hyper)cube~~
> 2. Cube runtime instanced as defined, ready to hold data in memory
> 3. Basic query DSL
> 4. Persistent cube and offloaded processing to PostgreSQL

```scala mdoc
import stijl._

val cube = "A cube".withDimensions("x", "y", "z")
```

### Usage

This is a normal sbt project, you can compile code with `sbt compile` and run it
with `sbt run`, `sbt console` will start a Dotty REPL.

For more information on the sbt-dotty plugin, see the
[dotty-example-project](https://github.com/lampepfl/dotty-example-project/blob/master/README.md).
