package repository.article;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import model.article.Blue;

public interface BlueRepo extends JpaRepository<Blue, Long> {
	Blue findByName(String name);

	@Transactional
	void deleteByName(String name);

	@Query(value = "SELECT j from Blue j where j.name like %:name%")
	List<Blue> searchByName(String name);

	@Query(value = "FROM Blue where activated='true'")
	List<Blue> findAllActivated();
}
