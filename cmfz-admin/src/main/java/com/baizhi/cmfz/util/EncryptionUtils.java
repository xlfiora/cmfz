package com.baizhi.cmfz.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

import org.apache.commons.codec.digest.DigestUtils;

public class EncryptionUtils {
	
	public static void main(String[] args) throws NoSuchAlgorithmException {
		System.out.println(encryption("123456"));
		System.out.println(encryptionCode("123456"));
		System.out.println(encryptionCode("123"+"ce7d"));
	}
	
	public static String encryption(String str) throws NoSuchAlgorithmException {
		MessageDigest md=MessageDigest.getInstance("MD5");
		
		byte[] code=md.digest(str.getBytes());
		
		StringBuilder builder=new StringBuilder();
		
		for (byte b : code) {
			//��ÿ���ֽ�ת�����޷����
			int c=b & 0xFF;
			
			if(c<16){
				//���16���µ����� ת��ʮ����ƺ� ������λ��׷��0��Ϊǰ׺
				builder.append("0");
			}
			//�����ַ�ת��Ϊʮ������ַ����ƴ��
			builder.append(Integer.toHexString(c));
		}
		return builder.toString();	
	}
	
	public static String encryptionCode(String str){
		return DigestUtils.md5Hex(str);
		//return DigestUtils.sha256Hex(str);
	} 
	
	
	public static String getRandomSalt(int len){
		char[] chs="abcdefg1234567ABCDEFG".toCharArray();
		
		Random random =new Random();
		
		StringBuilder builder=new StringBuilder();
		
		for (int i = 0; i < len; i++) {
			builder.append(chs[random.nextInt(chs.length)]);
		}
		return builder.toString();
		
	}
	
}


	


























