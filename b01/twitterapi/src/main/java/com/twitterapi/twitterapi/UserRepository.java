package com.twitterapi.twitterapi;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface UserRepository extends JpaRepository<User, Integer>, CrudRepository<User, Integer> {

    User findByUsernameAndPassword(String username, String password);
	User findById(int id);
	User findByUsername(String username);
	
}