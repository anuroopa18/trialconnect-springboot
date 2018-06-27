package webdev.TrialConnect.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import webdev.TrialConnect.models.Admin;



public interface AdminRepository extends CrudRepository<Admin,Integer> {
	
	@Query("SELECT a FROM Admin a WHERE a.username=:username AND a.password=:password")
	Optional<Admin> findUserByCredentials(
		@Param("username") String username, 
		@Param("password") String password);

}
