package com.ecommerce.project.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.project.model.Post;
import com.ecommerce.project.model.SocialGroup;
import com.ecommerce.project.model.SocialUser;
import com.ecommerce.project.service.SocialService;

@RestController
public class SocialController {

	private SocialService socialService;

	public SocialController(SocialService socialService) {
		this.socialService = socialService;
	}

	@PostMapping("/social/users")
	public ResponseEntity<SocialUser> saveUser(@RequestBody SocialUser socialUser) {
		return new ResponseEntity<SocialUser>(socialService.saveUser(socialUser), HttpStatus.CREATED);
	}

	// get all users
	@GetMapping("/social/users")
	public ResponseEntity<List<SocialUser>> getUsers() {
		return ResponseEntity.ok(socialService.getAllUsers());
	}
	
	@GetMapping("/social/groups")
	public ResponseEntity<List<SocialGroup>> getAllGroups(){
		return new ResponseEntity<List<SocialGroup>>(socialService.getAllGroups(),HttpStatus.OK);
	}
	
	@GetMapping("/social/posts")
	public ResponseEntity<List<Post>> getAllPosts(){
		return new ResponseEntity<List<Post>>(socialService.getAllPosts(),HttpStatus.OK);
	}
}
