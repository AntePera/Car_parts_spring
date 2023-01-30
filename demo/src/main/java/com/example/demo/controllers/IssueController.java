package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Issues;
import com.example.demo.services.IssueService;

@RestController
public class IssueController {
    
    @Autowired
    IssueService service;

    @GetMapping("/issues")
    public ResponseEntity<List<Issues>> getAll()
    {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/issues/{id}")
    public ResponseEntity<Issues> getById(@PathVariable int id)
    {
        return ResponseEntity.ok(service.getById(id));
    }

    @PostMapping("/issues")
    public ResponseEntity<Issues> add(@RequestBody Issues issue)
    {
        return ResponseEntity.ok(service.add(issue));
    }
}
