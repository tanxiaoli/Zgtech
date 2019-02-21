package com.zgtech.service;

import com.zgtech.dto.User;

public interface UserService {

	User getUserByUserNameAndPwd(User user);

	User getUserByNameAndPwd2(String userId, String pwd);

	void addUser(User user);

}
