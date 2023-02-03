package com.seminar.WebApp.entities;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class User {

    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String role;

    public boolean hasRole(String roleName) {
        if (this.role.equals(roleName)) {
            return true;
        } 
        return false;
        }
    
    }
