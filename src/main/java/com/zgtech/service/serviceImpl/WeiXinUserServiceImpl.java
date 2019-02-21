package com.zgtech.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zgtech.dao.UserMapper;
import com.zgtech.dao.WeiXinUserMapper;
import com.zgtech.dto.User;
import com.zgtech.dto.WeiXinFairMX;
import com.zgtech.dto.WeiXinFairZD;
import com.zgtech.dto.WeiXinUser;
import com.zgtech.service.UserService;
import com.zgtech.service.WeiXinUserService;

@Service
@Transactional
public class WeiXinUserServiceImpl implements WeiXinUserService{
	@Autowired
	private WeiXinUserMapper weiXinUserDao;
	
	@Override
	public WeiXinUser getUserByWeiXinUser(WeiXinUser weiXinUser) {
		// TODO Auto-generated method stub
		//System.out.println("==================into==weixinUserServiceImpl=");
		return weiXinUserDao.getUserByWeiXinUser(weiXinUser);
	}

	

	@Override
	public void addUserInfo(WeiXinUser userInfos) {
		weiXinUserDao.addUserInfo(userInfos);
		
	}



	@Override
	public String getJionCountByOpenId(String openId) {
		// TODO Auto-generated method stub
		return weiXinUserDao.getJionCountByOpenId(openId);
	}
	
	
	@Override
	public void createNewOpenIdTable(String tableName) {
		weiXinUserDao.createNewOpenIdTable(tableName);
		
	}



	@Override
	public List<WeiXinFairZD> getJionFairZD() {
		// TODO Auto-generated method stub
		return weiXinUserDao.getJionFairZD();
	}



	@Override
	public WeiXinFairMX getFairMX(String formIp) {
		// TODO Auto-generated method stub
		return weiXinUserDao.getFairMX(formIp);
	}



	@Override
	public int addMyFair(String datas,String openId) {
		// TODO Auto-generated method stub
		//1.将人的openId增加到该场地中以便查询有哪些人来过这个场地
		//{"guiyangtiyuguan":"0","baolishimaoguan":"0","zhanjiangtiyuchang":"1"}
		
		String []  datasStrArray = datas.substring(1, datas.length()-1).split(",");
		for(int i=0;i<datasStrArray.length;i++) {
			String fair=datasStrArray[i].substring(1, datasStrArray[i].length()-5);
			String rol=datasStrArray[i].substring( datasStrArray[i].length()-2, datasStrArray[i].length()-1);
	//	System.out.println("=================fair+rol:"+fair+"=="+rol);
		String fair1="wx_fair_"+fair;
		
		
		int rol1=Integer.parseInt(rol);
		if(rol1==1) {
			//判断该场地是否存在本人的去过记录
			WeiXinFairMX mydatas=weiXinUserDao.getFairMXByFairNameAndOpenId(fair1,openId);
		//	System.out.println("===================mydata:"+mydatas);
			if(mydatas==null||"".equals(mydatas)) {
				weiXinUserDao.addMyIdIntoFair(fair1,openId);
			
			
		System.out.println("-=-=-=-=-=-=-=-=-+openId:"+openId);

				//2.将本人的openID下面增加去过的场地，查询我去过的场地名字以及数量
				String openId1="wx_user_"+openId.substring(0,10 );
		//		System.out.println("-=-=-=-=-=-=-=-=-datas+openID1:"+fair+"=="+openId1);
				weiXinUserDao.addFairIntoMyOpenId(fair,openId1);

			

		
		//3.将场地主单中对应场地增加1，以便统计场地的人气数
				int count=weiXinUserDao.getFariCountByFair(fair);
				int count1=count+1;
			//	System.out.println("==========count+count1:"+count+"=="+count1);

				weiXinUserDao.addFairZDCount(fair,count1);

		//4.将本人的展销系数增加1
			//	System.out.println("==========openId+openId:"+openId+"=="+openId);

				int myCount=weiXinUserDao.getMyCountByOpenId(openId);
				int myCount1=myCount+1;
			//	System.out.println("==========myCount+myCount1:"+myCount+"=="+myCount1);

				weiXinUserDao.addMyCount(openId,myCount1);

			
			}
			
			
		
		}
		
		
		}
		
		
		return 1;
	}


	//手动增加场地,直接执行main函数
	@Override
	public void addMyFairs(String fairName, String formIp) {
		//1在场地主单中增加场地数据
	//	System.out.println("==========fairName+formIp:"+fairName+"=="+formIp);
		weiXinUserDao.addFairsZD(fairName,formIp);
		//2增加场地明细表
		String formIp1="wx_fair_"+formIp;
	//	System.out.println("==========formIp1:"+formIp1);
		weiXinUserDao.creatFairsMX(formIp1);
	}
	
	
}
