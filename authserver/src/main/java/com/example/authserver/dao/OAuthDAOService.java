package com.example.authserver.dao;

import com.example.authserver.model.UserEntity;

public interface OAuthDAOService {

	public UserEntity getUserDetails(String emailId);
	
}



