package com.ecommerce.project.model;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SocialUser {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@OneToOne(mappedBy="socialUser")
	private SocialProfile socialProfile;
	
	@OneToMany(mappedBy="socialUser")
	private List<Post> posts;
	
	//one user will have one unique group so using set
	@ManyToMany(mappedBy = "socialUsers")
	private Set<SocialGroup> socialgroups= new HashSet<>();


	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	
	
}
