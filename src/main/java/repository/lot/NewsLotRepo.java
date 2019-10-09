package repository.lot;

import org.springframework.data.jpa.repository.JpaRepository;

import model.lot.NewsLot;

public interface NewsLotRepo extends JpaRepository<NewsLot, Long> {

}
