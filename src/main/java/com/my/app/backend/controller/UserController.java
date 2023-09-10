package com.my.app.backend.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.my.app.backend.models.User;
import com.my.app.backend.service.UserService;

@RestController
@RequestMapping("/api")
public class UserController {
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/users", method = RequestMethod.GET)
	@ResponseBody
	public List<User> getUsers() {
		List<User> users = userService.list();

		logger.info("Users -> {}", users);

		return users;
	}

	@PostMapping("/users")
	public ResponseEntity<User> createUser(@RequestBody User newUser) {
		try {
			User _user = userService.newUser(new User(newUser.getLastName(), newUser.getFirstName(),
					newUser.getPhone(), newUser.getMail()));
			return new ResponseEntity<>(_user, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
