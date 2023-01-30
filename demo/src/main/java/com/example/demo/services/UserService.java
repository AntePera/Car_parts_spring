package com.example.demo.services;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Users;
import com.example.demo.repositories.UserRepository;

@Service
public class UserService {
    
    @Autowired
    UserRepository repository;

    public List<Users> getAll()
    {
        return repository.findAll();
    }

    public Users getById(int id)
    {
        return repository.findById(id).orElseThrow(() -> new NoSuchElementException("NO USER PRESENT WITH ID = " + id));
    }

    public Users add(Users user)
    {
        return repository.save(user);
    }
}
