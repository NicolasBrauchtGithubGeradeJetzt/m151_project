package ch.bbzw.m151.houseConstruct.controller;

import ch.bbzw.m151.houseConstruct.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/user")
public class UserController {

    @GetMapping("/")
    public List<User> getAll() {
        return null;
    }

    @GetMapping("/{id}")
    public Optional<User> get(@PathVariable long id) {
        return null;
    }

    @PostMapping("/")
    public User add(@RequestBody User u) {
        return null;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id) {
        
    }
}