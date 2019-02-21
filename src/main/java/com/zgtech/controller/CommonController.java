package com.zgtech.controller;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zgtech.common.PageConstant;
import com.zgtech.utils.AuthCodeUtils;

@Controller

public class CommonController {
	@RequestMapping("/authCode")
	public void authCode(HttpServletRequest request,HttpServletResponse response) throws IOException{
		String code=AuthCodeUtils.randomStr();
		HttpSession session = request.getSession();
		session.setAttribute(PageConstant.AUTH_CODE, code);
		BufferedImage img=AuthCodeUtils.getImageByCode(code);
		ImageIO.write(img, "jpg", response.getOutputStream());
			
	}

}
