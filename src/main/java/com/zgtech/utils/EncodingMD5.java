package com.zgtech.utils;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class EncodingMD5 {
	
	public static String getMD5(String str) throws NoSuchAlgorithmException{
		//创建指定算法的信息摘要对象
		MessageDigest md=MessageDigest.getInstance("md5");
		//计算md5函数的哈希值
		md.update(str.getBytes());
		//md.digest();传入一个字符串返回最后确定的hash值
		//jdk中提供的BigInteger（）完成对byte字节想hexString的转换
		//toString后的括号里可以不加数字，加上数字16，则出来的是16进制的密文
		return new BigInteger(1,md.digest(str.getBytes())).toString(16);
	
	
}
}
