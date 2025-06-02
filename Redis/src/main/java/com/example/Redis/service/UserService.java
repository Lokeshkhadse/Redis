package com.example.Redis.service;


import com.example.Redis.dao.UserDao;
import com.example.Redis.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
//@CacheConfig(cacheNames = "users")  // Common cache name for all methods
public class UserService {

    private static final String CACHE_NAME = "users";

    @Autowired
    private UserDao userDao;

    @Cacheable(value = CACHE_NAME,key = "#userId")
    public User getUser(String userId) {
        return userDao.getUser(userId); // hit Redis manually only if not in cache
    }

    @CachePut(value = CACHE_NAME, key = "#user.userId")
    public User save(User user) {
        return userDao.save(user); // update cache
    }

    @CacheEvict(value = CACHE_NAME, key = "#userId")
    public void delete(String userId) {
        userDao.delete(userId); // remove from cache too
    }

    @CachePut(value = CACHE_NAME, key = "#userId")
    public User update(String userId, User user) {
        return userDao.updateUser(userId, user);
    }

    @Cacheable(value = CACHE_NAME)
    public List<User> findAllUsers() {
        return userDao.findAllUsers();
    }

}
