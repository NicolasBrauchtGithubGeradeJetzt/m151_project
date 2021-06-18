package ch.bbzw.m151.houseConstruct.repo;

import ch.bbzw.m151.houseConstruct.model.User;
import ch.bbzw.m151.houseConstruct.model.Person;
import ch.bbzw.m151.houseConstruct.model.Group;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends CrudRepository<User, Long> {
    User checkPassword(String email, String password);

    User findById(long id);

    User findByPassword(String password);

    User findByPerson(Person person);

    User findByGroup(Group group);

}
