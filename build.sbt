name := "playweb"

version := "1.0-SNAPSHOT"

libraryDependencies ++= Seq(
  javaJdbc,
  javaEbean,
  "com.amazonaws" % "aws-java-sdk" % "1.3.11",
  cache
)     

play.Project.playJavaSettings
