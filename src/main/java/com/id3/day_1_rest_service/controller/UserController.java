package com.id3.day_1_rest_service.controller;

import com.id3.day_1_rest_service.model.entity.User;
import com.id3.day_1_rest_service.service.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {

    private final IUserService userService;

    @GetMapping("/all")
    public ResponseEntity<List<User>> getAll(){
        return ResponseEntity.ok(userService.getAll());
    }

    @GetMapping("/byid")
    public ResponseEntity<User> getById(@RequestParam int id){
        return ResponseEntity.ok(userService.getUserById(id).orElseThrow());
    }

    @PostMapping
    public ResponseEntity<String> createUser(@RequestBody User user){
        userService.createUser(user);
        return ResponseEntity.ok("User created Successfully");

    }

    @PostMapping("/update")
    public ResponseEntity<String> updateUser(@RequestBody User user){
        userService.updateUser(user);
        return ResponseEntity.ok("user updated successfully");
    }

    @DeleteMapping
    public ResponseEntity<String> deleteUser(@RequestParam int id){
        userService.deleteUser(id);
        return ResponseEntity.ok("User Deleted successfully");
    }





}
