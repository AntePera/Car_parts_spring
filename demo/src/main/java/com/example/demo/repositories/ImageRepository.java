package com.example.demo.repositories;

import org.springframework.core.io.Resource;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Image;

import java.util.Optional;


public interface ImageRepository extends JpaRepository<Image,Integer>{


}
