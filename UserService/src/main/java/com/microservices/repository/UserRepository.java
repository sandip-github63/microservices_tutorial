package com.microservices.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.microservices.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

	public Optional<User> findByUserId(Long userId);

	void deleteByUserId(Long userId);

}
