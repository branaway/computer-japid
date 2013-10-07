package models;

import java.util.*;
import javax.persistence.*;

import play.data.format.*;
import play.data.validation.*;

import play.db.jpa.*;

/**
 * Company entity managed by JPA
 */
@Entity 
public class Company {

    @Id
    public Long id;
    
    @Constraints.Required
    public String name;
    
    public static Company findById(Long id) {
        return JPA.em().find(Company.class, id);
    }

    public static Map<String,String> options() {
        List<Company> companies = JPA.em().createQuery("from Company order by name").getResultList();
        LinkedHashMap<String,String> options = new LinkedHashMap<String,String>();
        for(Company c: companies) {
            options.put(c.id.toString(), c.name);
        }
        return options;
    }

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

}

