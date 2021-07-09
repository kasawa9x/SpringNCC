package com.example.demospringncc.dto;

import lombok.Data;


@Data
public class ProductDTO {
    private  Long id;
    private  String name;
    private int categoryId;
    private long price;
    private  long weight;
    private String description;
    private String imageName;
}
