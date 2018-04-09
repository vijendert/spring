package com.vijendert.authorisationandauthentication.domain.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.vijendert.authorisationandauthentication.domain.security.User;

public interface UserRepository extends CrudRepository<User, Long> {
	public User findByUsername(String username);

	public User findByEmail(String email);

	public List<User> findAll();

}
