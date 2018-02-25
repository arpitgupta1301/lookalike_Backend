/*package lookalike.models;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

@Transactional
public interface DnbDAO extends JpaRepository<Dnb, Long> {

  *//**
   * Return the user having the passed email or null if no user is found.
   * 
   * @param email the user email.
   *//*
	
	@Query("select count(*) from Opportunity where Score>=20")
    public Double findByAnyParameter(@Param("SIC8") String text);
	
	
} // class UserDao
*/