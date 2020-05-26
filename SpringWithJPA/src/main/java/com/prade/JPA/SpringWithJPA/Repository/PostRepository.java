package com.prade.JPA.SpringWithJPA.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.prade.JPA.SpringWithJPA.Entity.Post;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

@Repository
public interface PostRepository extends JpaRepository<Post, Integer> {

}