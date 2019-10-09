package repository.article;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import model.article.White;

public interface WhiteRepo extends JpaRepository<White, Long> {
	White findByName(String name);

	@Transactional
	void deleteByName(String name);

	@Query(value = "SELECT a from White a where a.name like %:name%")
	List<White> searchByName(String name);

	@Query(value = "FROM White where activated='true'")
	List<White> findAllActivated();
}
