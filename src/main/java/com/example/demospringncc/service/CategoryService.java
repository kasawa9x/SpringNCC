package com.example.demospringncc.service;

import com.example.demospringncc.model.Category;
import com.example.demospringncc.respository.CategoryRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
    @Autowired
    CategoryRespository categoryRespository;
    public List<Category> getAllCategory(){
        return categoryRespository.findAll();
    }
    public void addCategory(Category category){
        categoryRespository.save(category);
    }
    public void remoteCategoryById(int id){
        categoryRespository.deleteById(id);
    }

    public Optional<Category> getCategoryById(int id) {
        return  categoryRespository.findById(id);
    }
}
