package lookalike.models;

import java.util.List;

/**
 * An entity User composed by three fields (id, email, name).
 * The Entity annotation indicates that this class is a JPA entity.
 * The Table annotation specifies the name for the table in the db.
 *
 * @author netgloo
 */

public class CsdRequest {

	private String label_printer;
	private String multicarrier_subscription;
	private List<String> sicFilter;
	
	
	
	
	public String getLabel_printer() {
		return label_printer;
	}
	public void setLabel_printer(String label_printer) {
		this.label_printer = label_printer;
	}
	
	public String getMulticarrier_subscription() {
		return multicarrier_subscription;
	}
	public void setMulticarrier_subscription(String multicarrier_subscription) {
		this.multicarrier_subscription = multicarrier_subscription;
	}
	public List<String> getSicFilter() {
		return sicFilter;
	}
	public void setSicFilter(List<String> sicFilter) {
		this.sicFilter = sicFilter;
	}
	
	
} // class User