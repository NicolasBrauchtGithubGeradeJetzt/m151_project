package ch.bbzw.m151.houseConstruct.service;

import ch.bbzw.m151.houseConstruct.model.User;
import ch.bbzw.m151.houseConstruct.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@CacheConfig(cacheNames = {"user"})
public class UserService {

    private final UserRepo userRepo;

    @Autowired
    public UserService(final UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Transactional(readOnly = true)
    @Cacheable(key = "0")
    public List<User> getAll() {
        final Iterable<User> user = userRepo.findAll();
        return StreamSupport
                .stream(user.spliterator(), false)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    @Cacheable(key = "#id", unless = "#result == null")
    public Optional<User> get(final long id) {
       return Optional.ofNullable(userRepo.findById(id));
    }
}