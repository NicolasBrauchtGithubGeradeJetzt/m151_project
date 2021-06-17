package ch.bbzw.m151.houseConstruct.repo;

import ch.bbzw.m151.houseConstruct.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends CrudRepository<User, Long> {
    User checkPassword(String email, String password);
}
