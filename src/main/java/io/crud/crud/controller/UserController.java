package io.crud.crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.crud.crud.model.User;
import io.crud.crud.repository.UserRepository;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
@CrossOrigin
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserRepository userRepository;
    
    @GetMapping("/")
    List<User> getAllUsers(){
        return userRepository.findAll();
    }

    @GetMapping("/{id}")
    User getUser(@PathVariable String id){
        return userRepository.findById(id).orElse(null);
    }

    @PostMapping("/")
    User getUser(@RequestBody User user){
        return userRepository.save(user);
    }

    @PutMapping("/{id}")
    User getUser(@PathVariable String id, @RequestBody User user){
        User oldUser = userRepository.findById(id).orElse(null);
        oldUser.setName(user.getName());
        oldUser.setPassword(user.getPassword());
        oldUser.setEmail(user.getEmail());
        return userRepository.save(oldUser);
    }

    @DeleteMapping("/{id}")
    String deleteUser(@PathVariable String id){
        userRepository.deleteById(id);
        return id;
    }
}
    
