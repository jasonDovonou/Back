package repository.article;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import model.article.Brown;

public interface BrownRepo extends JpaRepository<Brown, Long> {
	Brown findByName(String name);

	@Transactional
	void deleteByName(String name);

	@Query(value = "SELECT e from Brown e where e.name like %:name%")
	List<Brown> searchByName(String name);

	@Query(value = "FROM Brown where activated='true'")
	List<Brown> findAllActivated();
}
