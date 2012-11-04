package japidviews.Application;
import java.util.*;
import java.io.*;
import cn.bran.japid.tags.Each;
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
// NOTE: This file was generated from: japidviews/Application/edit.html
// Change to this file will be lost next time the template file is compiled.
//
public class edit extends main
{
	public static final String sourceTemplate = "japidviews/Application/edit.html";
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


	public edit() {
		super(null);
	}
	public edit(StringBuilder out) {
		super(out);
	}
/* based on https://github.com/branaway/Japid/issues/12
 */
	public static final String[] argNames = new String[] {/* args of the template*/"id", "computerForm",  };
	public static final String[] argTypes = new String[] {/* arg types of the template*/"Long", "Form<Computer>",  };
	public static final Object[] argDefaults= new Object[] {null,null, };
	public static java.lang.reflect.Method renderMethod = getRenderMethod(japidviews.Application.edit.class);

	{
		setRenderMethod(renderMethod);
		setArgNames(argNames);
		setArgTypes(argTypes);
		setArgDefaults(argDefaults);
		setSourceTemplate(sourceTemplate);
	}
////// end of named args stuff

	private Long id; // line 1
	private Form<Computer> computerForm; // line 1
	public cn.bran.japid.template.RenderResult render(Long id,Form<Computer> computerForm) {
		this.id = id;
		this.computerForm = computerForm;
		long __t = -1;
		try {super.layout("Edit A Computer");} catch (RuntimeException e) { super.handleException(e);} // line 1
		return new cn.bran.japid.template.RenderResultPartial(getHeaders(), getOut(), __t, actionRunners, sourceTemplate);
	}

	public static cn.bran.japid.template.RenderResult apply(Long id,Form<Computer> computerForm) {
		return new edit().render(id, computerForm);
	}

	@Override protected void doLayout() {
		beginDoLayout(sourceTemplate);
//------
;// line 1
		p("\n");// line 1
		p("    \n" + 
"    <h1>Edit computer/Japid</h1>\n" + 
"    \n" + 
"    <form method=\"POST\" action=\"");// line 2
		p(routes.Application.update(id));// line 7
		p("\">\n" + 
"        <fieldset>\n" + 
"        \n" + 
"            ");// line 7
		final myInputText _myInputText0 = new myInputText(getOut()); _myInputText0.setActionRunners(getActionRunners()).setOut(getOut()); _myInputText0.render(computerForm.apply("name"),"名称"); // line 10// line 10
		p("            \n" + 
"            ");// line 10
		p("			");// line 14
		p(myInputText.apply(
				computerForm.apply("introduced"), 
				"Introduced Date"
				)
			);// line 15
		;// line 19
		p("			\n" + 
"\n" + 
"            ");// line 22
		p(Application.inputText(computerForm.apply("discontinued"), "Discontinued Date"));// line 24
		p("\n" + 
"            ");// line 24
		final select _select1 = new select(getOut()); _select1.setActionRunners(getActionRunners()).setOut(getOut()); _select1.render(computerForm.apply("company.id"),Company.options(),"Company","- Choose a company -"); // line 26// line 26
		p("        \n" + 
"        </fieldset>\n" + 
"        \n" + 
"        <div class=\"actions\">\n" + 
"            <input type=\"submit\" value=\"Save this computer\" class=\"btn primary\"> or \n" + 
"            <a href=\"");// line 31
		p(routes.Application.index());// line 37
		p("\" class=\"btn\">Cancel</a> \n" + 
"        </div>\n" + 
"        \n" + 
"    </form>\n" + 
"\n" + 
"    <form method=\"POST\" action=\"");// line 37
		p(routes.Application.delete(id));// line 42
		p("\" class=\"topRight\">\n" + 
"    	<input type=\"submit\" value=\"Delete this computer\" class=\"btn danger\">\n" + 
"    </form>\n" + 
"    ");// line 42
		
		endDoLayout(sourceTemplate);
	}

}