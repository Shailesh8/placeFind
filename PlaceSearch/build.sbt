//import play.Project._

name := """PlaceSearch"""

organization:="com.shailesh.project"

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava)
libraryDependencies ++= Seq(
 javaJdbc,
  javaEbean,
  cache,
  javaWs,
 "org.powermock" % "powermock-module-junit4" % "1.6.2",
 "org.powermock" % "powermock-api-mockito" %  "1.6.2" 
 )
 
//playJavaSettings

 




