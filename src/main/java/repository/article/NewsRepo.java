package repository.article;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import model.article.News;

public interface NewsRepo extends JpaRepository<News, Long> {
	News findByName(String name);

	@Transactional
	void deleteByName(String name);

	@Query(value = "SELECT a from News a where a.name like %:name%")
	List<News> searchByName(String name);

	@Query(value = "FROM News where activated='true'")
	List<News> findAllActivated();
}
