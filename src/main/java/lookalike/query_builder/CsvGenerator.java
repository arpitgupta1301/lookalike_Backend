package lookalike.query_builder;

import java.io.FileWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;

import com.opencsv.CSVWriter;

import lookalike.models.CsdRequest;
import lookalike.models.DnBRequest;
import lookalike.models.OpportunityRequest;  


public final class CsvGenerator {

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
	
	public static String Connect(OpportunityRequest opp, CsdRequest csd, DnBRequest dnb) {
		
	try{  
		Class.forName("com.mysql.jdbc.Driver");  
		Connection con=DriverManager.getConnection(  
		"jdbc:mysql://104.196.123.223:3306/lookalike_dashboard","root","li4m_ds_root");  
		//here sonoo is database name, root is username and password  
		Statement stmt=con.createStatement();
		String qry = null;
		if (opp != null) {
			
			qry = "Select * FROM opportunity WHERE Score > 90";
	
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
			System.out.println(qry);
		}
		ResultSet rs=stmt.executeQuery(qry);
		
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		
		String csv = "output"+timestamp.getTime()+".csv";
		CSVWriter writer = new CSVWriter(new FileWriter(csv));
		writer.writeAll(rs,true);
		writer.close();
		return csv;
		
	}
	catch(Exception e) {
		System.out.println(e);
	}
	return null;
}  
}
 // class UserController
