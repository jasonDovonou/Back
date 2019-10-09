package repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import model.Orders;

public interface OrderRepo extends JpaRepository<Orders, Long> {
	Orders findByNumber(String number);

	@Transactional
	@Modifying
	@Query(value = "UPDATE Orders SET number=:number WHERE id=:id")
	void updateNumberById(Long id, String number);

}
