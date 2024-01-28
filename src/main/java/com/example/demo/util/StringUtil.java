package com.example.demo.util;

public final class StringUtil {

	public static boolean isNullOrEmpty(String str) {
	    return str == null || str.isEmpty();
	}
	
	public static String toNullEmpty(String str) {
	    return str == null ? "" : str.trim();
	}
	
	public static boolean isNotNullOrEmpty(String str) {
	    return str != null && !str.isEmpty();
	}
}
