package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@Getter
@Setter
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    }
