package com.example.demospringncc.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class BillDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "billdetail_id")
    private  int id;
    @ManyToOne
    @JoinColumn(name = "bill_id", referencedColumnName = "bill_id")
    private Bill bill;
    @ManyToOne
    @JoinColumn(name = "product_id", referencedColumnName = "product_id")
    private Product product;
}
