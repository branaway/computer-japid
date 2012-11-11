import sbt._
import Keys._
import PlayProject._

object ApplicationBuild extends Build {

    val appName         = "computer-japid"
    val appVersion      = "1.0"

    val appDependencies = Seq(
      "org.hibernate" % "hibernate-entitymanager" % "3.6.9.Final"
      ,"japid42" % "japid42_2.9.1" % "0.6"
    )

    val foo = PlayProject("foo", "0.1", appDependencies, path = file("modules/foo"))

    val main = PlayProject(appName, appVersion, appDependencies, mainLang = JAVA).settings(
      ebeanEnabled := false,
//      resolvers += "Local Play Repository" at "/Users/bran/projects/playscala/repository/local"
      resolvers += Resolver.url("Japid on Github", url("http://branaway.github.com/releases/"))(Resolver.ivyStylePatterns)
    ).dependsOn(foo)

}
            
