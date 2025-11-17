package com.ecommerce.project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecommerce.project.model.SocialUser;

@Repository
public interface SocialUserRepository extends JpaRepository<SocialUser,Long>{

}
