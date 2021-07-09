package com.example.demospringncc.service;

import com.example.demospringncc.model.Category;
import com.example.demospringncc.model.Product;
import com.example.demospringncc.respository.CategoryRespository;
import com.example.demospringncc.respository.ProductResponsitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class  ProductService {
    @Autowired
    ProductResponsitory productResponsitory;
    public List<Product> getAllProduct(){
        return productResponsitory.findAll();
    }
    public void addProduct(Product product){
        productResponsitory.save(product);
    }
    public void remoteProductById(long id){
        productResponsitory.deleteById(id);
    }

    public Optional<Product> getProductyById(long id) {
        return  productResponsitory.findById(id);
    }
    public List<Product> getAllProductByCategoryId(int id){
        return productResponsitory.findAllByCategory_Id(id);
    }
}
