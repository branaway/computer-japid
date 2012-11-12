package japidviews;
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
import japidviews.*;
import play.mvc.Http.Response;
import play.mvc.Http.Session;
import play.mvc.Http.Flash;
import play.data.validation.Validation;
import java.util.*;
import static cn.bran.japid.util.WebUtils.*;
import controllers.*;
//
// NOTE: This file was generated from: japidviews/select.html
// Change to this file will be lost next time the template file is compiled.
//
public class select extends cn.bran.play.JapidTemplateBase
{
	public static final String sourceTemplate = "japidviews/select.html";
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


	public select() {
		super(null);
	}
	public select(StringBuilder out) {
		super(out);
	}
/* based on https://github.com/branaway/Japid/issues/12
 */
	public static final String[] argNames = new String[] {/* args of the template*/"fld", "options", "label", "defaultVal",  };
	public static final String[] argTypes = new String[] {/* arg types of the template*/"Field", "Map<String, String>", "String", "String",  };
	public static final Object[] argDefaults= new Object[] {null,null,null,null, };
	public static java.lang.reflect.Method renderMethod = getRenderMethod(japidviews.select.class);

	{
		setRenderMethod(renderMethod);
		setArgNames(argNames);
		setArgTypes(argTypes);
		setArgDefaults(argDefaults);
		setSourceTemplate(sourceTemplate);
	}
////// end of named args stuff

	private Field fld; // line 3
	private Map<String, String> options; // line 3
	private String label; // line 3
	private String defaultVal; // line 3
	public cn.bran.japid.template.RenderResult render(Field fld,Map<String, String> options,String label,String defaultVal) {
		this.fld = fld;
		this.options = options;
		this.label = label;
		this.defaultVal = defaultVal;
		long __t = -1;
		try {super.layout();} catch (RuntimeException e) { super.handleException(e);} // line 3
		return new cn.bran.japid.template.RenderResultPartial(getHeaders(), getOut(), __t, actionRunners, sourceTemplate);
	}

	public static cn.bran.japid.template.RenderResult apply(Field fld,Map<String, String> options,String label,String defaultVal) {
		return new select().render(fld, options, label, defaultVal);
	}

	@Override protected void doLayout() {
		beginDoLayout(sourceTemplate);
//------
;// line 1
		;// line 1
		p("\n" + 
"<div class=\"clearfix ");// line 3
		p(fld.errors() != null && fld.errors().size() > 0 ? "error" : "");// line 5
		p("\">\n" + 
"    <label for=\"");// line 5
		p(fld.name());// line 6
		p("\">");// line 6
		p(label);// line 6
		p("</label>\n" + 
"    <div class=\"input\">\n" + 
"        \n" + 
"    <select id=\"");// line 6
		p(fld.name());// line 9
		p("\" name=\"");// line 9
		p(fld.name());// line 9
		p("\" >\n" + 
"        <option class=\"blank\" value=\"\">");// line 9
		p(defaultVal);// line 10
		p("</option>\n" + 
"        ");// line 10
		for(String k : options.keySet()){// line 11
		p("            <option value=\"");// line 11
		p(k);// line 12
		p("\" ");// line 12
		p(k.equals(fld.value()) ? "selected" : "");// line 12
		p(">");// line 12
		p(escape(options.get(k)));// line 12
		p("</option>\n" + 
"        ");// line 12
		}// line 13
		p("    </select>\n" + 
"	<span class=\"help-inline\">");// line 13
		p(Forms.fieldSpecs(fld));// line 15
		p("</span> \n" + 
"    </div>\n" + 
"</div>\n");// line 15
		
		endDoLayout(sourceTemplate);
	}

}