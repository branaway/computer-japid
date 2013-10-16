package japidviews.foo.Application;
import java.util.*;
import java.io.*;
import cn.bran.japid.tags.Each;
import java.util.*;
import static cn.bran.japid.util.WebUtils.*;
import japidviews.*;
//
// NOTE: This file was generated from: japidviews/foo/Application/index.html
// Change to this file will be lost next time the template file is compiled.
//
public class index extends cn.bran.play.JapidTemplateBase
{
	public static final String sourceTemplate = "japidviews/foo/Application/index.html";
	{
		putHeader("Content-Type", "text/html; charset=utf-8");
		putHeader("Server", "nginx/0.8.26");
		setContentType("text/html; charset=utf-8");
	}
	public index() {
		super(null);
	}
	public index(StringBuilder out) {
		super(out);
	}
/* based on https://github.com/branaway/Japid/issues/12
 */
	public static final String[] argNames = new String[] {/* args of the template*/ };
	public static final String[] argTypes = new String[] {/* arg types of the template*/ };
	public static final Object[] argDefaults= new Object[] { };
	public static java.lang.reflect.Method renderMethod = getRenderMethod(japidviews.foo.Application.index.class);

	{
		setRenderMethod(renderMethod);
		setArgNames(argNames);
		setArgTypes(argTypes);
		setArgDefaults(argDefaults);
		setSourceTemplate(sourceTemplate);
	}
////// end of named args stuff

	public cn.bran.japid.template.RenderResult render() {
		long __t = -1;
		try {super.layout();} catch (RuntimeException e) { super.handleException(e);} 
		return new cn.bran.japid.template.RenderResultPartial(getHeaders(), getOut(), __t, actionRunners, sourceTemplate);
	}

	public static cn.bran.japid.template.RenderResult apply() {
		return new index().render();
	}

	@Override protected void doLayout() {
		beginDoLayout(sourceTemplate);
//------
;// line 1
		p("nice... \n");// line 1
		
		endDoLayout(sourceTemplate);
	}

}