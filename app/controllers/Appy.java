package controllers;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

import play.mvc.Result;
import cn.bran.play.JapidController;

/**
 * Manage a database of computers
 */
@Path("/appy")
public class Appy extends JapidController {
	
	@GET
    public static Result index() {
//    	throw new RuntimeException("something is not right");
        return ok("very cool");
    }

	@GET
	public static Result index2() {
//    	throw new RuntimeException("something is not right");
		return ok("very cool2");
	}
}
            
