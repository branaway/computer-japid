import sbt._
import Keys._
import PlayProject._

object ApplicationBuild extends Build {

    val appName         = "foo"
    val appVersion      = "0.1"

    val appDependencies = Seq(
       "japid42" % "japid42_2.9.1" % "0.6"
    )

    val main = PlayProject(appName, appVersion, appDependencies, mainLang = JAVA).settings(
      // Add your own project settings here
      resolvers += Resolver.url("Japid on Github", url("http://branaway.github.com/releases/"))(Resolver.ivyStylePatterns)
    )

}
