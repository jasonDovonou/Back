package repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import model.Auth;

public interface AuthRepo extends JpaRepository<Auth, Long> {

	@Query(value ="SELECT u FROM Auth u WHERE u.username = :username and u.password = :password")
	Auth check(String username, String password);
}
