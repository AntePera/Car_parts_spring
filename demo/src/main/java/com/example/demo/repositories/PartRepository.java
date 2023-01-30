package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Parts;

public interface PartRepository extends JpaRepository<Parts,Integer>{
    
}
