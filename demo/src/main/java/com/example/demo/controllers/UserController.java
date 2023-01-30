package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Users;
import com.example.demo.services.UserService;

@RestController
public class UserController {
    
    @Autowired
    UserService service;

    @GetMapping("/users")
    public ResponseEntity<List<Users>> getAll()
    {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<Users> getById(@PathVariable int id)
    {
        return ResponseEntity.ok(service.getById(id));
    }

    @PostMapping("/users")
    public ResponseEntity<Users> add(@RequestBody Users user)
    {
        return ResponseEntity.ok(service.add(user));
    }
}
