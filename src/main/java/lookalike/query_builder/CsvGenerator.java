package lookalike.query_builder;

import java.io.FileWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;
import com.opencsv.CSVWriter;
import lookalike.models.CommonCsvRequest;  


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

	

	public static String Connect(CommonCsvRequest comm, String typeName) {

		

	try{  

		Class.forName("com.mysql.jdbc.Driver");  

		Connection con=DriverManager.getConnection(  

		"jdbc:mysql://google/lookalike_dashboard?cloudSqlInstance=datatest-148118:us-east1:data-spine-cloud-sql-service&socketFactory=com.google.cloud.sql.mysql.SocketFactory","root","li4m_ds_root");  

		//here sonoo is database name, root is username and password  

		Statement stmt=con.createStatement();

		String qry = null;

		if (typeName.equals("opp")) {

			

			int temp = 0;

			qry = "Select ship_to_account_number, ach_setup, cc_setup, auto_pay, paperless, customer_group_desc, has_purchasepower, CATEGORY, SIC8_new, score, SIC_Category, isExisting, Stage, segmentation_code FROM opportunity WHERE Score >= 3";

	

			if (comm.getExisting_customer() != null && comm.getExisting_customer().equals("Yes")) {

				qry = qry + " AND isExisting = \"TRUE\" ";

			}

			if (comm.getNon_existing_customer() != null && comm.getNon_existing_customer().equals("Yes")) {

				qry = qry + " AND isExisting = \"FALSE\" ";

			}

			if (comm.getDevelop() != null && comm.getDevelop().equals("Yes")) {

				qry = qry + " AND Stage =  \"TRUE\\r\" ";

			}

			if (comm.getNegotiate() != null && comm.getNegotiate().equals("Yes")) {

				qry = qry + " AND Stage = \"FALSE\\r\" ";

			}



			if (comm.getSicFilter() != null) {

				if (comm.getSicFilter().contains("Others")) {

					temp = 1;

					qry += " AND (SIC_Category NOT IN (\"Finance & Real Estate\\r\",\"Health Services\\r\",\"Legal\\r\",\"Professional Services\\r\",\"Retail\\r\",\"Education\\r\",\"Manufacturing\\r\",\"Administration\\r\") ";

				}

				String foo = String.join("\", \"", comm.getSicFilter());

				if (foo != null && !foo.equals("")) {



					if (!(comm.getSicFilter().size() == 1 && comm.getSicFilter().contains("Others"))) {

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

			System.out.println(qry);

		}

		if (typeName.equals("csd")) {

			

			qry = "Select sales_rep, bpn, meter_type, purchase_power_exists, ach_setup, autopay, creditcard, paperless, customer_group_desc, to_totalmopayment, fr_totalmopayment, to_term, seg_mkt_code, seg_sam_list, seg_meter_segment, seg_postage_segment, seg_shipping_segment, account_package_enabled, label_printers, multicarrier_subscriptions, professional_installs, electronic_return_receipt, saas_subscription, saas_mailing_subscription, saas_shipping_subscription, CATEGORY, one_Quarter_Annual_Change_Spend, two_Quarter_Annual_Change_Spend, three_Quarter_Annual_Change_Spend, one_Quarter_Annual_Change_Txn, two_Quarter_Annual_Change_Txn, three_Quarter_Annual_Change_Txn, eligible_pieces, eligible_spend, potential_savings, score, SIC_Category, segmentation_code FROM csd where score >= 0";

			

			int temp = 0;	

			if(comm.getLabel_printer() != null && comm.getLabel_printer().equals("Yes")) {

					qry = qry + " AND label_printers = \"" + comm.getLabel_printer() + "\"";

				}

			if(comm.getMulticarrier_subscription() != null && comm.getMulticarrier_subscription().equals("Yes")) {

					qry = qry + " AND multicarrier_subscriptions = \"" + comm.getMulticarrier_subscription() + "\"";

				}

			if (comm.getSicFilter() != null) {

				if (comm.getSicFilter().contains("Others")) {

					temp = 1;

					qry += " AND (SIC_Category NOT IN (\"Finance & Real Estate\",\"Health Services\",\"Legal\",\"Professional Services\",\"Retail\",\"Education\",\"Manufacturing\",\"Administration\") ";

				}

				String foo = String.join("\", \"", comm.getSicFilter());

				if (foo != null && !foo.equals("")) {



					if (!(comm.getSicFilter().size() == 1 && comm.getSicFilter().contains("Others"))) {

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

			System.out.println(qry);

		}

		if (typeName.equals("dnb")) {

			

			qry = "Select name as Name, facebook, linkedin, twitter, employee_size, Category, SIC2_Code, AVG_HOUSEHOLD_INCOME, MAX_EDUCATION, ETHNICITY_GROUP, MAX_AGE_GROUP, TOTAL_POPULATION, CAMEO_GROUP, CAMEO_CATEGORY, num_locations, num_regions, Social_Presence, SIC_CATEGORY, shipping_score, shipping_scaled_score, combined_score, combined_scaled_score as Score, PHONE, EMAIL, new_scaled_score, new_score FROM dnb_may where new_scaled_score >= 0";

			System.out.println(qry);

			int temp = 0;

			if (comm.getSicFilter() != null) {

				if (comm.getSicFilter().contains("Others")) {

					temp = 1;

					qry += " AND (SIC_CATEGORY NOT IN (\"Finance & Real Estate\",\"Health Services\",\"Legal\",\"Professional Services\",\"Retail\",\"Education\",\"Manufacturing\",\"Administration\") ";

				}

				String foo = String.join("\", \"", comm.getSicFilter());

				if (foo != null && !foo.equals("")) {



					if (!(comm.getSicFilter().size() == 1 && comm.getSicFilter().contains("Others"))) {

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


