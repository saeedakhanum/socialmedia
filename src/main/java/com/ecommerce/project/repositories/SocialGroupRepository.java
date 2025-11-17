package com.ecommerce.project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecommerce.project.model.SocialGroup;

@Repository
public interface SocialGroupRepository extends JpaRepository<SocialGroup,Long> {

}
