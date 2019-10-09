package repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import model.Customer;

public interface CustomerRepo extends JpaRepository<Customer, Long> {

	@Query(value = "SELECT e from Customer e where e.email = :email")
	Customer findByEmail(String email);

	@Transactional
	@Modifying
	@Query(value = "UPDATE Customer SET reset_code=:resetCode WHERE id=:id")
	void updateResetById(Long id, String resetCode);

	@Transactional
	@Modifying
	@Query(value = "UPDATE Customer SET password=:password WHERE id = :id")
	void updatePasswordById(Long id, String password);

	@Transactional
	@Modifying
	@Query(value = "UPDATE Customer SET password=:password WHERE email = :email")
	void updatePasswordByEmail(String email, String password);

}
