package com.seminar.WebApp.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Part {
    private int id;
    private String name;
    private String domesticMarket;
    private String partDescription;

    private double price;
    
}
