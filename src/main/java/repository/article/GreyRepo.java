package repository.article;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import model.article.Grey;

public interface GreyRepo extends JpaRepository<Grey, Long> {
	Grey findByName(String name);

	List<Grey> findAllByGrey(String grey);

	@Transactional
	void deleteByName(String name);

	@Query(value = "SELECT h from Grey h where h.name like %:name%")
	List<Grey> searchByName(String name);

	@Query(value = "FROM Grey where activated='true'")
	List<Grey> findAllActivated();

	@Query(value = "FROM Grey where activated='true' and type=:type")
	List<Grey> findAllActivatedByType(String type);
}
