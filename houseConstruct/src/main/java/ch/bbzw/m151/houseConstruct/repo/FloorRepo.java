package ch.bbzw.m151.houseConstruct.repo;

import ch.bbzw.m151.houseConstruct.model.Floor;
import ch.bbzw.m151.houseConstruct.model.Building;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FloorRepo extends CrudRepository<Floor, Long> {

    Floor findById(long id);

    Floor findByNumber(int number);

    Floor findByDescription(String description);

    Floor findByBuilding(Building building);

}
