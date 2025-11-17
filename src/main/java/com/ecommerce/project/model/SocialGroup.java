package com.ecommerce.project.model;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SocialGroup {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	//One group will have one unique user
	@ManyToMany
	@JoinTable(
			name="user_group",
			joinColumns=@JoinColumn(name="social_group_id"),
			inverseJoinColumns=@JoinColumn(name="social_user_id")
			)
	@JsonIgnore
	private Set<SocialUser> socialUsers = new HashSet<>();



	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	
	
	

}
