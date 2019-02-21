package com.zgtech.controller;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zgtech.dto.WeiXinFairMX;
import com.zgtech.dto.WeiXinFairZD;
import com.zgtech.dto.WeiXinUser;
import com.zgtech.service.WeiXinUserService;
import com.zgtech.service.serviceImpl.WeiXinUserServiceImpl;

@Controller

@RequestMapping("/weixin")
public class WeiXinController {
	@Autowired
	private WeiXinUserService weiXinUserService;
	
	
	
	@RequestMapping("/addUser")
	@ResponseBody
	public Object bindtext(HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("text/html;charset=utf-8");
        /*设置响应头允许ajax跨域访问*/
        response.setHeader("Access-Control-Allow-Origin", "*");
        /* 星号表示所有的异域请求都可以接受， */
        response.setHeader("Access-Control-Allow-Methods", "GET,POST");
        //获取微信小程序get的参数值并打印
        String openId = request.getParameter("openId");
        String userInfo = request.getParameter("userInfo");
        //当时的第一次请求，判断数据库是否有记录，假如没有记录便存入openid到数据库
    	System.out.println("===================addUser时候带到后台的openId+userInfo:"+openId+"="+userInfo);

        WeiXinUser wus=new WeiXinUser();
        wus.setJionCount("2");
        if(openId!=null) {
        	 WeiXinUser weiXinUser=new WeiXinUser();
        	 weiXinUser.setOpenId(openId);
    	WeiXinUser WU=weiXinUserService.getUserByWeiXinUser(weiXinUser);
    	wus=WU;
    	if(WU==null) {
          //假如数据库WU为null，而页面带过来的数据userInfo不为空，便将带过来的数据保存到数据库
            if(userInfo!=null) {
            	//将userInFo字符串切割出来；
            	String userInfo2=userInfo.substring(1, userInfo.length()-1);
            	//System.out.println("===================subString:"+userInfo2);
            	String []  sourceStrArray = userInfo2.split(",");
            	 WeiXinUser userInfos=new WeiXinUser();
            	 System.out.println("=======================================准备储存的openId"+openId);
            	 userInfos.setOpenId(openId);
            	 userInfos.setJionCount("0");
            	
                for (int i = 0; i < sourceStrArray.length; i++) {
                	if("nic".equals(sourceStrArray[i].substring(1, 4))) {
                        System.out.println(sourceStrArray[i].substring(12, sourceStrArray[i].length()-1));
                    userInfos.setNickName(sourceStrArray[i].substring(12, sourceStrArray[i].length()-1));
                }else if("gen".equals(sourceStrArray[i].substring(1, 4)) ) {
                	 System.out.println(sourceStrArray[i].substring(9, sourceStrArray[i].length()));
                     userInfos.setGender(sourceStrArray[i].substring(9, sourceStrArray[i].length()));
                	
                	
                }else if("lan".equals(sourceStrArray[i].substring(1, 4)) ) {
                	 System.out.println(sourceStrArray[i].substring(12, sourceStrArray[i].length()-1));
                     userInfos.setLanguage(sourceStrArray[i].substring(12, sourceStrArray[i].length()-1));
                	
                }else if("cit".equals(sourceStrArray[i].substring(1, 4)) ) {
                	 System.out.println(sourceStrArray[i].substring(8, sourceStrArray[i].length()-1));
                     userInfos.setCity(sourceStrArray[i].substring(8, sourceStrArray[i].length()-1));
                	
                }else if("pro".equals(sourceStrArray[i].substring(1, 4)) ) {
                	 System.out.println(sourceStrArray[i].substring(12, sourceStrArray[i].length()-1));
                     userInfos.setProvince(sourceStrArray[i].substring(12, sourceStrArray[i].length()-1));
                	
                }else if("cou".equals(sourceStrArray[i].substring(1, 4)) ) {
                	 System.out.println(sourceStrArray[i].substring(11, sourceStrArray[i].length()-1));
                     userInfos.setCountry(sourceStrArray[i].substring(11, sourceStrArray[i].length()-1));
                	
                }else if("ava".equals(sourceStrArray[i].substring(1, 4)) ) {
                	 System.out.println(sourceStrArray[i].substring(13, sourceStrArray[i].length()-1));
                     userInfos.setAvatarUrl(sourceStrArray[i].substring(13, sourceStrArray[i].length()-1));
                	
                }  	
                }
            	
            //	System.out.println("======================userInfos==="+userInfos);
            	
            	
            	weiXinUserService.addUserInfo(userInfos);
            	
            	String tableName="wx_user_"+openId.substring(0,10 );
            	weiXinUserService.createNewOpenIdTable(tableName);
            } 	
    		 
    	}
       }
        
        
        
        
        
        
        return wus;
	}
	
	
	@RequestMapping("/getJionCount")
	@ResponseBody
	public String getJionCount(HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("text/html;charset=utf-8");
        /*设置响应头允许ajax跨域访问*/
        response.setHeader("Access-Control-Allow-Origin", "*");
        /* 星号表示所有的异域请求都可以接受， */
        response.setHeader("Access-Control-Allow-Methods", "GET,POST");
        //获取微信小程序get的参数值并打印
        String openId = request.getParameter("openId");
       System.out.println("=============getJionCount时候带到后台的==openId:"+openId);
      String jionCount= weiXinUserService.getJionCountByOpenId(openId);
        //当时的第一次请求，判断数据库是否有记录，假如没有记录便存入openid到数据库
      if(jionCount==null||"".equals(jionCount)) {
    	  
      }
		return jionCount;
		
	}
	
