package com.ayryu.project.kezuru.content.rest;

import com.ayryu.project.kezuru.content.services.UserService;
import com.ayryu.project.kezuru.content.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserRestController {

    private UserService userService;

    @Autowired
    public UserRestController(UserService theUserService) {
        userService = theUserService;
    }

    @GetMapping("/users")
    public List<User> findAll() {
        return userService.findAll();
    }

    //Adds mapping for GET /users/{userId}

    @GetMapping("/users/{userId}")
    public User getUser(@PathVariable int userId) {

        User theUser = userService.findById(userId);

        if(theUser == null) {
            throw new RuntimeException("User id was not found - " + userId);
        }
        return theUser;
    }

    //Adding a new employee
    //@RequestBody binds JSON user data received from the client to a given User object
    @PostMapping("/users")
    public User addUser(@RequestBody User theUser) {

        //In case they pass an id in JSON, set the id to 0
        //this is to force a save of a new item - an insert instead of an update

        theUser.setId(0);

        userService.save(theUser);

        return theUser;
    }

    @PutMapping("/users")
    public User updateUser(@RequestBody User theUser) {
        userService.save(theUser);
        return theUser;
    }

    @DeleteMapping("/users/{userId}")
    public String deleteUser(@PathVariable int userId) {

        User theUser = userService.findById(userId);

        if(theUser == null) {
            throw new RuntimeException("User ID not found: " + userId);
        }
        userService.deleteById(userId);
        return "Deleted user ID: " + userId;
    }
}























