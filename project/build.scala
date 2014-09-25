import sbt._
import Keys._

object KnoldusBuild extends Build {
    lazy val root = Project(id = "knoldus-common",
                            base = file(".")) aggregate(util)

    lazy val util = Project(id = "knoldus-util",
                           base = file("knoldus-util"))

}
