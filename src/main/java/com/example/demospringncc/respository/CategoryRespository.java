package com.example.demospringncc.respository;

import com.example.demospringncc.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRespository extends JpaRepository<Category,Integer> {

}
