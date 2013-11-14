import sbt._
import Keys._
import play.Project._

object ApplicationBuild extends Build {

    val appName         = "computer-japid"
    val appVersion      = "1.2"

    val appDependencies = Seq(
    		javaJpa,
    		cache,
    		"org.hibernate" % "hibernate-entitymanager" % "3.6.9.Final",
    		"japid42" % "japid42_2.10" % "0.9.14.1"
    )

    val main = play.Project(appName, appVersion, appDependencies).settings(
    		resolvers += Resolver.url("Japid on Github", url("http://branaway.github.io/releases/"))(Resolver.ivyStylePatterns)
    		,ebeanEnabled := false
    		// comment out the following line in dev mode so changes in Japid scripts won't trigger app reloading
    		,unmanagedResourceDirectories in Compile  <+= baseDirectory( _ / "japidroot" )
    )
}
            
