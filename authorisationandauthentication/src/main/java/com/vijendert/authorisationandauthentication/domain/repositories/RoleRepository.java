package com.vijendert.authorisationandauthentication.domain.repositories;

import org.springframework.data.repository.CrudRepository;

import com.vijendert.authorisationandauthentication.domain.security.Role;

public interface RoleRepository extends CrudRepository<Role, Long> {

}
