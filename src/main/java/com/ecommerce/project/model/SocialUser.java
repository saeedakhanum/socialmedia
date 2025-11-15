package com.ecommerce.project.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class SocialUser {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@OneToOne(mappedBy="socialUser")
	private SocialProfile socialProfile;
	
	@OneToMany(mappedBy="socialUser")
	private List<Post> posts;
	
	//one user will have one unique group so using set
	@ManyToMany
	@JoinTable(
			name="user_group",
			joinColumns=@JoinColumn(name="social_user_id"),
			inverseJoinColumns=@JoinColumn(name="social_group_id")
			)
	private Set<SocialGroup> socialgroups= new HashSet<>();
}
