package repository.article;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import model.article.Red;

public interface RedRepo extends JpaRepository<Red, Long> {

	Red findByName(String name);

	@Transactional
	void deleteByName(String name);

	@Query(value = "SELECT r from Red r where r.name like %:name%")
	List<Red> searchByName(String name);

	@Query(value = "FROM Red where activated='true'")
	List<Red> findAllActivated();

}
