package com.my.app.backend.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.my.app.backend.dto.UserGetDto;
import com.my.app.backend.exceptions.ContrainteUniqueException;
import com.my.app.backend.models.Login;
import com.my.app.backend.models.User;
import com.my.app.backend.service.UserService;

@RestController
@RequestMapping("/api/auth")
public class LoginController {
	@Autowired
	private UserService userService;

	@Autowired
    private ModelMapper modelMapper;

	@PostMapping()
	public ResponseEntity<?> login(@Valid @RequestBody Login login) {
		try {
			User _user = userService.getUserByEmailAndPassword(login.getEmailAddress(), login.getPassword());
			return new ResponseEntity<>(convertToDto(_user), HttpStatus.OK);
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
