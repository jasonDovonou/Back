package repository.article;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import model.article.Yellow;

public interface YellowRepo extends JpaRepository<Yellow, Long> {
	Yellow findByName(String name);

	@Transactional
	void deleteByName(String name);

	@Query(value = "SELECT a from Yellow a where a.name like %:name%")
	List<Yellow> searchByName(String name);

	@Query(value = "FROM Yellow where activated='true'")
	List<Yellow> findAllActivated();
}
