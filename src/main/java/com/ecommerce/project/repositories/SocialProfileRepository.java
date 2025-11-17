package com.ecommerce.project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecommerce.project.model.SocialProfile;

@Repository
public interface SocialProfileRepository extends JpaRepository<SocialProfile,Long>{

}
