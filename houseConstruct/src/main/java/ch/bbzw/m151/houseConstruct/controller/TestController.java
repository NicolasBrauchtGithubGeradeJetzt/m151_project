package ch.bbzw.m151.fruitshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/test")

public class TestController {
    @GetMapping("/")
    public String getAll() {
        return "test";
    }
}