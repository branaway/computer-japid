package japidviews.Application;
import java.util.*;
import java.io.*;
import cn.bran.japid.tags.Each;
import cn.bran.japid.template.RenderResult;
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
// NOTE: This file was generated from: japidviews/Application/myInputText.html
// Change to this file will be lost next time the template file is compiled.
//
public class myInputText extends cn.bran.play.JapidTemplateBase
{
	public static final String sourceTemplate = "japidviews/Application/myInputText.html";
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


	public myInputText() {
		super(null);
	}
	public myInputText(StringBuilder out) {
		super(out);
	}
/* based on https://github.com/branaway/Japid/issues/12
 */
	public static final String[] argNames = new String[] {/* args of the template*/"fld", "label",  };
	public static final String[] argTypes = new String[] {/* arg types of the template*/"Field", "String",  };
	public static final Object[] argDefaults= new Object[] {null,null, };
	public static java.lang.reflect.Method renderMethod = getRenderMethod(japidviews.Application.myInputText.class);

	{
		setRenderMethod(renderMethod);
		setArgNames(argNames);
		setArgTypes(argTypes);
		setArgDefaults(argDefaults);
		setSourceTemplate(sourceTemplate);
	}
////// end of named args stuff

	private Field fld; // line 3
	private String label; // line 3
	public cn.bran.japid.template.RenderResult render(Field fld,String label) {
		this.fld = fld;
		this.label = label;
		long __t = -1;
		try {super.layout();} catch (RuntimeException e) { super.handleException(e);} // line 3
		return new cn.bran.japid.template.RenderResultPartial(getHeaders(), getOut(), __t, actionRunners, sourceTemplate);
	}
	
	public static RenderResult apply(Field fld,String label) {
		return new myInputText().render(fld, label);
	}
	
	@Override protected void doLayout() {
		beginDoLayout(sourceTemplate);
//------
;// line 1
		;// line 1
		p("	<div class=\"clearfix ");// line 3
		p(Forms.hasError(fld) ? "error" : "");// line 4
		p("\">\n" + 
"	    <label for=\"");// line 4
		p(fld.name());// line 5
		p("\">");// line 5
		p(label);// line 5
		p("</label>\n" + 
"	    <div class=\"input\">\n" + 
"	        \n" + 
"	    <input type=\"text\" id=\"");// line 5
		p(fld.name());// line 8
		p("\" name=\"");// line 8
		p(fld.name());// line 8
		p("\" value=\"");// line 8
		p(fld.value());// line 8
		p("\" >\n" + 
"	        <span class=\"help-inline\">");// line 8
		p(Forms.fieldSpecs(fld));// line 9
		p("</span> \n" + 
"	    </div>\n" + 
"	</div>");// line 9
		
		endDoLayout(sourceTemplate);
	}

}