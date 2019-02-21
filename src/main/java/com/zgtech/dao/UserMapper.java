  package com.zgtech.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.zgtech.dto.User;
@Repository
public interface UserMapper {

	User getUserByUserNameAndPwd(@Param("user") User user);

	User getUserByUserNameAndPwd2(@Param("userId") String userId,@Param("passWord") String pwd);

	void addUser(@Param("user") User user);

}
