package com.example.demospringncc.GlobalData;

import com.example.demospringncc.model.Bill;
import com.example.demospringncc.model.Product;

import java.util.ArrayList;
import java.util.List;

public class GlobalData {
    public static List<Product> cart;
    static {
        cart = new ArrayList<Product>();
    }
    public static List<Bill> bill;
    static {
        bill = new ArrayList<Bill>();
    }
}
