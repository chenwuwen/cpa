package cn.kanyun.cpa.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.commons.codec.binary.Base64;

public class MD5util {
	public static String md5(String msg) throws NoSuchAlgorithmException{
		MessageDigest md = MessageDigest.getInstance("MD5");
		byte[] input = msg.getBytes();//将输入信息转换成字节
		byte[] output = md.digest(input);//加密并输出字节码
		//将加密后的字节转换成字符，否则可能会乱码
		String result = Base64.encodeBase64String(output);
		return result;
}
}