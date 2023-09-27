package com.lgs.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.lgs.model.User;
import com.lgs.model.services.UserService;

@RestController
@RequestMapping(name = "/users")
public class UserController {
	@Autowired
	private final UserService Uservice;

	public UserController(UserService service) {
		this.Uservice = service;
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<User> findById(@PathVariable Long id){
		var user = Uservice.findById(id);
		return ResponseEntity.ok(user);
	}
	
	@PostMapping("/{id}")
	public ResponseEntity<User> Create(@RequestBody User user){
		var userCreated = Uservice.create(user);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(userCreated.getId()).toUri();
		return ResponseEntity.created(location).body(userCreated);
	}
	
}
