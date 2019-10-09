package repository.article;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import model.article.Promotion;

public interface PromotionRepo extends JpaRepository<Promotion, Long> {
	Promotion findByName(String name);

	@Transactional
	void deleteByName(String name);

	@Query(value = "SELECT a from Promotion a where a.name like %:name%")
	List<Promotion> searchByName(String name);

	@Query(value = "FROM Promotion where activated='true'")
	List<Promotion> findAllActivated();
}
