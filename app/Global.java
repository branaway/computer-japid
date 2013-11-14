import play.Play;
import play.mvc.Http.RequestHeader;
import play.mvc.Result;
import play.mvc.Results;
import cn.bran.japid.util.JapidFlags;
import cn.bran.play.JapidController;
import play.mvc.Results.Status;

public class Global extends cn.bran.play.GlobalSettingsWithJapid {
	@Override
	public void onStartJapid() {
	    setTemplateRoot("japidroot" /*, "modules/foo/japidroot"*/);
		setLogVerbose(true);
		setKeepJavaFiles(false); // keep the Java code derived from Japid scripts in memory only
//		JapidFlags.setLogLevelDebug();
	}

	@Override
	public play.libs.F.Promise<play.mvc.SimpleResult> onError(RequestHeader h, Throwable t) {
		if (Play.application().isProd())
			return wrapup(Results.internalServerError(JapidController.renderJapidWith("onError.html", h, t)));
		else
			return super.onError(h, t);
	}

	@Override
	public play.libs.F.Promise<play.mvc.SimpleResult> onBadRequest(RequestHeader r, String s) {
		if (Play.application().isProd())
			return wrapup(Results.badRequest(JapidController.renderJapidWith("onBadRequest.html", r, s)));
		else
			return super.onBadRequest(r, s);
	}

	@Override
	public play.libs.F.Promise<play.mvc.SimpleResult> onHandlerNotFound(RequestHeader r) {
		// usually one needs to use a customized error reporting in production.
		//
		if (Play.application().isProd())
			return wrapup(Results.notFound(JapidController.renderJapidWith("onHandlerNotFound.html", r)));
		else
			return super.onHandlerNotFound(r);
	}
	
	private play.libs.F.Promise<play.mvc.SimpleResult> wrapup(play.mvc.SimpleResult s) {
		return play.libs.F.Promise.pure(s);
	}
}