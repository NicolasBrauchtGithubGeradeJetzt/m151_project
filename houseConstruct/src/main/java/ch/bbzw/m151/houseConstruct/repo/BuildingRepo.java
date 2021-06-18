package ch.bbzw.m151.houseConstruct.repo;

import ch.bbzw.m151.houseConstruct.model.Building;
import ch.bbzw.m151.houseConstruct.model.Person;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BuildingRepo extends CrudRepository<Building, Long> {
    //User checkPassword(String email, String password);

    Building findById(long id);

    Building findByDescription(String description);

    Building findByAdress(String adress);

    Building findByPrice(float price);

    Building findByPerson(Person person);

}
