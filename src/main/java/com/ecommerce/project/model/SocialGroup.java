package com.ecommerce.project.model;

import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class SocialGroup {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	//One group will have one unique user
	@ManyToMany(mappedBy="socialgroups")
	private Set<SocialUser> socialUsers;

}
