package lookalike.query_builder;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import lookalike.models.CsdRequest;
import lookalike.models.DnBRequest;
import lookalike.models.OpportunityRequest;
import lookalike.models.ResponseDTO;  


public final class QueryBuilder {

  // ------------------------
  // PUBLIC METHODS
  // ------------------------
  
  /**
   * 
   * /create  --> Create a new user and save it in the database.
   * 
   * @param email User's email
   * @param name User's name
   * @return A string describing if the user is successfully created or not.
   */
  /**
   * /get-by-email  --> Return the id for the user having the passed email.
   * 
   * @param email The email to search in the database.
   * @return The user id or a message error if the user is not found.
   */
	
	public static List<ResponseDTO> Connect(OpportunityRequest opp, CsdRequest csd, DnBRequest dnb) {
		
	
	try{  
		Class.forName("com.mysql.jdbc.Driver");  
		Connection con=DriverManager.getConnection(  
		"jdbc:mysql://104.196.123.223:3306/lookalike_dashboard","root","li4m_ds_root");  
		//here sonoo is database name, root is username and password  
		Statement stmt=con.createStatement();
		List<ResponseDTO> response = new ArrayList<>();
		if (opp != null) {
			
			String qry = "Select count(*) AS total_count, CASE WHEN Score BETWEEN 90 and 95 then \"Low\" WHEN Score BETWEEN 96 and 100 then \"Med\" WHEN Score BETWEEN 101 and 105 then \"High\" END AS SLOT FROM opportunity WHERE Score > 90";
	
			if (opp.getHas_purchase_power() != null && opp.getHas_purchase_power().equals("Yes")) {
					qry = qry + " AND has_purchasepower = \"" + opp.getHas_purchase_power() + "\"";
			}
			if (opp.getGroupFilter() != null) {
				
				if (opp.getGroupFilter().contains("Others")) {
					qry += " AND customer_group_desc NOT IN (\"Commercial\",\"Strategic\") ";
				}
				String foo = String.join("\", \"", opp.getGroupFilter());
				if (foo != null) { 
					qry += " AND customer_group_desc IN (\"" + foo + "\")";
				}
			}
			qry += " GROUP BY SLOT";
			System.out.println(qry);
			
			
		ResultSet rs=stmt.executeQuery(qry);  
		while(rs.next()) {
			ResponseDTO re = new ResponseDTO();
		    String name = rs.getString("total_count");
		    String age  = rs.getString("SLOT");
		    re.setSlot(age);
		    re.setTotal_count(name);
		    System.out.println("abc");
		    response.add(re);
		    

		}
		
		return response;

			
		}
		else if (csd != null){
			int temp = 0;
			String qry = "Select count(*) AS total_count, CASE WHEN score BETWEEN 20 and 30 then \"Low\" WHEN score BETWEEN 30 and 50 then \"Med\" WHEN score BETWEEN 50 and 100 then \"High\" END AS SLOT FROM csd where score > 20";
			
			if(csd.getLabel_printer() != null && csd.getLabel_printer().equals("Yes")) {
					qry = qry + " AND label_printers = \"" + csd.getLabel_printer() + "\"";
				}
			if(csd.getMulticarrier_subscription() != null && csd.getMulticarrier_subscription().equals("Yes")) {
					qry = qry + " AND multicarrier_subscriptions = \"" + csd.getMulticarrier_subscription() + "\"";
				}
			if (csd.getSicFilter() != null) {
				if (csd.getSicFilter().contains("Others")) {
					temp = 1;
					qry += " AND (SIC_Category NOT IN (\"Finance & Real Estate\\r\",\"Health Service\\r\",\"Legal\\r\",\"Professional Services\\r\",\"Retail\\r\",\"Education\\r\",\"Manufacturing\\r\",\"Administration\\r\") ";
				}
				String foo = String.join("\", \"", csd.getSicFilter());
				if (foo != null && !foo.equals("")) {
					
					if (!(csd.getSicFilter().size() == 1 && csd.getSicFilter().contains("Others"))) {
						if (temp == 1) {
							qry += " OR";
						}
						else {
							qry += " AND";
						}
						qry += " SIC_Category IN (\"" + foo + "\")";
					}
					
				}
			}
			if (temp == 1) {
				qry += ")";
			}
			qry += " GROUP BY SLOT";
			System.out.println(qry);
			ResultSet rs=stmt.executeQuery(qry);  
			
			while(rs.next()) {
				ResponseDTO re = new ResponseDTO();
			    String name = rs.getString("total_count");
			    String age  = rs.getString("SLOT");
			    re.setSlot(age);
			    re.setTotal_count(name);
			    System.out.println("abc");
			    response.add(re);
			    

			}
			
			return response;

			
		}
		else if (dnb != null){
			String qry = "Select count(*) AS total_count, CASE WHEN score BETWEEN 4 and 8 then \"Low\" WHEN score BETWEEN 8 and 13 then \"Med\" WHEN score BETWEEN 13 and 18 then \"High\" END AS SLOT FROM dnb where score >4";
			System.out.println(qry);
			if (dnb.getEmployee_SIZE_RANGE() != null && dnb.getEmployee_SIZE_RANGE().equals("Yes")) {
				qry += " AND EMPLOYEE_SIZE_RANGE = \"21-50\""; 
			}
			if (dnb.getCategoryFilter() != null ) {
				String foo = String.join("\", \"", dnb.getCategoryFilter());
				if (foo != null) { 
					qry += " AND CATEGORY IN (\"" + foo + "\")";
				}
			}
			qry += " GROUP BY SLOT";
			System.out.println(qry);
			ResultSet rs=stmt.executeQuery(qry);  
			while(rs.next()) {
				ResponseDTO re = new ResponseDTO();
			    String name = rs.getString("total_count");
			    String age  = rs.getString("SLOT");
			    re.setSlot(age);
			    re.setTotal_count(name);
			    System.out.println("abc");
			    response.add(re);
			    

			}
			
			return response;
			}
	}catch(Exception e){ System.out.println(e);
		}
	return null;

	}
	
}  
 // class UserController
