package com.laptrinhjavaweb.service;

import com.laptrinhjavaweb.model.UserModel;

public interface IUserService {
	UserModel findByUsernameAndPasswordAndStatus(String userName, String passWord, Integer status);
}
