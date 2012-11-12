package controllers.foo;

import models.Calc;
import play.mvc.Result;

public class Application extends cn.bran.play.JapidController {
  
	
  public static Result index() {
	  return renderJapid(new Calc("Sony", 10));
  }
  
}