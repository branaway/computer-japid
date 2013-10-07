package models;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

import cn.bran.japid.template.AuthenticityCheck;

import play.data.format.Formats;
import play.data.validation.Constraints;
import play.db.jpa.JPA;

/**
 * Computer entity managed by JPA
 */
@Entity 
@SequenceGenerator(name = "computer_seq", sequenceName = "computer_seq")
@AuthenticityCheck // match this with a $authenticityToken() expression in your html forms or it will freak out!!
public class Computer {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "computer_seq")
    public Long id;
    
    @Constraints.Required
    public String name;
    
    @Formats.DateTime(pattern="yyyy-MM-dd")
    public Date introduced;
    
    @Formats.DateTime(pattern="yyyy-MM-dd")
    public Date discontinued;
    
    @ManyToOne(cascade = CascadeType.MERGE)
    public Company company;
   
    /**
     * Find a company by id.
     */
    public static Computer findById(Long id) {
        return JPA.em().find(Computer.class, id);
    }
    
    /**
     * Update this computer.
     */
    public void update(Long id) {
        if(this.company.id == null) {
            this.company = null;
        } else {
            this.company = Company.findById(company.id);
        }
        this.id = id;
        JPA.em().merge(this);
    }
    
    /**
     * Insert this new computer.
     */
    public void save() {
        if(this.company.id == null) {
            this.company = null;
        } else {
            this.company = Company.findById(company.id);
        }
        JPA.em().persist(this);
    }
    
    /**
     * Delete this computer.
     */
    public void delete() {
        JPA.em().remove(this);
    }
     
    /**
     * Return a page of computer
     *
     * @param page Page to display
     * @param pageSize Number of computers per page
     * @param sortBy Computer property used for sorting
     * @param order Sort order (either or asc or desc)
     * @param filter Filter applied on the name column
     */
    public static Page page(int page, int pageSize, String sortBy, String order, String filter) {
        if(page < 1) page = 1;
        Long total = (Long)JPA.em()
            .createQuery("select count(c) from Computer c where lower(c.name) like ?")
            .setParameter(1, "%" + filter.toLowerCase() + "%")
            .getSingleResult();
        List<Computer> data = JPA.em()
            .createQuery("from Computer c where lower(c.name) like ? order by c." + sortBy + " " + order)
            .setParameter(1, "%" + filter.toLowerCase() + "%")
            .setFirstResult((page - 1) * pageSize)
            .setMaxResults(pageSize)
            .getResultList();
        return new Page(data, total, page, pageSize);
    }
    
    /**
     * Used to represent a computers page.
     */
    public static class Page {
        
        private final int pageSize;
        private final long totalRowCount;
        private final int pageIndex;
        private final List<Computer> list;
        
        public Page(List<Computer> data, long total, int page, int pageSize) {
            this.list = data;
            this.totalRowCount = total;
            this.pageIndex = page;
            this.pageSize = pageSize;
        }
        
        public long getTotalRowCount() {
            return totalRowCount;
        }
        
        public int getPageIndex() {
            return pageIndex;
        }
        
        public List<Computer> getList() {
            return list;
        }
        
        public boolean hasPrev() {
            return pageIndex > 1;
        }
        
        public boolean hasNext() {
            return (totalRowCount/pageSize) >= pageIndex;
        }
        
        public String getDisplayXtoYofZ() {
            int start = ((pageIndex - 1) * pageSize + 1);
            int end = start + Math.min(pageSize, list.size()) - 1;
            return start + " to " + end + " of " + totalRowCount;
        }
        
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

	/**
	 * @return the introduced
	 */
	public Date getIntroduced() {
		return introduced;
	}

	/**
	 * @param introduced the introduced to set
	 */
	public void setIntroduced(Date introduced) {
		this.introduced = introduced;
	}

	/**
	 * @return the discontinued
	 */
	public Date getDiscontinued() {
		return discontinued;
	}

	/**
	 * @param discontinued the discontinued to set
	 */
	public void setDiscontinued(Date discontinued) {
		this.discontinued = discontinued;
	}

	/**
	 * @return the company
	 */
	public Company getCompany() {
		return company;
	}

	/**
	 * @param company the company to set
	 */
	public void setCompany(Company company) {
		this.company = company;
	}
    
}

