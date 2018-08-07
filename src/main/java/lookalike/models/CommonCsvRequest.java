package lookalike.models;



import java.util.List;



/**

 * An entity User composed by three fields (id, email, name).

 * The Entity annotation indicates that this class is a JPA entity.

 * The Table annotation specifies the name for the table in the db.

 *

 * @author netgloo

 */



public class CommonCsvRequest {



    private List<String> sicFilter;

    private String existing_customer;

    private String develop;

    private String negotiate;

    private String non_existing_customer;

    private String label_printer;

    private String multicarrier_subscription;

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
  

	public List<String> getSicFilter() {

		return sicFilter;

	}

	public void setSicFilter(List<String> sicFilter) {

		this.sicFilter = sicFilter;

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





	

	

	

} // class User
