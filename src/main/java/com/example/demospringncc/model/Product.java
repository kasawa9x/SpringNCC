package com.example.demospringncc.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
//    @Column(name = "product_id")
    private  Long id;
    private  String name;
    @ManyToOne
    @JoinColumn(name = "category_id", referencedColumnName = "category_id")
    private  Category category;
    private double price;
    private  double weight;
    private String description;
    private String imageName;
}
