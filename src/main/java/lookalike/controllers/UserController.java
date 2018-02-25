package lookalike.controllers;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;
import org.json.JSONString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.RequestEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import lookalike.models.CsdRequest;
import lookalike.models.DnBRequest;
import lookalike.models.OpportunityRequest;
import lookalike.models.ResponseDTO;
import lookalike.query_builder.CsvGenerator;
import lookalike.query_builder.QueryBuilder;


@Controller
@CrossOrigin
public class UserController {
	


	

  // ------------------------
  // PUBLIC METHODS
  // ------------------------
  
  /**
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
	   private static final String FILE_PATH = "D:/sample.csv";
	   @Autowired
	   private QueryBuilder queryBuilder;

	
	@RequestMapping(value = "getOpportunity", method = {RequestMethod.POST, RequestMethod.OPTIONS})
	public  @ResponseBody List<ResponseDTO> getOpportunity(@RequestBody OpportunityRequest opp) {
		
		//	QueryBuilder queryBuilder = new QueryBuilder();
	//	String query = queryBuilder.queryForOpportunity(SIC8);
		return QueryBuilder.Connect(opp, null, null);
	//	return opportunityDAO.findByAnyParameter(query);
	}
	@RequestMapping(value = "getCSD", method = RequestMethod.POST)
	public  @ResponseBody List<ResponseDTO> getCSD(@RequestBody CsdRequest csd) {
		
		//	QueryBuilder queryBuilder = new QueryBuilder();
	//	String query = queryBuilder.queryForOpportunity(SIC8);
		return QueryBuilder.Connect(null, csd, null);
	//	return opportunityDAO.findByAnyParameter(query);
	}
	@RequestMapping(value = "getDNB", method = RequestMethod.POST)
	public  @ResponseBody List<ResponseDTO> getDNB(@RequestBody DnBRequest dnb) {
		
		//	QueryBuilder queryBuilder = new QueryBuilder();
	//	String query = queryBuilder.queryForOpportunity(SIC8);
		return QueryBuilder.Connect(null, null, dnb);
	//	return opportunityDAO.findByAnyParameter(query);
	}
	
	
	@RequestMapping(value = "/getCSV", produces = "text/csv", method = RequestMethod.POST)
    public void getCSV(HttpServletResponse response,@RequestBody OpportunityRequest opp) throws IOException {
		
		String csvLoc = CsvGenerator.Connect(opp, null, null);
		InputStream in = new FileInputStream(csvLoc);
        response.setContentType("text/csv;charset=utf-8"); 
        response.setHeader("Content-disposition", "attachment; filename="+csvLoc);
        FileCopyUtils.copy(in, response.getOutputStream());
        response.flushBuffer();
       
    }
	
	
 /* @RequestMapping("/getOpportunity")
  @ResponseBody
  public String getByEmail(String email) {
    String userId;
    try {
      User user = userDao.findByEmail(email);
      userId = String.valueOf(user.getId());
    }
    catch (Exception ex) {
      return "User not found";
    }
    return "The user id is: " + userId;
  }*/

  @RequestMapping(value = "activeLeases", method = RequestMethod.POST)
  public @ResponseBody
  HashMap<String, String> activeLeases(HttpEntity<String> foo) {
  	JSONObject bar = new JSONObject(foo.getBody());
  	String current = bar.getString("current");
  	JSONObject commonFilters = bar.getJSONObject("commonFilter");
	return queryBuilder.runActiveleaseQuery(current, commonFilters);
  }
  
} // class UserController
