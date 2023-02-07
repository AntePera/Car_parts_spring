package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Issues;

public interface IssueRepository extends JpaRepository<Issues,Integer>{
}
