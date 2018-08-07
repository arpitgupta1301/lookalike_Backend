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
		"jdbc:mysql://google/lookalike_dashboard?cloudSqlInstance=datatest-148118:us-east1:data-spine-cloud-sql-service&socketFactory=com.google.cloud.sql.mysql.SocketFactory","root","li4m_ds_root");  
		//here sonoo is database name, root is username and password  
		Statement stmt=con.createStatement();
		List<ResponseDTO> response = new ArrayList<>();
		if (opp != null) {
			int temp = 0;
			String qry = "Select count(*) AS total_count, CASE WHEN Score BETWEEN 3 and 11.99 then \"Low\" WHEN Score BETWEEN 12 and 23.99 then \"Med\" WHEN Score BETWEEN 24 and 68 then \"High\" END AS SLOT FROM opportunity WHERE Score >= 3";
	
			if (opp.getExisting_customer() != null && opp.getExisting_customer().equals("Yes")) {
				qry = qry + " AND isExisting = \"TRUE\" ";
			}
			if (opp.getNon_existing_customer() != null && opp.getNon_existing_customer().equals("Yes")) {
				qry = qry + " AND isExisting = \"FALSE\" ";
			}
			if (opp.getDevelop() != null && opp.getDevelop().equals("Yes")) {

				qry = qry + " AND Stage =  \"TRUE\\r\" ";

			}

			if (opp.getNegotiate() != null && opp.getNegotiate().equals("Yes")) {

				qry = qry + " AND Stage = \"FALSE\\r\" ";

			}


			if (opp.getSicFilter() != null) {
				if (opp.getSicFilter().contains("Others")) {
					temp = 1;
					qry += " AND (SIC_Category NOT IN (\"Finance & Real Estate\\r\",\"Health Services\\r\",\"Legal\\r\",\"Professional Services\\r\",\"Retail\\r\",\"Education\\r\",\"Manufacturing\\r\",\"Administration\\r\") ";
				}
				String foo = String.join("\", \"", opp.getSicFilter());
				if (foo != null && !foo.equals("")) {

					if (!(opp.getSicFilter().size() == 1 && opp.getSicFilter().contains("Others"))) {
						if (temp ==1 ){
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
		else if (csd != null){
			String qry = "Select count(*) AS total_count, CASE WHEN score BETWEEN 0 and 1.931327940 then \"Low\" WHEN score BETWEEN 1.931327941 and 4.470103592 then \"Med\" WHEN score BETWEEN 4.470103593 and 500 then \"High\" END AS SLOT FROM csd where score >= 0";
		
			int temp = 0;	
			if(csd.getLabel_printer() != null && csd.getLabel_printer().equals("Yes")) {
					qry = qry + " AND label_printers = \"" + csd.getLabel_printer() + "\"";
				}
			if(csd.getMulticarrier_subscription() != null && csd.getMulticarrier_subscription().equals("Yes")) {
					qry = qry + " AND multicarrier_subscriptions = \"" + csd.getMulticarrier_subscription() + "\"";
				}
			if (csd.getSicFilter() != null) {
				if (csd.getSicFilter().contains("Others")) {
					temp = 1;
					qry += " AND (SIC_Category NOT IN (\"Finance & Real Estate\",\"Health Services\",\"Legal\",\"Professional Services\",\"Retail\",\"Education\",\"Manufacturing\",\"Administration\") ";
				}
				String foo = String.join("\", \"", csd.getSicFilter());
				if (foo != null && !foo.equals("")) {

					if (!(csd.getSicFilter().size() == 1 && csd.getSicFilter().contains("Others"))) {
						if (temp ==1 ){
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
			String qry = "Select count(*) AS total_count, CASE WHEN new_scaled_score BETWEEN 0 and 199.99 then \"Low\" WHEN new_scaled_score BETWEEN 200 and 599.99 then \"Med\" WHEN new_scaled_score BETWEEN 600 and 10000 then \"High\" END AS SLOT FROM dnb_may where new_scaled_score >= 0";
			System.out.println(qry);
			int temp = 0;
			if (dnb.getSicFilter() != null) {
				if (dnb.getSicFilter().contains("Others")) {
					temp = 1;
					qry += " AND (SIC_CATEGORY NOT IN (\"Finance & Real Estate\",\"Health Services\",\"Legal\",\"Professional Services\",\"Retail\",\"Education\",\"Manufacturing\",\"Administration\") ";
				}
				String foo = String.join("\", \"", dnb.getSicFilter());
				if (foo != null && !foo.equals("")) {

					if (!(dnb.getSicFilter().size() == 1 && dnb.getSicFilter().contains("Others"))) {
						if (temp ==1 ){
                                                qry += " OR";
                                        }
	                                else {
                                                qry += " AND";
       	                                }

						qry += " SIC_CATEGORY IN (\"" + foo + "\")";
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
	}catch(Exception e){ System.out.println(e);
		}
	return null;

	}
	
}  
 // class UserController
