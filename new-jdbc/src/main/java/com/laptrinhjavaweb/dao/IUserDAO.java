package com.laptrinhjavaweb.dao;

import com.laptrinhjavaweb.model.UserModel;

public interface IUserDAO extends GenericDAO<UserModel> {
	UserModel findByUsernameAndPasswordAndStatus(String userName, String passWord, Integer status);
}
