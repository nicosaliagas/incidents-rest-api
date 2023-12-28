package com.my.app.backend.controller;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.my.app.backend.dto.UserGetDto;
import com.my.app.backend.exceptions.ContrainteUniqueException;
import com.my.app.backend.models.User;
import com.my.app.backend.service.UserService;
import com.my.app.backend.validation.CreateUserValidation;

@RestController
@RequestMapping("/api/users")
public class UserController {
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private UserService userService;

	@Autowired
    private ModelMapper modelMapper;

	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public List<User> getUsers() {
		List<User> users = userService.list();

		logger.info("Users -> {}", users);

		return users;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public UserGetDto getUser(@PathVariable UUID id) {

		User user = userService.findUserById(id);

		logger.info("User -> {}", user);

		return convertToDto(user);
	}

	@PostMapping()
	public ResponseEntity<?> createUser(@Validated(CreateUserValidation.class) @RequestBody User newUser) {
		try {
			User _user = userService.saveUser(new User(newUser.getLastName(), newUser.getFirstName(), newUser.getEmailAddress(), newUser.getPassword()));
			return new ResponseEntity<>(convertToDto(_user), HttpStatus.CREATED);
		} catch (ContrainteUniqueException ex) {
			return ResponseEntity.badRequest().body(ex.getMessage());
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping()
	public ResponseEntity<?> putUser(@Valid @RequestBody User updateUser) {
		try {
			User user = userService.findUserById(updateUser.getId());
			
			user.setFirstName(updateUser.getFirstName());
			user.setLastName(updateUser.getLastName());
			user.setEmailAddress(updateUser.getEmailAddress());

			return new ResponseEntity<>(convertToDto(userService.saveUser(user)), HttpStatus.OK);
		} catch (ContrainteUniqueException ex) {
			return ResponseEntity.badRequest().body(ex.getMessage());
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	private UserGetDto convertToDto(User user) {
		UserGetDto userGetDto = modelMapper.map(user, UserGetDto.class);
		
		return userGetDto;
	}
}
