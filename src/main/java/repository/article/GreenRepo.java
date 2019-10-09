package repository.article;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import model.article.Green;

public interface GreenRepo extends JpaRepository<Green, Long> {
	Green findByName(String name);

	@Transactional
	void deleteByName(String name);

	@Query(value = "SELECT p from Green p where p.name like %:name%")
	List<Green> searchByName(String name);

	@Query(value = "FROM Green where activated='true'")
	List<Green> findAllActivated();
}
