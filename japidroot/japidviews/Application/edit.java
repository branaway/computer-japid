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

	final Request request = Implicit.request(); 
	final Response response = Implicit.response(); 
	final Session session = Implicit.session();
	final Flash flash = Implicit.flash();
	final Lang lang = Implicit.lang();
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

	private Long id; // line 5
	private Form<Computer> computerForm; // line 5
	public cn.bran.japid.template.RenderResult render(Long id,Form<Computer> computerForm) {
		this.id = id;
		this.computerForm = computerForm;
		long t = -1;
		try {super.layout();} catch (RuntimeException e) { super.handleException(e);} // line 5
		return new cn.bran.japid.template.RenderResultPartial(getHeaders(), getOut(), t, actionRunners, sourceTemplate);
	}
	@Override protected void doLayout() {
		beginDoLayout(sourceTemplate);
//------
;// line 1
;// line 3
		p("\n");// line 5
		p("    \n" + 
"    <h1>Edit computer</h1>\n" + 
"    \n" + 
"    <form method=\"POST\" action=\"");// line 7
		p(routes.Application.update(id));// line 12
		p("\">\n" + 
"        <fieldset>\n" + 
"        \n" + 
"            ");// line 12
		final myInputText _myInputText0 = new myInputText(getOut()); _myInputText0.setActionRunners(getActionRunners()).setOut(getOut()); _myInputText0.render(computerForm.apply("name"),"Computer name"); // line 15// line 15
            final myInputText _myInputText1 = new myInputText(getOut()); _myInputText1.setActionRunners(getActionRunners()).setOut(getOut()); _myInputText1.render(computerForm.apply("introduced"),"Introduced date"); // line 16// line 16
            final myInputText _myInputText2 = new myInputText(getOut()); _myInputText2.setActionRunners(getActionRunners()).setOut(getOut()); _myInputText2.render(computerForm.apply("discontinued"),"Discontinued date"); // line 17// line 17
            final select _select3 = new select(getOut()); _select3.setActionRunners(getActionRunners()).setOut(getOut()); _select3.render(computerForm.apply("company.id"),Company.options(),"Company","- Choose a company -"); // line 19// line 19
		p("        \n" + 
"        </fieldset>\n" + 
"        \n" + 
"        <div class=\"actions\">\n" + 
"            <input type=\"submit\" value=\"Save this computer\" class=\"btn primary\"> or \n" + 
"            <a href=\"");// line 24
		p(routes.Application.list(0, "name", "desc", ""));// line 30
		p("\" class=\"btn\">Cancel</a> \n" + 
"        </div>\n" + 
"        \n" + 
"    </form>\n" + 
"\n" + 
"    <form method=\"POST\" action=\"");// line 30
		p(routes.Application.delete(id));// line 35
		p("\" class=\"topRight\">\n" + 
"    	<input type=\"submit\" value=\"Delete this computer\" class=\"btn danger\">\n" + 
"    </form>\n" + 
"    ");// line 35
		
		endDoLayout(sourceTemplate);
	}

}