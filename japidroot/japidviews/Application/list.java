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
// NOTE: This file was generated from: japidviews/Application/list.html
// Change to this file will be lost next time the template file is compiled.
//
public class list extends main
{
	public static final String sourceTemplate = "japidviews/Application/list.html";
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


	public list() {
		super(null);
	}
	public list(StringBuilder out) {
		super(out);
	}
/* based on https://github.com/branaway/Japid/issues/12
 */
	public static final String[] argNames = new String[] {/* args of the template*/"currentPage", "currentSortBy", "currentOrder", "currentFilter",  };
	public static final String[] argTypes = new String[] {/* arg types of the template*/"Computer.Page", "String", "String", "String",  };
	public static final Object[] argDefaults= new Object[] {null,null,null,null, };
	public static java.lang.reflect.Method renderMethod = getRenderMethod(japidviews.Application.list.class);

	{
		setRenderMethod(renderMethod);
		setArgNames(argNames);
		setArgTypes(argTypes);
		setArgDefaults(argDefaults);
		setSourceTemplate(sourceTemplate);
	}
////// end of named args stuff

	private Computer.Page currentPage; // line 1
	private String currentSortBy; // line 1
	private String currentOrder; // line 1
	private String currentFilter; // line 1
	public cn.bran.japid.template.RenderResult render(Computer.Page currentPage,String currentSortBy,String currentOrder,String currentFilter) {
		this.currentPage = currentPage;
		this.currentSortBy = currentSortBy;
		this.currentOrder = currentOrder;
		this.currentFilter = currentFilter;
		long __t = -1;
		try {super.layout("List all the computers");} catch (RuntimeException e) { super.handleException(e);} // line 1
		return new cn.bran.japid.template.RenderResultPartial(getHeaders(), getOut(), __t, actionRunners, sourceTemplate);
	}
	@Override protected void doLayout() {
		beginDoLayout(sourceTemplate);
//------
;// line 1
		p("\n" + 
"\n");// line 1
		;// line 3
		p("\n");// line 8
		// line 10
		;// line 32
		p("\n");// line 36
		// line 38
		p("\n" + 
"    <h1 id=\"homeTitle\">\n" + 
"    \n" + 
"    ");// line 42
		p(getMessage("computers.list.title", currentPage.getTotalRowCount()));// line 47
		p("    \n" + 
"    </h1>\n" + 
"\n" + 
"    ");// line 47
		if(flash.containsKey("success")) {// line 51
		p("        <div class=\"alert-message warning\">\n" + 
"            <strong>Done!</strong> ");// line 51
		p(flash.get("success"));// line 53
		p("        </div>\n" + 
"    ");// line 53
		} // line 55
		p("    <div id=\"actions\">\n" + 
"        \n" + 
"        <form action=\"");// line 55
		p(Application.link(currentSortBy, currentOrder, currentFilter, 0, "name"));// line 59
		p("\" method=\"GET\">\n" + 
"            <input type=\"search\" id=\"searchbox\" name=\"f\" value=\"");// line 59
		p(currentFilter);// line 60
		p("\" placeholder=\"Filter by computer name...\">\n" + 
"            <input type=\"submit\" id=\"searchsubmit\" value=\"Filter by name\" class=\"btn primary\">\n" + 
"        </form>\n" + 
"        \n" + 
"        <a class=\"btn success\" id=\"add\" href=\"");// line 60
		p(routes.Application.create());// line 64
		p("\">Add a new computer</a>\n" + 
"        \n" + 
"    </div>\n" + 
"    \n" + 
"    ");// line 64
		if(currentPage.getTotalRowCount() == 0) {// line 68
		p("        \n" + 
"        <div class=\"well\">\n" + 
"            <em>Nothing to display</em>\n" + 
"        </div>\n" + 
"        \n" + 
"    ");// line 68
		} else {// line 74
		p("        \n" + 
"        <table class=\"computers zebra-striped\">\n" + 
"            <thead>\n" + 
"                <tr>\n" + 
"                    ");// line 74
		p(header("name", "Computer name"));// line 79
		p("                    ");// line 79
		p(header("introduced", "Introduced"));// line 80
		p("                    ");// line 80
		p(header("discontinued", "Discontinued"));// line 81
		p("                    ");// line 81
		p(header("company.name", "Company"));// line 82
		p("                </tr>\n" + 
"            </thead>\n" + 
"            <tbody>\n" + 
"\n" + 
"                ");// line 82
		for(Computer computer : currentPage.getList()) {// line 87
		p("                    <tr>\n" + 
"                        <td><a href=\"");// line 87
		p(routes.Application.edit(computer.id));// line 89
		p("\">");// line 89
		p(computer.name);// line 89
		p("</a></td>\n" + 
"                        <td>\n" + 
"                            ");// line 89
		if(computer.introduced == null) {// line 91
		p("                                <em>-</em>\n" + 
"                            ");// line 91
		} else {// line 93
		p("                                ");// line 93
		p(format(computer.introduced, "dd MMM yyyy"));// line 94
		p("                            ");// line 94
		}// line 95
		p("                        </td>\n" + 
"                        <td>\n" + 
"                            ");// line 95
		if(computer.discontinued == null) {// line 98
		p("                                <em>-</em>\n" + 
"                            ");// line 98
		} else {// line 100
		p("                               	");// line 100
		p(format(computer.discontinued, "dd MMM yyyy"));// line 101
		p("                            ");// line 101
		}// line 102
		p("                        </td>\n" + 
"                        <td>\n" + 
"                            ");// line 102
		if(computer.company == null) {// line 105
		p("                                <em>-</em>\n" + 
"                            ");// line 105
		} else {// line 107
		p("                                ");// line 107
		p(computer.company.name);// line 108
		p("                            ");// line 108
		}// line 109
		p("                        </td>\n" + 
"                    </tr>\n" + 
"                ");// line 109
		}// line 112
		p("            </tbody>\n" + 
"        </table>\n" + 
"\n" + 
"        <div id=\"pagination\" class=\"pagination\">\n" + 
"            <ul>\n" + 
"                ");// line 112
		if(currentPage.hasPrev()) {// line 119
		p("                    <li class=\"prev\">\n" + 
"                        <a href=\"");// line 119
		p(link(currentPage.getPageIndex() - 1, null));// line 121
		p("\">&larr; Previous</a>\n" + 
"                    </li>\n" + 
"                ");// line 121
		} else {// line 123
		p("                    <li class=\"prev disabled\">\n" + 
"                        <a>&larr; Previous</a>\n" + 
"                    </li>\n" + 
"                ");// line 123
		}// line 127
		p("                <li class=\"current\">\n" + 
"                    <a>Displaying ");// line 127
		p(currentPage.getDisplayXtoYofZ());// line 129
		p("</a>\n" + 
"                </li>\n" + 
"                ");// line 129
		if(currentPage.hasNext()) {// line 131
		p("                    <li class=\"next\">\n" + 
"                        <a href=\"");// line 131
		p(link(currentPage.getPageIndex() + 1, null));// line 133
		p("\">Next &rarr;</a>\n" + 
"                    </li>\n" + 
"                ");// line 133
		} else {// line 135
		p("                    <li class=\"next disabled\">\n" + 
"                        <a>Next &rarr;</a>\n" + 
"                    </li>\n" + 
"                ");// line 135
		}// line 139
		p("            </ul>\n" + 
"        </div>\n" + 
"        \n" + 
"    ");// line 139
		}// line 143
		p("        \n" + 
"\n" + 
"            ");// line 143
		
		endDoLayout(sourceTemplate);
	}

public String link(Integer newPage, String newSortBy) {
StringBuilder sb = new StringBuilder();
StringBuilder ori = getOut();
this.setOut(sb);
TreeMap<Integer, cn.bran.japid.template.ActionRunner> parentActionRunners = actionRunners;
actionRunners = new TreeMap<Integer, cn.bran.japid.template.ActionRunner>();
// line 10
		p("");// line 10
		//japid compiler: artificial line to avoid being treated as a terminating line// line 11
			String sortBy = currentSortBy;// line 12
		    String order = currentOrder;// line 13
		//japid compiler: artificial line to avoid being treated as a terminating line// line 14
		    if(newSortBy != null) {// line 15
		        sortBy = newSortBy;// line 16
		        if(currentSortBy == newSortBy) {// line 17
		            if(currentOrder == "asc") {// line 18
		                order = "desc";// line 19
		            } else {// line 20
		                order = "asc";// line 21
		            }// line 22
		        } else {// line 23
		            order = "asc";// line 24
		        }// line 25
		    }// line 26
		//japid compiler: artificial line to avoid being treated as a terminating line// line 27
		p("    // Generate the link\n" + 
"    ");// line 28
		p(routes.Application.list(newPage, sortBy, order, currentFilter));// line 30
		p("    \n");// line 30
		
this.setOut(ori);
if (actionRunners.size() > 0) {
	StringBuilder sb2 = new StringBuilder();
	int segStart = 0;
	for (Map.Entry<Integer, cn.bran.japid.template.ActionRunner> arEntry : actionRunners.entrySet()) {
		int pos = arEntry.getKey();
		sb2.append(sb.substring(segStart, pos));
		segStart = pos;
		cn.bran.japid.template.ActionRunner a = arEntry.getValue();
		sb2.append(a.run().getContent().toString());
	}
	sb2.append(sb.substring(segStart));
	actionRunners = parentActionRunners;
	return sb2.toString();
} else {
	actionRunners = parentActionRunners;
	return sb.toString();
}
}
public String header (String key, String title) {
StringBuilder sb = new StringBuilder();
StringBuilder ori = getOut();
this.setOut(sb);
TreeMap<Integer, cn.bran.japid.template.ActionRunner> parentActionRunners = actionRunners;
actionRunners = new TreeMap<Integer, cn.bran.japid.template.ActionRunner>();
// line 38
		p("    <th class=\"");// line 38
		p(key.replace(".","_"));// line 39
		p(" header  ");// line 39
		if(currentSortBy.equals(key)){// line 39
		p(" ");// line 39
		p(currentOrder.equals("asc") ? "headerSortDown" : "headerSortUp");// line 39
		p(" ");// line 39
		}// line 39
		p("\">\n" + 
"        <a href=\"");// line 39
		p(Application.link(currentSortBy, currentOrder, currentFilter, 0, key));// line 40
		p("\">");// line 40
		p(escape(title));// line 40
		p("</a>\n" + 
"    </th>\n");// line 40
		
this.setOut(ori);
if (actionRunners.size() > 0) {
	StringBuilder sb2 = new StringBuilder();
	int segStart = 0;
	for (Map.Entry<Integer, cn.bran.japid.template.ActionRunner> arEntry : actionRunners.entrySet()) {
		int pos = arEntry.getKey();
		sb2.append(sb.substring(segStart, pos));
		segStart = pos;
		cn.bran.japid.template.ActionRunner a = arEntry.getValue();
		sb2.append(a.run().getContent().toString());
	}
	sb2.append(sb.substring(segStart));
	actionRunners = parentActionRunners;
	return sb2.toString();
} else {
	actionRunners = parentActionRunners;
	return sb.toString();
}
}
}