package com.resto.restoapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.resto.restoapp.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	
	public User  findByUser(String user);
}
