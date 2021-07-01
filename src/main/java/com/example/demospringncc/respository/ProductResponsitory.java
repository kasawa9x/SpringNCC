package com.example.demospringncc.respository;

import com.example.demospringncc.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductResponsitory extends JpaRepository<Product,Long> {
    List<Product> findAllByCategory_Id(int id);
}
