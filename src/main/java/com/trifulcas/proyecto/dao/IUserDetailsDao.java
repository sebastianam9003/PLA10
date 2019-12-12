package com.trifulcas.proyecto.dao;

import com.trifulcas.proyecto.model.User;

public interface IUserDetailsDao {
	User findUserByUsername(String username);
}
