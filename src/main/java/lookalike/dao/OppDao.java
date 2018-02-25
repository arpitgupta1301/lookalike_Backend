package lookalike.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public class OppDao {

	
	@Autowired
	private static JdbcTemplate jdbcTemplate;
	
	
	
	public static void testConn() {
		
		try {
			Connection conn  = jdbcTemplate.getDataSource().getConnection();
			
			ResultSet rs = conn.createStatement().executeQuery("Select 1 ");
			
			System.out.println(",,,,,,,,,,,,,,,,,,,,");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
}
