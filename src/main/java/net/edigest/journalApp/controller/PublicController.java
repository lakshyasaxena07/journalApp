package net.edigest.journalApp.controller;

import net.edigest.journalApp.entity.User;
import net.edigest.journalApp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/public")
public class PublicController {

    @Autowired
    private UserService userService;

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAll();
    }

    @PostMapping("/create")
    public void createUser(@RequestBody User user) {
        userService.saveNewUser(user);
    }
}
