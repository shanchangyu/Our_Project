/**
 * 
 */
package com.thosepeople.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author chenzhuo
 * 
 */
public class EncryptUtil {
	private static final String ENCRYPT_TYPE = "MD5";

	public static String generatePassWord(String salt, String passWord) {
		try {
			MessageDigest digest = MessageDigest.getInstance(ENCRYPT_TYPE);
			String source = passWord + salt;
			byte[] srcBytes = source.getBytes();
			digest.update(srcBytes);
			byte[] result = digest.digest();
			return byteToHexString(result);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	private static String byteToHexString(byte[] src){
		StringBuilder stringBuilder=new StringBuilder(32);
		for (int i = 0; i < src.length; i++) {  
	        int v = src[i] & 0xFF;  
	        String hexString = Integer.toHexString(v);  
	        if (hexString.length() < 2) {  
	            stringBuilder.append(0);  
	        }  
	        stringBuilder.append(hexString);  
	    }  
	    return stringBuilder.toString();
	}
}