	//获取场地排名
	@RequestMapping("/getJionFairZD")
	@ResponseBody
	public List<WeiXinFairZD> getJionFairZD(HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("text/html;charset=utf-8");
        /*设置响应头允许ajax跨域访问*/
        response.setHeader("Access-Control-Allow-Origin", "*");
        /* 星号表示所有的异域请求都可以接受， */
        response.setHeader("Access-Control-Allow-Methods", "GET,POST");
        //获取微信小程序get的参数值并打印
  	//  System.out.println("================进入获取场地list中=======");

      List<WeiXinFairZD> fairZDs= weiXinUserService.getJionFairZD();
        //当时的第一次请求，判断数据库是否有记录，假如没有记录便存入openid到数据库
      for(WeiXinFairZD fairZD:fairZDs) {
    	//  System.out.println("================fairZD:"+fairZD);
      }
      

		return fairZDs;
		
	}
	

	//根据场地的formIf获取某个场地对应数据
	@RequestMapping("/getFairMX")
	@ResponseBody
	public WeiXinFairMX getFairMX(HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("text/html;charset=utf-8");
        /*设置响应头允许ajax跨域访问*/
        response.setHeader("Access-Control-Allow-Origin", "*");
        /* 星号表示所有的异域请求都可以接受， */
        response.setHeader("Access-Control-Allow-Methods", "GET,POST");
        //获取微信小程序get的参数值并打印
        String formIp2= request.getParameter("formIp");
        String formIp="wx_fair_"+formIp2;
  	 // System.out.println("================进入获取场地list中======="+formIp);

  	WeiXinFairMX fairMX=weiXinUserService.getFairMX(formIp);
        //当时的第一次请求，判断数据库是否有记录，假如没有记录便存入openid到数据库
	//  System.out.println("===============查询出来的fairMX======="+fairMX.getPeopleOpenId()+"--"+   fairMX.toString());


		return fairMX;
		
	}
	
	
	//根据场地的formIf获取某个场地对应数据
		@RequestMapping("/addMyFair")
		@ResponseBody
		public int addMyFair(HttpServletRequest request, HttpServletResponse response) {
	        response.setContentType("text/html;charset=utf-8");
	        /*设置响应头允许ajax跨域访问*/
	        response.setHeader("Access-Control-Allow-Origin", "*");
	        /* 星号表示所有的异域请求都可以接受， */
	        response.setHeader("Access-Control-Allow-Methods", "GET,POST");
	        //获取微信小程序get的参数值并打印

	     	 String datas= request.getParameter("datas");
	     	String openId= request.getParameter("openId");
	     System.out.println("================进入addMyFair方法带到后台的datas+openId:======="+datas+"-"+openId);

	     	  
	     	  
	  	int count=weiXinUserService.addMyFair(datas,openId);
	        //当时的第一次请求，判断数据库是否有记录，假如没有记录便存入openid到数据库
		//  System.out.println("===============查询出来的fairMX======="+count);

			return 1;
			
		}
		
		
		//手动增加场地,在个人网站的底部增加
		@RequestMapping("/addMyFairs")
		@ResponseBody
		public void customerLogin(@RequestParam("FairName") String FairName,@RequestParam("FormIp") String FormIp,@RequestParam("code") String code) { 
			//		System.out.println("============12121212121212======="+FairName+"="+FormIp+"="+code);
					if("99999".equals(code)) {
						weiXinUserService.addMyFairs(FairName,FormIp);
					}
					
					
					
				}
		
				
				
				
				
	
	 }





