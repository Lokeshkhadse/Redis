package com.example.Redis.controller;

import com.example.Redis.model.User;
import com.example.Redis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/redis")
public class RedisController {

    @Autowired
    private UserService userService;

    @PostMapping("/createUser")
    public User createUser(@RequestBody User user) {
        user.setUserId(UUID.randomUUID().toString());
        return userService.save(user);
    }

    @GetMapping("/getUser/{userId}")
    public User getUser(@PathVariable String userId) {
        return userService.getUser(userId);
    }

    @PutMapping("/updateUser/{userId}")
    public User updateUser(@PathVariable String userId, @RequestBody User user) {
        return userService.update(userId, user);
    }

    @DeleteMapping("/deleteUser/{userId}")
    public void deleteUser(@PathVariable String userId) {
        userService.delete(userId);
    }

    @GetMapping("/findAllUsers")
    public List<User> findAllUsers() {
        return userService.findAllUsers();
    }


}
