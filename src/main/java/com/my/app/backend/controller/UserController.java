package com.my.app.backend.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.my.app.backend.exceptions.ContrainteUniqueException;
import com.my.app.backend.models.User;
import com.my.app.backend.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private UserService userService;

	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public List<User> getUsers() {
		List<User> users = userService.list();

		logger.info("Users -> {}", users);

		return users;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public User getUser(@PathVariable Long id) {

		User user = userService.findUserById(id);

		logger.info("User -> {}", user);

		return user;
	}

	@RequestMapping(value = "/mail/{mail}", method = RequestMethod.GET)
	@ResponseBody
	public Optional<User> findUserByEmail(@PathVariable String mail) {

		Optional<User> user = userService.findUserByMail(mail);

		logger.info("User -> {}", user);

		return user;
	}

	@PostMapping()
	public ResponseEntity<?> createUser(@Valid @RequestBody User newUser) {
		try {
			User _user = userService.saveUser(new User(newUser.getLastName(), newUser.getFirstName(),
					newUser.getPhone(), newUser.getMail()));
			return new ResponseEntity<>(_user, HttpStatus.CREATED);
		} catch (ContrainteUniqueException ex) {
			return ResponseEntity.badRequest().body(ex.getMessage());
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping()
	public ResponseEntity<?> putUser(@Valid @RequestBody User updateUser) {
		try {
			User _user = userService.findUserById(updateUser.getId());
			
			_user.setFirstName(updateUser.getFirstName());
			_user.setLastName(updateUser.getLastName());
			_user.setPhone(updateUser.getPhone());
			
			return new ResponseEntity<>(userService.saveUser(_user), HttpStatus.OK);
		} catch (ContrainteUniqueException ex) {
			return ResponseEntity.badRequest().body(ex.getMessage());
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
