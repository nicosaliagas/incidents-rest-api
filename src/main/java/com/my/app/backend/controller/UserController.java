package com.my.app.backend.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.my.app.backend.models.UserEntity;
import com.my.app.backend.service.UserService;

@RestController
@RequestMapping("/api")
public class UserController {
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
    private UserService userService;

	@RequestMapping(value = "/users", method = RequestMethod.GET)
	@ResponseBody
	public List<UserEntity> getUsers() {
		List<UserEntity> users = userService.list();

		logger.info("Users -> {}", users);

		return users;
	}
}
