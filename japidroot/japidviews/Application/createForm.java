package japidviews.Application;
import java.util.*;
import java.io.*;
import cn.bran.japid.tags.Each;
import play.data.Form.Field;
import utils.Forms;
import play.data.Form;
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

	private Form<Computer> computerForm; // line 5
	public cn.bran.japid.template.RenderResult render(Form<Computer> computerForm) {
		this.computerForm = computerForm;
		long __t = -1;
		try {super.layout();} catch (RuntimeException e) { super.handleException(e);} // line 5
		return new cn.bran.japid.template.RenderResultPartial(getHeaders(), getOut(), __t, actionRunners, sourceTemplate);
	}
	@Override protected void doLayout() {
		beginDoLayout(sourceTemplate);
//------
;// line 1
;// line 3
		p("\n" + 
"\n");// line 5
		p("    <h1>Add a Computer/Japid</h1>\n" + 
"    \n" + 
"    <form method=\"POST\" action=\"");// line 8
		p(routes.Application.save());// line 12
		p("\">\n" + 
"        <fieldset>\n" + 
"            ");// line 12
		final myInputText _myInputText0 = new myInputText(getOut()); _myInputText0.setActionRunners(getActionRunners()).setOut(getOut()); _myInputText0.render(computerForm.apply("name"),"Computer name"); // line 14// line 14
            final myInputText _myInputText1 = new myInputText(getOut()); _myInputText1.setActionRunners(getActionRunners()).setOut(getOut()); _myInputText1.render(computerForm.apply("introduced"),"Introduced date"); // line 15// line 15
		p("            ");// line 15
		p(Application.inputText(computerForm.apply("discontinued"), "Discontinued date"));// line 16
		p("            \n");// line 16
		p("\n" + 
"            ");// line 18
		final select _select2 = new select(getOut()); _select2.setActionRunners(getActionRunners()).setOut(getOut()); _select2.render(computerForm.apply("company.id"),Company.options(),"Company","- Choose a company -"); // line 20// line 20
		p("            \n" + 
"\n" + 
"        </fieldset>\n" + 
"        \n" + 
"        <div class=\"actions\">\n" + 
"            <input type=\"submit\" value=\"Create this computer\" class=\"btn primary\"> or \n" + 
"            <a href=\"");// line 25
		p(routes.Application.index());// line 32
		p("\" class=\"btn\">Cancel</a> \n" + 
"        </div>\n" + 
"    </form>\n" + 
"\n");// line 32
		
		endDoLayout(sourceTemplate);
	}

}