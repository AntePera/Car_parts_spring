package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Parts;
import com.example.demo.services.PartService;

@RestController
public class PartController {
    
    @Autowired
    PartService service;

    @GetMapping("/parts")
    public ResponseEntity<List<Parts>> getAll()
    {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/parts/{id}")
    public ResponseEntity<Parts> getById(@PathVariable int id)
    {
        return ResponseEntity.ok(service.getById(id));
    }

    @PostMapping("/parts")
    public ResponseEntity<Parts> add(@RequestBody Parts part)
    {
        return ResponseEntity.ok(service.add(part));
    }
}
