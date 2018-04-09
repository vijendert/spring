package com.vijendert.authorisationandauthentication.domain.services.implemetation;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vijendert.authorisationandauthentication.domain.repositories.RoleRepository;
import com.vijendert.authorisationandauthentication.domain.repositories.UserRepository;
import com.vijendert.authorisationandauthentication.domain.security.User;
import com.vijendert.authorisationandauthentication.domain.security.UserRole;
import com.vijendert.authorisationandauthentication.domain.services.UserService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;

	@Autowired
	RoleRepository roleRepository;

	// @Transactional
	public User createUser(User user, Set<UserRole> userRoles) {
		User localUser = userRepository.findByUsername(user.getUsername());
		if (localUser != null) {
			log.warn("Username {} already exists", user.getUsername());
		} else {
			for (UserRole ur : userRoles) {
				roleRepository.save(ur.getRole());
			}
			user.getUserRoles().addAll(userRoles);
			localUser = userRepository.save(user);

		}
		return localUser;
	}

}
