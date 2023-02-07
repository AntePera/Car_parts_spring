package com.seminar.WebApp.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Set;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Part {
    private int id;
    private String name;
    private String domesticMarket;
    private String partDescription;
    private double price;
    private List<Car> carsList;
    private Set<Issue>setPart;
    
}
