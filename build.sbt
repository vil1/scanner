name := "scanner"

scalaVersion := "2.10.0"

version := "1.0"

resolvers ++= Seq(
    "snapshots" at "http://scala-tools.org/repo-snapshots",
    "releases" at "http://scala-tools.org/repo-releases")

resolvers ++= Seq(
    "sonatype-snapshots" at "http://oss.sonatype.org/content/repositories/snapshots",
    "sonatype-releases" at "http://oss.sonatype.org/content/repositories/releases")

libraryDependencies ++= Seq(
    "org.scalatest" % "scalatest_2.9.2" % "1.8" % "test" withSources() withJavadoc(),
    "junit" % "junit" % "4.10" withSources() withJavadoc(),
    "org.testng" % "testng" % "6.1.1" % "test" withSources() withJavadoc(),
    "org.specs2" %% "specs2" % "1.12.3" withSources() withJavadoc())
