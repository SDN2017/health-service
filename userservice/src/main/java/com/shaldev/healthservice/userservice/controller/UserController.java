package com.shaldev.healthservice.userservice.controller;

import com.shaldev.healthservice.userservice.dto.UserRequest;
import com.shaldev.healthservice.userservice.dto.UserResponse;
import com.shaldev.healthservice.userservice.model.User;
import com.shaldev.healthservice.userservice.service.UserService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
@AllArgsConstructor
public class UserController {
    private UserService userService;

    @GetMapping("/{userId}")
    public ResponseEntity<UserResponse> getUser(@PathVariable String userId){
        return ResponseEntity.ok(userService.getUserProfile(userId));
    }

    @PostMapping("/create")
    public  ResponseEntity<UserResponse> addUser(@Valid @RequestBody UserRequest user){
        return ResponseEntity.ok(userService.addUser(user));
    }
}
