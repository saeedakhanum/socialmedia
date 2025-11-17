package com.ecommerce.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.project.model.Post;
import com.ecommerce.project.model.SocialGroup;
import com.ecommerce.project.model.SocialUser;
import com.ecommerce.project.repositories.PostRepository;
import com.ecommerce.project.repositories.SocialGroupRepository;
import com.ecommerce.project.repositories.SocialUserRepository;

@Service 
public class SocialService {

	@Autowired
	private SocialUserRepository socialUserRepository;
	@Autowired
	private SocialGroupRepository socialGroupRepository;
	@Autowired
	private PostRepository postRepository;

	
	public List<SocialUser> getAllUsers(){
		return socialUserRepository.findAll();
	}
	
	public SocialUser saveUser(SocialUser socialUser) {
		return socialUserRepository.save(socialUser);
	}

	public List<SocialGroup> getAllGroups() {
		return socialGroupRepository.findAll();

	}
	
	public List<Post> getAllPosts() {
		return postRepository.findAll();

	}
}
