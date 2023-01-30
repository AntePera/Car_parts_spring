package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Image;
import com.example.demo.services.ImageService;

@RestController
public class ImageController {
    
    @Autowired
    ImageService service;

    @GetMapping("/images")
    public ResponseEntity<List<Image>> getAll()
    {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/images/{id}")
    public ResponseEntity<Image> getById(@PathVariable int id)
    {
        return ResponseEntity.ok(service.getById(id));
    }

    @PostMapping("/images")
    public ResponseEntity<Image> add(@RequestBody Image image)
    {
        return ResponseEntity.ok(service.add(image));
    }
}
