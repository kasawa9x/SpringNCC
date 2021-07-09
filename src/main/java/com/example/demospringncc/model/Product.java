package com.example.demospringncc.model;

import lombok.Data;


import javax.persistence.*;
import java.util.Collection;
import java.util.Set;

@Entity
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "product_id")
    private  Long id;
    private  String name;
    @ManyToOne
    @JoinColumn(name = "category_id", referencedColumnName = "category_id")
    private  Category category;
    private long price;
    private  long weight;
    private String description;
    private String imageName;

}
