package japidviews.Application;
import java.util.*;
import java.io.*;
import cn.bran.japid.tags.Each;
import utils.Forms;
import play.mvc.Http.Context.Implicit;
import models.*;
import play.i18n.Lang;
import play.data.Form;
import play.data.Form.Field;
import play.mvc.Http.Request;
import play.mvc.Http.Response;
import play.mvc.Http.Session;
import play.mvc.Http.Flash;
import play.data.validation.Validation;
import java.util.*;
import static cn.bran.japid.util.WebUtils.*;
import controllers.*;
//
// NOTE: This file was generated from: japidviews/Application/inputText.html
// Change to this file will be lost next time the template file is compiled.
//
public class inputText extends cn.bran.play.JapidTemplateBase
{
	public static final String sourceTemplate = "japidviews/Application/inputText.html";
	{
		putHeader("Content-Type", "text/html; charset=utf-8");
		setContentType("text/html; charset=utf-8");
	}

// - add implicit fields with Play
boolean hasHttpContext = play.mvc.Http.Context.current.get() != null ? true : false;

	final Request request = hasHttpContext? Implicit.request() : null;
	final Response response = hasHttpContext ? Implicit.response() : null;
	final Session session = hasHttpContext ? Implicit.session() : null;
	final Flash flash = hasHttpContext ? Implicit.flash() : null;
	final Lang lang = hasHttpContext ? Implicit.lang() : null;
	final play.Play _play = new play.Play(); 

// - end of implicit fields with Play 


	public inputText() {
		super(null);
	}
	public inputText(StringBuilder out) {
		super(out);
	}
/* based on https://github.com/branaway/Japid/issues/12
 */
	public static final String[] argNames = new String[] {/* args of the template*/"name", "value", "label", "info", "hasError",  };
	public static final String[] argTypes = new String[] {/* arg types of the template*/"String", "String", "String", "String", "boolean",  };
	public static final Object[] argDefaults= new Object[] {null,null,null,null,null, };
	public static java.lang.reflect.Method renderMethod = getRenderMethod(japidviews.Application.inputText.class);

	{
		setRenderMethod(renderMethod);
		setArgNames(argNames);
		setArgTypes(argTypes);
		setArgDefaults(argDefaults);
		setSourceTemplate(sourceTemplate);
	}
////// end of named args stuff

	private String name; // line 3
	private String value; // line 3
	private String label; // line 3
	private String info; // line 3
	private boolean hasError; // line 3
	public cn.bran.japid.template.RenderResult render(String name,String value,String label,String info,boolean hasError) {
		this.name = name;
		this.value = value;
		this.label = label;
		this.info = info;
		this.hasError = hasError;
		long __t = -1;
		try {super.layout();} catch (RuntimeException e) { super.handleException(e);} // line 3
		return new cn.bran.japid.template.RenderResultPartial(getHeaders(), getOut(), __t, actionRunners, sourceTemplate);
	}
	@Override protected void doLayout() {
		beginDoLayout(sourceTemplate);
//------
;// line 1
		;// line 1
		p("<div class=\"clearfix ");// line 3
		p(hasError ? "error" : "");// line 4
		p("\">\n" + 
"    <label for=\"");// line 4
		p(name);// line 5
		p("\">");// line 5
		p(label);// line 5
		p("</label>\n" + 
"    <div class=\"input\">\n" + 
"        \n" + 
"    <input type=\"text\" id=\"");// line 5
		p(name);// line 8
		p("\" name=\"");// line 8
		p(name);// line 8
		p("\" value=\"");// line 8
		p(escape(value));// line 8
		p("\" >\n" + 
"        <span class=\"help-inline\">");// line 8
		p(escape(info));// line 9
		p("</span> \n" + 
"    </div>\n" + 
"</div>");// line 9
		
		endDoLayout(sourceTemplate);
	}

}