import sbt._
import Keys._
import play.Project._

object ApplicationBuild extends Build {

    val appName         = "computer-japid"
    val appVersion      = "1.1"

    val appDependencies = Seq(
  //  		javaCore,
  //  		javaJdbc,
    		javaJpa,
    		"org.hibernate" % "hibernate-entitymanager" % "3.6.9.Final",
    		"japid42" % "japid42_2.10" % "0.9.4.1"
    )

    val foo = play.Project("foo", "0.1", appDependencies, path = file("modules/foo")).settings(
    		resolvers += Resolver.url("Japid on Github", url("http://branaway.github.com/releases/"))(Resolver.ivyStylePatterns)
    )

    val main = play.Project(appName, appVersion, appDependencies).settings(
    		ebeanEnabled := false
//      	,resolvers += "Local Play Repository" at "/Users/bran/projects/playscala/repository/local" 
//    		,resolvers += Resolver.url("Japid on Github", url("http://branaway.github.com/releases/xxx"))(Resolver.ivyStylePatterns)
//    		, resourceDirectories in (Compile, run) <+= baseDirectory / "japidroot"
    ).dependsOn(foo)

}
            
