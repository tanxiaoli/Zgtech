package com.zgtech.service;

import java.util.List;

import com.zgtech.dto.WeiXinFairMX;
import com.zgtech.dto.WeiXinFairZD;
import com.zgtech.dto.WeiXinUser;

public interface WeiXinUserService {

	WeiXinUser getUserByWeiXinUser(WeiXinUser weiXinUser);



	void addUserInfo(WeiXinUser userInfos);



	String getJionCountByOpenId(String tableName);
	
	void createNewOpenIdTable(String tableName);



	List<WeiXinFairZD> getJionFairZD();



	WeiXinFairMX getFairMX(String formIp);



	int addMyFair(String datas,String openId);



	void addMyFairs(String fairName, String formIp);

	

}
