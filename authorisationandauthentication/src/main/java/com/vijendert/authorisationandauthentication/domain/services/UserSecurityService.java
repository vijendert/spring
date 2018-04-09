package com.vijendert.authorisationandauthentication.domain.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.vijendert.authorisationandauthentication.domain.repositories.UserRepository;
import com.vijendert.authorisationandauthentication.domain.security.User;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class UserSecurityService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByUsername(username);
		if (null == user) {
			log.warn("Username {} not found ", username);
			throw new UsernameNotFoundException("Username " + username + " not found");
		}
		return user;
	}

}
