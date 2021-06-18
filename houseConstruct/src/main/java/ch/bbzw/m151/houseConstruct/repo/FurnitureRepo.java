package ch.bbzw.m151.houseConstruct.repo;

import ch.bbzw.m151.houseConstruct.model.Furniture;
import ch.bbzw.m151.houseConstruct.model.Room;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FurnitureRepo extends CrudRepository<Furniture, Long> {

    Furniture findById(long id);

    Furniture findByDescription(String description);

    Furniture findByPrice(float price);

}
