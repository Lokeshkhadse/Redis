package com.example.Redis.dao;


import com.example.Redis.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
public class UserDao {

//    @Autowired
//    private RedisTemplate<String,Object> redisTemplate;
//
//    private static final String KEY = "USER";  //object store under this key (user)
//
//    //save user
//    public User save(User user){
//
//        //because we storing data in key val pair that's y we use opsForHash().put(KEY,key,val)
//        redisTemplate.opsForHash().put(KEY,user.getUserId(),user);
//        return user;
//    }
//
//    //getUser
//    public User getUser(String userId){
//        //because we fetching data in key val pair that's y we use opsForHash().get(KEY,key)
//        return (User) redisTemplate.opsForHash().get(KEY,userId);
//
//    }
//
//    //findAll
//    public List<User> findAllUsers() {
//        Map<Object, Object> userMap = redisTemplate.opsForHash().entries(KEY);
//        return userMap.values().stream()
//                .map(obj -> (User) obj)
//                .collect(Collectors.toList());
//    }
//
//
//    //delete
//    public void delete(String userId){
//        redisTemplate.opsForHash().delete(KEY,userId);
//    }
//
//
//    //update
//    public User updateUser(String userId,User user){
//        User getUser = (User) redisTemplate.opsForHash().get(KEY,userId);
//        if (getUser == null) {
//            throw new RuntimeException("User not found");
//        }
//        getUser.setName(user.getName());
//
//        redisTemplate.opsForHash().put(KEY,userId,getUser);
//        return getUser;
//    }

    private final Map<String, User> userStore = new HashMap<>();

    // Save user
    public User save(User user) {
        userStore.put(user.getUserId(), user);
        return user;
    }

    // Get user by ID
    public User getUser(String userId) {
        return userStore.get(userId);
    }

    // Get all users
    public List<User> findAllUsers() {
        return new ArrayList<>(userStore.values());
    }

    // Delete user by ID
    public void delete(String userId) {
        userStore.remove(userId);
    }

    // Update user
    public User updateUser(String userId, User user) {
        User existingUser = userStore.get(userId);
        if (existingUser == null) {
            throw new RuntimeException("User not found");
        }
        existingUser.setName(user.getName());
        userStore.put(userId, existingUser);
        return existingUser;
    }








}
