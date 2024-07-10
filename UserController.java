package com.wakefit.ecommerce.controller;

import com.wakefit.ecommerce.entity.Customer;
import com.wakefit.ecommerce.entity.User;
import com.wakefit.ecommerce.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/User/add")
    public User createUser(@RequestBody User user) {
        return userService.saveUser(user);
    }
    
//    @PutMapping("/User/update")
//    public User updateUser(@PathVariable Long id, @RequestBody User user) {
//        return userService.updateUser(id, user);
//    }


    @GetMapping("/User/{id}")
    public User getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @GetMapping("/User/all/{id}")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @DeleteMapping("/User/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }
}
