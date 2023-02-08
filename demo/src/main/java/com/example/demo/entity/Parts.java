package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Parts {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private double price;
    private String domesticMarket;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="pi_fk")
    private Image image;
    private String partDescription;
    @OneToMany(targetEntity = Cars.class,cascade = CascadeType.ALL)
    @JoinColumn(name="pc_fk",referencedColumnName = "id")
    private List<Cars> carsList;
    @ManyToMany
    @JoinTable(name="parts_issues",
                joinColumns =@JoinColumn(name = "part_id"),
                inverseJoinColumns =@JoinColumn(name = "issue_id"))
    @JsonIgnore
    private Set<Issues>issues=new HashSet<>();

    public void addIssue(Issues issue)
    {
        issues.forEach(i -> {
            if(i.getId() == issue.getId())
            {
                throw new EntityExistsException("Issue is already added");
            }
        });
        issues.add(issue);
        issue.getParts().add(this);
    }

    public void addCar(Cars car)
    {
        carsList.forEach(c -> {
            if(c.getId() == car.getId())
            {
                throw new EntityExistsException("Car is already added");
            }
        });
        carsList.add(car);
    }


}


