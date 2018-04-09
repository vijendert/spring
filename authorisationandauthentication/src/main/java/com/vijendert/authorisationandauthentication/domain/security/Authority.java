package com.vijendert.authorisationandauthentication.domain.security;

import java.io.Serializable;

import org.springframework.security.core.GrantedAuthority;

public class Authority implements GrantedAuthority, Serializable {
	/**
	 * Generated serialVersionUID
	 */
	private static final long serialVersionUID = 7768722198505971115L;

	private final String authority;

	public Authority(String authority) {
		this.authority = authority;
	}

	@Override
	public String getAuthority() {
		return this.authority;
	}

}
