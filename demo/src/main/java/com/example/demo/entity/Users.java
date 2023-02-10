package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    @ManyToMany
    @JoinTable(name="parts_users",
            joinColumns =@JoinColumn(name = "part_id"),
            inverseJoinColumns =@JoinColumn(name = "user_id"))
    private List<Parts> orderList;
    private String role;

}
