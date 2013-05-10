import play.Play;
import play.mvc.Http.RequestHeader;
import play.mvc.Result;
import play.mvc.Results;
import cn.bran.play.JapidController;

public class Global extends cn.bran.play.GlobalSettingsWithJapid {
	@Override
	public void onStartJapid() {
	    setTemplateRoot("japidroot", "modules/foo/japidroot");
		setLogVerbose(true);
		setKeepJavaFiles(false); // keep the Java code derived from Japid scripts in memory only
	}

	@Override
	public Result onError(RequestHeader h, Throwable t) {
		if (Play.application().isProd())
			return Results.internalServerError(JapidController.renderJapidWith("onError.html", h, t));
		else
			return super.onError(h, t);
	}

	@Override
	public Result onBadRequest(RequestHeader r, String s) {
		if (Play.application().isProd())
			return Results.badRequest(JapidController.renderJapidWith("onBadRequest.html", r, s));
		else
			return super.onBadRequest(r, s);
	}

	@Override
	public Result onHandlerNotFound(RequestHeader r) {
		// usually one needs to use a customized error reporting in production.
		//
		if (Play.application().isProd() || Play.application().isDev())
			return Results.notFound(JapidController.renderJapidWith("onHandlerNotFound.html", r));
		else
			return super.onHandlerNotFound(r);
	}
}