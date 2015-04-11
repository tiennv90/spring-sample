package com.spring.sample.util;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Utils {
	public static String getHashMD5(String string) {
	    try {
	        MessageDigest md = MessageDigest.getInstance("MD5");
	        BigInteger bi = new BigInteger(1, md.digest(string.getBytes()));
	        return bi.toString(16);
	    } catch (NoSuchAlgorithmException ex) {
	       
	    	ex.printStackTrace();

	        return "";
	    }
	    
	}
	
	public static double round(double value, int places) {
	    if (places < 0) throw new IllegalArgumentException();

	    long factor = (long) Math.pow(10, places);
	    value = value * factor;
	    long tmp = Math.round(value);
	    return (double) tmp / factor;
	}
	
	public static void main(String[] args) {
		System.out.println(round(22.2222222, 2));
		System.out.println(getHashMD5("123"));
	}
}
