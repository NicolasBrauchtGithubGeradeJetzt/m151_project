package ch.bbzw.m151.houseConstruct.service;

import ch.bbzw.m151.houseConstruct.model.User;
import ch.bbzw.m151.houseConstruct.model.Group;
import ch.bbzw.m151.houseConstruct.model.UserGroup;
import ch.bbzw.m151.houseConstruct.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class LoginService {

    private final UserRepo userRepo;

    @Autowired
    public LoginService(final UserRepo userRepo) {
        this.userRepo = userRepo;
    }
    
    @Transactional(readOnly = true)
    public Optional<UserGroup> login(final String email, final String password) {
        /*if (redisTemplate.opsForHash().hasKey(REDIS_KEY, username)) {
            return Optional.of(UserGroup.valueOf(redisTemplate.opsForHash().get(REDIS_KEY, username).toString()));
        }*/
        System.out.println("Login initiated");
        System.out.println("Email -> " + email);
        System.out.println("Password -> " + password);
        final User user = userRepo.checkPassword(email, password);
        if (user != null) {
            System.out.println("Login success");
            //redisTemplate.opsForHash().put(REDIS_KEY, user.getUsername(), user.getUserGroup().toString());
            return Optional.of((user.getGroup()).getUserGroup());
        }
        System.out.println("Login failed");
        
        return Optional.empty();
    }
}