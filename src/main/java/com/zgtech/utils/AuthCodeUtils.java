package com.zgtech.utils;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.Random;

/*
 * 验证码生产类
 * 1.生产4个随机字符
 * 2.根据4个随机数绘制图片
 */
public class AuthCodeUtils {

	static Random random = new Random();//创建随机对象
	
	//生产4个随机数
	public static String randomStr(){
		StringBuilder sb = new StringBuilder();
		
		for(int i=0;i<4;i++){
			int num = random.nextInt(10);
			sb.append(num);
		}
		return sb.toString();
	}
	
	//绘制图片
	public static BufferedImage getImageByCode(String code){
		//创建画布
		BufferedImage img = new BufferedImage(88, 28, BufferedImage.TYPE_INT_RGB);
		//通过img对象创建画笔
		Graphics grap =  img.getGraphics();
		//设置背景颜色
		grap.setColor(Color.YELLOW);
		//绘制矩形
		grap.fillRect(0, 0, 88, 28);
		//设置字体
		grap.setFont(new Font("宋体", Font.BOLD, 24));
		//设置字体颜色
		grap.setColor(Color.BLACK);
		
		//绘制字符串
		for(int i=0;i<code.length();i++){
			//str:字符串    x:字符串水平位置    y:字符垂直位置
			grap.drawString(code.charAt(i)+"", 20*i+3, 24);
		}
		
		//绘制干扰线
		for(int i=0;i<10;i++){
			int x1 = random.nextInt(88);
			int y1 = random.nextInt(28);
			int x2 = random.nextInt(88);
			int y2 = random.nextInt(28);
			grap.drawLine(x1, y1, x2, y2);
			//grap.setColor(Color.GREEN);
		}
		return img;
	}
	
}
