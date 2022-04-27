package com.training.web.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.training.web.security.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

	User findByUsername(String username);

}
