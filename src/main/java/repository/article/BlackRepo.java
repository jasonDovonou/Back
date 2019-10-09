package repository.article;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import model.article.Black;

public interface BlackRepo extends JpaRepository<Black, Long> {
	Black findByName(String name);

	@Transactional
	void deleteByName(String name);

	@Query(value = "SELECT t from Black t where t.name like %:name%")
	List<Black> searchByName(String name);

	@Query(value = "FROM Black where activated='true'")
	List<Black> findAllActivated();
}
