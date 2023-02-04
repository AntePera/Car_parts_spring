package com.seminar.WebApp.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Issue {

    private int id;
    private String description;
    private String solution;
    
}
