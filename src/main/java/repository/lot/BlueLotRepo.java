package repository.lot;

import org.springframework.data.jpa.repository.JpaRepository;

import model.Lot;
import model.lot.BlueLot;

public interface BlueLotRepo<T extends Lot> extends JpaRepository<BlueLot, Long> {

}
