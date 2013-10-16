package controllers.foo;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

import models.Calc;
import play.mvc.Result;

@Path("app")
public class Application extends cn.bran.play.JapidController {
  
	@GET
	public static Result index() {
	  return renderJapid(new Calc("Sony", 10));
   }
  
}