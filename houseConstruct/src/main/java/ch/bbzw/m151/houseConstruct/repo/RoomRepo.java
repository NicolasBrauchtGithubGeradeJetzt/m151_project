package ch.bbzw.m151.houseConstruct.repo;

import ch.bbzw.m151.houseConstruct.model.Room;
import ch.bbzw.m151.houseConstruct.model.Floor;
import ch.bbzw.m151.houseConstruct.model.Furniture;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomRepo extends CrudRepository<Room, Long> {
    //User checkPassword(String email, String password);

    Room findById(long id);

    Room findByFloor(Floor floor);

}
