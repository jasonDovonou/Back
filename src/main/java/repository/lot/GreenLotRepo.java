package repository.lot;

import org.springframework.data.jpa.repository.JpaRepository;

import model.lot.GreenLot;

public interface GreenLotRepo extends JpaRepository<GreenLot, Long> {

}
