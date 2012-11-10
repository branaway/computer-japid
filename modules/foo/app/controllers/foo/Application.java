package controllers.foo;

import play.mvc.Result;

public class Application extends cn.bran.play.JapidController {
  
  public static Result index() {
      return notFound(renderJapid("index4"));
  }
  
}