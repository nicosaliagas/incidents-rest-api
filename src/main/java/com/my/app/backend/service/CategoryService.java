package com.my.app.backend.service;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.my.app.backend.models.CategoryEntity;
import com.my.app.backend.repository.CategoryRepository;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository caterogyRepository;

    public List<CategoryEntity> list() {
        return caterogyRepository.findAll();
    }
}
