package com.example.demospringncc.dto;

import lombok.Data;

@Data
public class BillDTO {
    private  int id;
    private  String addr;
    private  String city;
    private  String phone;
    private int userId;
    private  String note;
    private long totalPrice;
}
