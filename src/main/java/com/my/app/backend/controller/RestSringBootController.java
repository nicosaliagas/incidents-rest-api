package com.my.app.backend.controller;

import java.util.Arrays;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class RestSringBootController {

	@RequestMapping("/hello")
	public String hello() {
		return "Hello World!";
	}
	
	@GetMapping(value = "/callclienthello")
	public String getClientHello() {
		String uri = "http://localhost:8080/hello";
		RestTemplate restTemplate = new RestTemplate();
		return restTemplate.getForObject(uri, String.class);
	}

	@GetMapping(value = "/countries")
	public java.util.List<Object> getCountries() {
		String uri = "https://restcountries.com/v3.1/all";
		RestTemplate restTemplate = new RestTemplate();

		Object[] countries = restTemplate.getForObject(uri, Object[].class);

		return Arrays.asList(countries);
	}

}
