name := "knoldus-util"

version := "1.0"

organization := "com.knoldus"

scalaVersion := "2.11.2"

libraryDependencies ++= Seq("org.apache.pdfbox" % "pdfbox" % "1.8.4",
                            "org.apache.pdfbox" % "fontbox" % "1.8.4",
                            "org.apache.poi" % "poi-scratchpad" % "3.10.1",
                            "org.scalatest" %% 	"scalatest" % "2.2.2" % "test")

scalacOptions := Seq("-unchecked", "-deprecation", "-encoding", "utf8")

resolvers += "Typesafe Repo" at "http://repo.typesafe.com/typesafe/releases/"

resolvers += "Scala-tools" at "https://oss.sonatype.org/content/groups/scala-tools"

resolvers += "Sonatype Snapshot" at "http://oss.sonatype.org/content/repositories/snapshots"

seq(ScctPlugin.instrumentSettings : _*)





