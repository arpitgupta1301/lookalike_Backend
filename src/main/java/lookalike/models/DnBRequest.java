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

	private List<String> sicFilter;
	public List<String> getSicFilter() {
		return sicFilter;
	}
	public void setSicFilter(List<String> sicFilter) {
		this.sicFilter = sicFilter;
	}
	
	
	
} // class User