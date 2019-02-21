package com.zgtech.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zgtech.common.PageModel;
import com.zgtech.service.UserService;
/*
 * SVN + Maven + SpringMVC + Spring(IOC,DI) + Mybatis + C3p0 + freemarker
 * 
 * Sun定义了三层架构   web---service---dao
 * Web项目均采用MVC分层设计模式
 * 
 */

/*
 * @Autowired根据类型进行注入对象实例
 * @Qulited根据名字进行注入对象实例
 * @Resource 相当于  @Autowired + @Qulited
 * @Resource("userService")如果加了名字则根据名字来注入，没有则根据类型来
 */
@Controller
public class UserController {
	@Autowired
	private UserService userService;
	@Autowired
	private PageModel pageModel;
	
	
	@RequestMapping("/UserList")
	public String getUsers() {
		
		return "success";
		
	}

}
