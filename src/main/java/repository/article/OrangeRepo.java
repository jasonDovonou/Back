package repository.article;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import model.article.Orange;

public interface OrangeRepo extends JpaRepository<Orange, Long> {
	Orange findByName(String name);

	@Transactional
	void deleteByName(String name);

	@Query(value = "SELECT a from Orange a where a.name like %:name%")
	List<Orange> searchByName(String name);

	@Query(value = "FROM Orange where activated='true'")
	List<Orange> findAllActivated();
}
