package com.my.app.backend.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.my.app.backend.models.Category;
import com.my.app.backend.models.Incident;
import com.my.app.backend.service.CategoryService;
import com.my.app.backend.service.IncidentService;

@RestController
@RequestMapping("/api")
public class IncidentController {
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
    private CategoryService categoryService;

	@Autowired
    private IncidentService incidentService;

	@GetMapping("/incident-categories")
	public List<Category> getCategories() {
		List<Category> categories = categoryService.list();

		logger.info("Catégories -> {}", categories);

		return categories;
	}

	@GetMapping("/incidents")
	public List<Incident> getIncidents() {
		return incidentService.list();
	}

	@PostMapping("/incidents")
	public ResponseEntity<Incident> createIncident(@RequestBody Incident newIncident) {
		try {
			Incident _incident = incidentService.newIncident(new Incident(newIncident.getDescription(), newIncident.getCategory(), newIncident.getUser()));
			return new ResponseEntity<>(_incident, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
