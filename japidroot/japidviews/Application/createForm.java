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
// NOTE: This file was generated from: japidviews/Application/createForm.html
// Change to this file will be lost next time the template file is compiled.
//
public class createForm extends main
{
	public static final String sourceTemplate = "japidviews/Application/createForm.html";
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


	public createForm() {
		super(null);
	}
	public createForm(StringBuilder out) {
		super(out);
	}
/* based on https://github.com/branaway/Japid/issues/12
 */
	public static final String[] argNames = new String[] {/* args of the template*/"computerForm",  };
	public static final String[] argTypes = new String[] {/* arg types of the template*/"Form<Computer>",  };
	public static final Object[] argDefaults= new Object[] {null, };
	public static java.lang.reflect.Method renderMethod = getRenderMethod(japidviews.Application.createForm.class);

	{
		setRenderMethod(renderMethod);
		setArgNames(argNames);
		setArgTypes(argTypes);
		setArgDefaults(argDefaults);
		setSourceTemplate(sourceTemplate);
	}
////// end of named args stuff

	private Form<Computer> computerForm; // line 1
	public cn.bran.japid.template.RenderResult render(Form<Computer> computerForm) {
		this.computerForm = computerForm;
		long __t = -1;
		try {super.layout("Add a computer");} catch (RuntimeException e) { super.handleException(e);} // line 1
		return new cn.bran.japid.template.RenderResultPartial(getHeaders(), getOut(), __t, actionRunners, sourceTemplate);
	}

	public static cn.bran.japid.template.RenderResult apply(Form<Computer> computerForm) {
		return new createForm().render(computerForm);
	}

	@Override protected void doLayout() {
		beginDoLayout(sourceTemplate);
//------
;// line 1
		p("\n" + 
"\n");// line 1
		p("    <h1>Add a Computer</h1>\n" + 
"    \n" + 
"    <form method=\"POST\" action=\"");// line 3
		p(routes.Application.save());// line 7
		p("\">\n" + 
"        <fieldset>\n" + 
"            ");// line 7
		final myInputText _myInputText0 = new myInputText(getOut()); _myInputText0.setActionRunners(getActionRunners()).setOut(getOut()); _myInputText0.render(computerForm.apply("name"),"Computer name"); // line 9// line 9
            final myInputText _myInputText1 = new myInputText(getOut()); _myInputText1.setActionRunners(getActionRunners()).setOut(getOut()); _myInputText1.render(computerForm.apply("introduced"),"Introduced date"); // line 10// line 10
		p("            \n" + 
"            ");// line 10
		p("            ");// line 12
		p(Application.inputText(computerForm.apply("discontinued"), "Discontinued date"));// line 13
		p("            \n");// line 13
		p("\n" + 
"            ");// line 15
		final select _select2 = new select(getOut()); _select2.setActionRunners(getActionRunners()).setOut(getOut()); _select2.render(computerForm.apply("company.id"),Company.options(),"Company","- Choose a company -"); // line 17// line 17
		p("            \n" + 
"\n" + 
"        </fieldset>\n" + 
"        \n" + 
"        <div class=\"actions\">\n" + 
"            <input type=\"submit\" value=\"Create this computer\" class=\"btn primary\"> or \n" + 
"            <a href=\"");// line 22
		p(routes.Application.index());// line 29
		p("\" class=\"btn\">Cancel</a> \n" + 
"        </div>\n" + 
"    </form>\n" + 
"\n");// line 29
		
		endDoLayout(sourceTemplate);
	}

}