package repository.article;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import model.article.Gold;

public interface GoldRepo extends JpaRepository<Gold, Long> {
	Gold findByName(String name);

	@Transactional
	void deleteByName(String name);

	@Query(value = "SELECT t from Gold t where t.name like %:name%")
	List<Gold> searchByName(String name);

	@Query(value = "FROM Gold where activated='true'")
	List<Gold> findAllActivated();
}
