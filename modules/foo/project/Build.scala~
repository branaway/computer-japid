import sbt._
import Keys._
import PlayProject._

object ApplicationBuild extends Build {

    val appName         = "foo"
    val appVersion      = "0.1"

    val appDependencies = Seq(
       "japid42" % "japid42_2.9.1" % "0.5.3"
    )

    val main = PlayProject(appName, appVersion, appDependencies, mainLang = JAVA).settings(
      // Add your own project settings here      
    )

}
