package lookalike.models;

import java.util.List;

/**
 * An entity User composed by three fields (id, email, name).
 * The Entity annotation indicates that this class is a JPA entity.
 * The Table annotation specifies the name for the table in the db.
 *
 * @author netgloo
 */

public class OpportunityRequest {

	private String has_purchase_power;
	private List<String> groupFilter;
	
	
	public String getHas_purchase_power() {
		return has_purchase_power;
	}
	public void setHas_purchase_power(String has_purchase_power) {
		this.has_purchase_power = has_purchase_power;
	}
	public List<String> getGroupFilter() {
		return groupFilter;
	}
	public void setGroupFilter(List<String> groupFilter) {
		this.groupFilter = groupFilter;
	}
	
} // class User