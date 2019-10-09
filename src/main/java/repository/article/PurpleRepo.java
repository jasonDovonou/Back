package repository.article;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import model.article.Purple;

public interface PurpleRepo extends JpaRepository<Purple, Long> {
	Purple findByName(String name);

	@Transactional
	void deleteByName(String name);

	@Query(value = "SELECT a from Purple a where a.name like %:name%")
	List<Purple> searchByName(String name);

	@Query(value = "FROM Purple where activated='true'")
	List<Purple> findAllActivated();
}
