package lookalike.models;

import java.util.List;

/**
 * An entity User composed by three fields (id, email, name).
 * The Entity annotation indicates that this class is a JPA entity.
 * The Table annotation specifies the name for the table in the db.
 *
 * @author netgloo
 */

public class DnBRequest {

	private String employee_SIZE_RANGE;
	private List<String> categoryFilter;
	public String getEmployee_SIZE_RANGE() {
		return employee_SIZE_RANGE;
	}
	public void setEmployee_SIZE_RANGE(String employee_SIZE_RANGE) {
		this.employee_SIZE_RANGE = employee_SIZE_RANGE;
	}
	public List<String> getCategoryFilter() {
		return categoryFilter;
	}
	public void setCategoryFilter(List<String> categoryFilter) {
		this.categoryFilter = categoryFilter;
	}
	
	
	
	
} // class User