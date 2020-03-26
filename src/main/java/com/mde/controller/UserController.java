package com.mde.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mde.model.User;
import com.mde.repo.UserRepository;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserRepository repo;

	@PostMapping("/save")
	public ResponseEntity<User> saveUser(@RequestBody User user) {
		user.setId(UUID.randomUUID().toString());
		return ResponseEntity.ok(repo.save(user));
	}

	@GetMapping("/getAll")
	public ResponseEntity<?> getUser() {
		return ResponseEntity.ok(repo.findAll());
	}
}
