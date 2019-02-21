package com.zgtech.controller;

import java.io.Writer;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zgtech.common.PageConstant;
import com.zgtech.dto.Notice;
import com.zgtech.dto.User;
import com.zgtech.service.NoticeService;
import com.zgtech.service.UserService;
@Controller

@RequestMapping("/customer")
public class HomeController {
	@Autowired
	private UserService userService;
	@Autowired
	private NoticeService noticeService;

	
	
	@RequestMapping("/home")
	public String toHome(ModelMap map) {

		String a="zhaogang";
		String b="123456";
		User user=new User();
		
		user.setUserId(a);
		user.setPassWord(b);

		User u = userService.getUserByUserNameAndPwd(user);

		
		List<Notice> Notices = noticeService.getNoticeList();

		for(Notice n:Notices) {

		}
		map.put("notices", Notices);
		
		
		
		return "index";
	}
	 @RequestMapping("/login")
	 public String toLoging() {
		 return "login";
	 }
	 @RequestMapping("/toRegister")
		public String toRegister() {
			return "/register";
		}

	 @RequestMapping("/customerLogin")
		public String customerLogin(@RequestParam("userId") String userId,@RequestParam("pwd") String pwd,@RequestParam("code") String code,
				HttpSession session, ModelMap map) throws NoSuchAlgorithmException {
			String oldCode = (String) session.getAttribute(PageConstant.AUTH_CODE);
			if (oldCode.equals(code)) {
				User user = userService.getUserByNameAndPwd2(userId,pwd);

				
				if (user != null) {
					session.setAttribute(PageConstant.SESSION_USER, user);
					List<Notice> Notices = noticeService.getNoticeList();

					for(Notice n:Notices) {

					}
					map.put("notices", Notices);
					
					return "index";
				} else {
					map.put(PageConstant.TIP, "1用户名或密码不正确");
				}

			} else {
				map.put(PageConstant.TIP, "验证码不正确");
			}

			return "/login";

		}
	 
	 
	//注册页面
		@RequestMapping("/addUser")
		public String addUser(User user,ModelMap map) {
			/*//发送邮件，判断是否有效，页面校验只能校验邮箱的格式，不能校验邮箱的是否有效
			UUID uuid=UUID.randomUUID();//根据UUID生成一个激活码
			String activeCode=uuid.toString();//根据UUID生成一个激活码
			String userMail=user.getEmail();//收件人
			String title="E_赵刚科技——账户激";

			StringBuffer sb=new StringBuffer();
			sb.append("欢迎"+user.getUserId()+":很高兴您能加入到赵刚科技，请点击下面链接激活账户（功能待完善）");
			sb.append("<br/>");

			sb.append("<a href='http://localhost:8080/eShop/customer/activeUser?code="+activeCode);
			sb.append("'>点击我</a>");
			sb.append("<a href='http://www.zhaogang520.xyz'>激活</a>");
			sb.append("进行激活");*/
			userService.addUser(user);//保存用户
			
			map.put(PageConstant.TIP, "注册成功，请登陆");
			/*boolean flag=EmailTools.sendEmail(userMail, title,sb.toString());

			if(flag){//邮件发送成功，则保存用户
				user.setActiveCode(activeCode);//设置激活码 
				user.setActiveStatus(0);//设置激活状态；			
				

				map.put(PageConstant.TIP, "注册成功，我们的密码邮件已发到您的邮箱了");
			}else{
				map.put(PageConstant.TIP, "邮件发送给你邮箱失败了，不过注册已经成功了");
			}
			*/

			return "login";
		}
		
	 
		@RequestMapping("/loginOut")
		public String loginOut(HttpServletRequest request ,ModelMap map){
		
			request.getSession().removeAttribute(PageConstant.SESSION_USER);
			

					return "forward:home";
		
			
			
		}
		@ResponseBody
		@RequestMapping("/addWords")
		
	 public String addWords(HttpSession session,String words,String code) {
			String data="";
String oldCode = (String) session.getAttribute(PageConstant.AUTH_CODE);
			User u=(User) session.getAttribute(PageConstant.SESSION_USER);
			

			if(u!=null) {
			if (oldCode.equals(code)) {
				Notice notice=new Notice();
				

			String	username=u.getName();
			notice.setUser(username);
			notice.setWords(words);
		int count=	noticeService.addNotice(notice);
				if(count==1) {
					data="success";
					
				}else {
					data="fail2";					
				}
				
			}else {
				data="fail1";
				
			}
			}else {
				data="fail3";
				
			}									
			return data;	
		 
	 }
	 
	 }
