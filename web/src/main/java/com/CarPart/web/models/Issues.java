package com.CarPart.web.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name="issues")
public class Issues {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    @OneToMany(mappedBy = "issue", cascade = CascadeType.ALL)
    private List<Solutions> solutions = new ArrayList<>();
    @ManyToOne
    @JoinColumn(name = "parts_id",nullable = true)
    private Parts part;
};

