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
import japidviews.*;
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
		try {super.layout("List All");} catch (RuntimeException e) { super.handleException(e);} // line 1
		return new cn.bran.japid.template.RenderResultPartial(getHeaders(), getOut(), __t, actionRunners, sourceTemplate);
	}

	public static cn.bran.japid.template.RenderResult apply(Computer.Page currentPage,String currentSortBy,String currentOrder,String currentFilter) {
		return new list().render(currentPage, currentSortBy, currentOrder, currentFilter);
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
		;// line 31
		p("\n");// line 35
		// line 37
		p("\n" + 
"    <h1 id=\"homeTitle\">\n" + 
"    \n" + 
"    ");// line 41
		p(getMessage("computers.list.title", currentPage.getTotalRowCount()));// line 46
		p("    \n" + 
"    </h1>\n" + 
"\n" + 
"    ");// line 46
		if(flash.containsKey("success")) {// line 50
		p("        <div class=\"alert-message warning\">\n" + 
"            <strong>Done!</strong> ");// line 50
		p(flash.get("success"));// line 52
		p("        </div>\n" + 
"    ");// line 52
		} // line 54
		p("    <div id=\"actions\">\n" + 
"        \n" + 
"        <form action=\"");// line 54
		p(Application.link(currentSortBy, currentOrder, currentFilter, 0, "name"));// line 58
		p("\" method=\"GET\">\n" + 
"            <input type=\"search\" id=\"searchbox\" name=\"f\" value=\"");// line 58
		p(currentFilter);// line 59
		p("\" placeholder=\"Filter by computer name...\">\n" + 
"            <input type=\"submit\" id=\"searchsubmit\" value=\"Filter by name\" class=\"btn primary\">\n" + 
"        </form>\n" + 
"        \n" + 
"        <a class=\"btn success\" id=\"add\" href=\"");// line 59
		p(routes.Application.create());// line 63
		p("\">Add a new computer</a>\n" + 
"        \n" + 
"    </div>\n" + 
"    \n" + 
"    ");// line 63
		if(currentPage.getTotalRowCount() == 0) {// line 67
		p("        \n" + 
"        <div class=\"well\">\n" + 
"            <em>Nothing to display</em>\n" + 
"        </div>\n" + 
"        \n" + 
"    ");// line 67
		} else {// line 73
		p("        \n" + 
"        <table class=\"computers zebra-striped\">\n" + 
"            <thead>\n" + 
"                <tr>\n" + 
"                    ");// line 73
		p(header("name", "Computer name"));// line 78
		p("                    ");// line 78
		p(header("introduced", "Introduced"));// line 79
		p("                    ");// line 79
		p(header("discontinued", "Discontinued"));// line 80
		p("                    ");// line 80
		p(header("company.name", "Company"));// line 81
		p("                </tr>\n" + 
"            </thead>\n" + 
"            <tbody>\n" + 
"\n" + 
"                ");// line 81
		for(Computer computer : currentPage.getList()) {// line 86
		p("                    <tr>\n" + 
"                        <td><a href=\"");// line 86
		p(routes.Application.edit(computer.id));// line 88
		p("\">");// line 88
		p(computer.name);// line 88
		p("</a></td>\n" + 
"                        <td>\n" + 
"                            ");// line 88
		if(computer.introduced == null) {// line 90
		p("                                <em>-</em>\n" + 
"                            ");// line 90
		} else {// line 92
		p("                                ");// line 92
		p(format(computer.introduced, "dd MMM yyyy"));// line 93
		p("                            ");// line 93
		}// line 94
		p("                        </td>\n" + 
"                        <td>\n" + 
"                            ");// line 94
		if(computer.discontinued == null) {// line 97
		p("                                <em>-</em>\n" + 
"                            ");// line 97
		} else {// line 99
		p("                               	");// line 99
		p(format(computer.discontinued, "dd MMM yyyy"));// line 100
		p("                            ");// line 100
		}// line 101
		p("                        </td>\n" + 
"                        <td>\n" + 
"                            ");// line 101
		if(computer.company == null) {// line 104
		p("                                <em>-</em>\n" + 
"                            ");// line 104
		} else {// line 106
		p("                                ");// line 106
		p(computer.company.name);// line 107
		p("                            ");// line 107
		}// line 108
		p("                        </td>\n" + 
"                    </tr>\n" + 
"                ");// line 108
		}// line 111
		p("            </tbody>\n" + 
"        </table>\n" + 
"\n" + 
"        <div id=\"pagination\" class=\"pagination\">\n" + 
"            <ul>\n" + 
"                ");// line 111
		if(currentPage.hasPrev()) {// line 118
		p("                    <li class=\"prev\">\n" + 
"                        <a href=\"");// line 118
		p(link(currentPage.getPageIndex() - 1, null));// line 120
		p("\">&larr; Previous</a>\n" + 
"                    </li>\n" + 
"                ");// line 120
		} else {// line 122
		p("                    <li class=\"prev disabled\">\n" + 
"                        <a>&larr; Previous</a>\n" + 
"                    </li>\n" + 
"                ");// line 122
		}// line 126
		p("                <li class=\"current\">\n" + 
"                    <a>Displaying ");// line 126
		p(currentPage.getDisplayXtoYofZ());// line 128
		p("</a>\n" + 
"                </li>\n" + 
"                ");// line 128
		if(currentPage.hasNext()) {// line 130
		p("                    <li class=\"next\">\n" + 
"                        <a href=\"");// line 130
		p(link(currentPage.getPageIndex() + 1, null));// line 132
		p("\">Next &rarr;</a>\n" + 
"                    </li>\n" + 
"                ");// line 132
		} else {// line 134
		p("                    <li class=\"next disabled\">\n" + 
"                        <a>Next &rarr;</a>\n" + 
"                    </li>\n" + 
"                ");// line 134
		}// line 138
		p("            </ul>\n" + 
"        </div>\n" + 
"        \n" + 
"    ");// line 138
		}// line 142
		p("        \n" + 
"\n" + 
"            ");// line 142
		
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
		    p(routes.Application.list(newPage, sortBy, order, currentFilter));// line 28
		p("    \n");// line 29
		
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
// line 37
		p("    <th class=\"");// line 37
		p(key.replace(".","_"));// line 38
		p(" header ");// line 38
		p(currentSortBy.equals(key) ? currentOrder.equals("asc") ? "headerSortDown" : "headerSortUp" : "");// line 38
		p("\">\n" + 
"        <a href=\"");// line 38
		p(Application.link(currentSortBy, currentOrder, currentFilter, 0, key));// line 39
		p("\">");// line 39
		p(escape(title));// line 39
		p("</a>\n" + 
"    </th>\n");// line 39
		
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