package com.ecommerce.project;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.ecommerce.project.model.Post;
import com.ecommerce.project.model.SocialGroup;
import com.ecommerce.project.model.SocialProfile;
import com.ecommerce.project.model.SocialUser;
import com.ecommerce.project.repositories.PostRepository;
import com.ecommerce.project.repositories.SocialGroupRepository;
import com.ecommerce.project.repositories.SocialProfileRepository;
import com.ecommerce.project.repositories.SocialUserRepository;

@Configuration
public class DataInitializer {
	
	private final SocialUserRepository socialUserRepository;
	private final SocialGroupRepository socialGroupRepository;
	private final SocialProfileRepository socialProfileRepository;
	private final PostRepository postRepository;
	
	public DataInitializer(
			SocialUserRepository socialUserRepository,
			SocialGroupRepository socialGroupRepository,
			SocialProfileRepository socialProfileRepository,
			PostRepository postRepository
			) 
	{
		this.socialUserRepository=socialUserRepository;
		this.socialGroupRepository=socialGroupRepository;
		this.socialProfileRepository=socialProfileRepository;
		this.postRepository=postRepository;
	}
	
	@Bean
	public CommandLineRunner initializeData() {
		return args->{
			
			//create users
			SocialUser socialUser1= new SocialUser();
			SocialUser socialUser2= new SocialUser();
			SocialUser socialUser3= new SocialUser();
			
			//save user
			socialUserRepository.save(socialUser1);
			socialUserRepository.save(socialUser2);
			socialUserRepository.save(socialUser3);
			
			//create groups
			SocialGroup socialGroup1= new SocialGroup();
			SocialGroup socialGroup2= new SocialGroup();
			
			//Add users to the group
			socialGroup1.getSocialUsers().add(socialUser1);
			socialGroup1.getSocialUsers().add(socialUser2);
			socialGroup2.getSocialUsers().add(socialUser2);
			socialGroup2.getSocialUsers().add(socialUser3);
			
			//save groups to the database
			socialGroupRepository.save(socialGroup1);
			socialGroupRepository.save(socialGroup2);
			
			//create the posts
			Post post1= new Post();
			Post post2=new Post();
			Post post3= new Post();
			
			//Associate post with the user
			post1.setSocialUser(socialUser1);
			post2.setSocialUser(socialUser2);
			post3.setSocialUser(socialUser3);
			
			//save posts to the database
			postRepository.save(post1);
			postRepository.save(post2);
			postRepository.save(post3);
			
			
			//create social profiles
			SocialProfile socialProfile1= new SocialProfile();
			SocialProfile socialProfile2= new SocialProfile();
			SocialProfile socialProfile3= new SocialProfile();
			
			//associate profile with the user
			socialProfile1.setSocialUser(socialUser1);
			socialProfile2.setSocialUser(socialUser2);
			socialProfile3.setSocialUser(socialUser3);
			
			//saving social profiles into the database
			socialProfileRepository.save(socialProfile1);
			socialProfileRepository.save(socialProfile2);
			socialProfileRepository.save(socialProfile3);
			
			
			
		};
	}
	

}
