package com.vijendert.authorisationandauthentication.domain.services;

import java.util.Set;

import com.vijendert.authorisationandauthentication.domain.security.User;
import com.vijendert.authorisationandauthentication.domain.security.UserRole;

public interface UserService {
	User createUser(User user, Set<UserRole> userRoles);
}
