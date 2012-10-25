package controllers;

import java.util.List;

import models.Computer;
import play.data.Form;
import play.data.Form.Field;
import play.data.validation.ValidationError;
import play.db.jpa.Transactional;
import play.mvc.Result;
import views.html.createForm;
import views.html.editForm;
import views.html.list;
import cn.bran.play.JapidController;

/**
 * Manage a database of computers
 */
public class Application extends JapidController {
    
    /**
     * This result directly redirect to application home.
     */
    public static Result GO_HOME = redirect(
        routes.Application.list(0, "name", "desc", "")
    );
    
    /**
     * Handle default path requests, redirect to computers list
     */
    public static Result index() {
        return GO_HOME;
    }

    /**
     * Display the paginated list of computers.
     *
     * @param page Current page number (starts from 0)
     * @param sortBy Column to be sorted
     * @param order Sort order (either asc or desc)
     * @param filter Filter applied on computer names
     */
    @Transactional(readOnly=true)
    public static Result list(int page, String sortBy, String order, String filter) {
//        return ok(
//            list.render(
//                Computer.page(page, 10, sortBy, order, filter),
//                sortBy, order, filter
//            )
//        );
    	return renderJapid(Computer.page(page, 10, sortBy, order, filter), sortBy, order, filter);
    }
    
    /**
     * Display the 'edit form' of a existing Computer.
     *
     * @param id Id of the computer to edit
     */
    @Transactional(readOnly=true)
    public static Result edit(Long id) {
        Form<Computer> computerForm = form(Computer.class).fill(
            Computer.findById(id)
        );
        return renderJapid(id, computerForm);
    }
    
    /**
     * Handle the 'edit form' submission 
     *
     * @param id Id of the computer to edit
     */
    @Transactional
    public static Result update(Long id) {
        Form<Computer> computerForm = form(Computer.class).bindFromRequest();
        if(computerForm.hasErrors()) {
            return badRequest(renderJapidWith("@edit.html", id, computerForm));
        }
        computerForm.get().update(id);
        flash("success", "Computer " + computerForm.get().name + " has been updated.");
        return GO_HOME;
    }
    
    /**
     * Display the 'new computer form'.
     */
    @Transactional(readOnly=true)
    public static Result create() {
        Form<Computer> computerForm = form(Computer.class);
//        return ok(
//            createForm.render(computerForm)
//        );

        // can return the result from renderJapid...()directly 
//        return renderJapidWith("@createForm.html", computerForm);
        // can also wrap the Japid result in ok() etc. 
        return ok(renderJapidWith("@createForm.html", computerForm));
    }
    
    /**
     * Handle the 'new computer form' submission 
     */
    @Transactional
    public static Result save() {
        Form<Computer> computerForm = form(Computer.class).bindFromRequest();
        if(computerForm.hasErrors()) {
        	Field fldn = computerForm.apply("name");
        	List<ValidationError> errors = fldn.errors();
        	System.out.println(errors);
//            return badRequest(createForm.render(computerForm));
//        	return renderJapidWith("@createForm.html", computerForm);
//        	return badRequest("bad");
        	return badRequest(renderJapidWith("@createForm.html", computerForm));
        }
        computerForm.get().save();
        flash("success", "Computer " + computerForm.get().name + " has been created");
        return GO_HOME;
    }
    
    /**
     * Handle computer deletion
     */
    @Transactional
    public static Result delete(Long id) {
        Computer.findById(id).delete();
        flash("success", "Computer has been deleted");
        return GO_HOME;
    }
    

}
            
