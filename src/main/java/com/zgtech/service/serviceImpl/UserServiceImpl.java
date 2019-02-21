package com.zgtech.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zgtech.dao.UserMapper;
import com.zgtech.dto.User;
import com.zgtech.service.UserService;

@Service
@Transactional
public class UserServiceImpl implements UserService{
	@Autowired
	private UserMapper userDao;
	public User getUserByUserNameAndPwd(User user) {
		
		
		return userDao.getUserByUserNameAndPwd(user);
	}
	@Override
	public User getUserByNameAndPwd2(String userId, String pwd) {
		// TODO Auto-generated method stub
		return userDao.getUserByUserNameAndPwd2(userId,pwd);
	}
	@Override
	public void addUser(User user) {
		// TODO Auto-generated method stub
		userDao.addUser(user);
		return ;
	}
	
}
