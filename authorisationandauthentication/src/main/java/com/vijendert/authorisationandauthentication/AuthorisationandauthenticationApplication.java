package com.vijendert.authorisationandauthentication;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.vijendert.authorisationandauthentication.domain.config.SecurityUtility;
import com.vijendert.authorisationandauthentication.domain.security.Role;
import com.vijendert.authorisationandauthentication.domain.security.User;
import com.vijendert.authorisationandauthentication.domain.security.UserRole;
import com.vijendert.authorisationandauthentication.domain.services.UserService;

@SpringBootApplication
public class AuthorisationandauthenticationApplication implements CommandLineRunner {

	@Autowired
	private UserService userService;

	public static void main(String[] args) {
		SpringApplication.run(AuthorisationandauthenticationApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		/*User user1 = new User();
		user1.setEmail("vijendert@gmail.com");
		user1.setFirstName("Vijender");
		user1.setLastName("thakur");
		user1.setPassword(SecurityUtility.passwordEncoder().encode("p"));
		user1.setUserName("vijendert");
		Set<UserRole> userRoles = new HashSet<>();
		Role role1 = new Role();
		role1.setName("ROLE_USER");
		role1.setRoleId(1);
		
		userRoles.add(new UserRole(user1, role1));
		
		us.createUser(user1, userRoles);
		
		userRoles.clear();
		
		User user2 = new User();
		user2.setEmail("admin@gmail.com");
		user2.setFirstName("admin");
		user2.setLastName("thakur");
		user2.setPassword(SecurityUtility.passwordEncoder().encode("p"));
		user2.setUserName("admin");
		Role role2 = new Role();
		role2.setName("ROLE_ADMIN");
		role2.setRoleId(2);
		
		userRoles.add(new UserRole(user2, role2));
		
		us.createUser(user2, userRoles);*/
		User user1 = new User();
		user1.setFirstName("John");
		user1.setLastName("Adams");
		user1.setUsername("j");
		user1.setPassword(SecurityUtility.passwordEncoder().encode("gs"));
		user1.setEmail("JAdams@gmail.com");
		Set<UserRole> userRoles = new HashSet<>();
		Role role1 = new Role();
		role1.setRoleId(1);
		role1.setName("ROLE_USER");
		userRoles.add(new UserRole(user1, role1));

		userService.createUser(user1, userRoles);

		userRoles.clear();

		User user2 = new User();
		user2.setFirstName("Admin");
		user2.setLastName("Admin");
		user2.setUsername("admin");
		user2.setPassword(SecurityUtility.passwordEncoder().encode("gs"));
		user2.setEmail("Admin@gmail.com");
		Role role2 = new Role();
		role2.setRoleId(0);
		role2.setName("ROLE_ADMIN");
		userRoles.add(new UserRole(user2, role2));

		userService.createUser(user2, userRoles);

	}
}
