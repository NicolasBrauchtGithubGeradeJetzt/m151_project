package ch.bbzw.m151.houseConstruct.controller;

import ch.bbzw.m151.houseConstruct.model.User;
import ch.bbzw.m151.houseConstruct.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(final UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public List<User> getAll() {
        return userService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<User> get(@PathVariable long id) {
        return userService.get(id);
    }

    @PostMapping("/")
    public User add(@RequestBody User u) {
        return null;
    }

    @PostMapping("/set/{id}")
    public User change(@RequestBody User u, @PathVariable long id) {
        return null;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id) {
        
    }
}