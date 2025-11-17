package com.ecommerce.project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecommerce.project.model.Post;

@Repository
public interface PostRepository extends JpaRepository<Post,Long>{

}
