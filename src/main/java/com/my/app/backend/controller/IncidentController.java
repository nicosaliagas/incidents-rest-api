package com.my.app.backend.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.my.app.backend.models.CategoryEntity;
import com.my.app.backend.service.CategoryService;

@RestController
@RequestMapping("/api")
public class IncidentController {
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
    private CategoryService categoryService;

	@GetMapping("/categories")
	public List<CategoryEntity> getCategories() {
		List<CategoryEntity> categories = categoryService.list();

		logger.info("Catégories -> {}", categories);

		return categories;
	}
}
