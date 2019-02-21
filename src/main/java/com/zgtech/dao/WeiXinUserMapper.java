  package com.zgtech.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.zgtech.dto.WeiXinFairMX;
import com.zgtech.dto.WeiXinFairZD;
import com.zgtech.dto.WeiXinUser;
@Repository
public interface WeiXinUserMapper {


	WeiXinUser getUserByWeiXinUser(@Param("weiXinUser") WeiXinUser weiXinUser);


	void addUserInfo(@Param("userInfos") WeiXinUser userInfos);


	String getJionCountByOpenId(@Param("openId") String openId);

	void createNewOpenIdTable(@Param("tableName") String userInfos);


	List<WeiXinFairZD> getJionFairZD();


	WeiXinFairMX getFairMX(@Param("formIp") String formIp);


	WeiXinFairMX getFairMXByFairNameAndOpenId(@Param("fair1") String fair1,@Param("openId")  String openId);


	void addMyIdIntoFair(@Param("fair1") String fair1,@Param("openId")  String openId);


	void addFairIntoMyOpenId(@Param("fair") String fair, @Param("openId1") String openId1);


	void addFairZDCount(@Param("fair") String fair);


	int getFariCountByFair(@Param("fair")  String fair);


	void addFairZDCount(@Param("fair") String fair,@Param("count1")  int count1);


	int getMyCountByOpenId(@Param("openId") String openId);


	void addMyCount(@Param("openId") String openId,@Param("myCount1")  int myCount1);


	void addFairsZD(@Param("fairName") String fairName, @Param("formIp") String formIp);


	void creatFairsMX(@Param("formIp1") String formIp1);


	

}
