package com.paymentprocess.io.user_account_service.controller;

import org.springframework.web.bind.annotation.RestController;

import com.paymentprocess.io.user_account_service.entity.User;
import com.paymentprocess.io.user_account_service.model.UserResponseDTO;
import com.paymentprocess.io.user_account_service.service.UserService;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
@RequestMapping("/users")
public class UserController {
    
    private static final String USER_SAVED_MESSAGE = "User Successfully Saved";
    private UserService userService;

    public UserController(UserService userService){
        this.userService =  userService;
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<UserResponseDTO> getUserDetailsById(@PathVariable Long id) {
        
        return ResponseEntity.ok(userService.getUserById(id));
    }

    @PostMapping("/saveUser")
    public String saveUser(@RequestBody User user) {
        userService.saveUser(user);
        return USER_SAVED_MESSAGE;
    }
    @GetMapping("/findAll")
    public ResponseEntity<List<UserResponseDTO>> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }



}
