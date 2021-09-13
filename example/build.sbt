name := "example"

version := "0.0.1"

scalaVersion := "2.13.6"

scalacOptions ++= Seq("-language:implicitConversions", "-deprecation")

testOptions in Test += Tests.Argument(TestFrameworks.JUnit, "-a", "-v", "-s")

libraryDependencies += "org.scalatest" %% "scalatest" % "3.2.3" % "test"
libraryDependencies += "org.scalatestplus" %% "junit-4-13" % "3.2.3" % "test"
libraryDependencies += "junit" % "junit" % "4.13" % "test"

