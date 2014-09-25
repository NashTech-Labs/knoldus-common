name := "knoldus-common"

organization := "Knoldus"

scalaVersion := "2.10.2"

libraryDependencies ++= Seq("org.apache.pdfbox" % "pdfbox" % "1.8.4",
                            "org.apache.pdfbox" % "fontbox" % "1.8.4",
                            "org.scalatest" %% 	"scalatest" % "1.9.2" % "test")

scalacOptions := Seq("-unchecked", "-deprecation", "-encoding", "utf8")

resolvers += "Typesafe Repo" at "http://repo.typesafe.com/typesafe/releases/"

resolvers += "Scala-tools" at "https://oss.sonatype.org/content/groups/scala-tools"

resolvers += "Sonatype Snapshot" at "http://oss.sonatype.org/content/repositories/snapshots"






