import sbt._
import Keys._
import play.Project._

object ApplicationBuild extends Build {

    val appName         = "computer-japid"
    val appVersion      = "1.2"

    val appDependencies = Seq(
  //  		javaCore,
  //  		javaJdbc,
    		javaJpa,
    		cache,
    		"org.hibernate" % "hibernate-entitymanager" % "3.6.9.Final",
    		"japid42" % "japid42_2.10" % "0.9.12"
    )

//    val foo = play.Project("foo", "0.1", appDependencies, path = file("modules/foo")).settings(
//    		//,resolvers += "pk11" at "http://pk11-scratch.googlecode.com/svn/trunk"
//    )

    val main = play.Project(appName, appVersion, appDependencies).settings(
    		resolvers += Resolver.url("Japid on Github", url("http://branaway.github.com/releases/"))(Resolver.ivyStylePatterns)
    		,ebeanEnabled := false
//    		,unmanagedResourceDirectories in Compile  <+= baseDirectory( _ / "japidroot" )

//    		, mappings in (Compile, packageBin) <+= baseDirectory map { base =>
//		    		(base / "japidroot" / "japidviews") -> "japidroot/japidviews"
//		    }
    )
}
            
