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

	private List<String> sicFilter;
	private String existing_customer;

	private String non_existing_customer;
	
	private String develop;
	private String negotiate;	
	
	public List<String> getSicFilter() {
		return sicFilter;
	}
	public void setSicFilter(List<String> sicFilter) {
		this.sicFilter = sicFilter;
	}
	public String getDevelop() {
		return develop;
	}
	public void setDevelop(String develop) {
		this.develop = develop;
	}

	public String getNegotiate() {
		return negotiate;
	}
	public void setNegotiate(String negotiate) {
		this.negotiate = negotiate;
	}

	public String getExisting_customer() {
		return existing_customer;
	}
	public void setExisting_customer(String existing_customer) {
		this.existing_customer = existing_customer;
	}
	public String getNon_existing_customer() {
		return non_existing_customer;
	}
	public void setNon_existing_customer(String non_existing_customer) {
		this.non_existing_customer = non_existing_customer;
	}
} // class User
