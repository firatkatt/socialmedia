package com.project.socialmedia.controller;

import com.project.socialmedia.model.User;
import com.project.socialmedia.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }
    @PostMapping
    public User createUser(@RequestBody User newUser){
        return userService.createUser(newUser);
    }
    @GetMapping("/{userId}")
    public Optional<User> getOneUser(@PathVariable Long userId){
        return userService.getOneUser(userId);
    }
    @PutMapping("/{userId}")
    public User updateOneUser(@PathVariable Long userId,@RequestBody User newUser){
       return userService.updateUser(userId,newUser);
    }
    @DeleteMapping("/{userId}")
    public void deleteOneUser(@PathVariable Long userId){
        userService.deleteByUser(userId);
    }
}
