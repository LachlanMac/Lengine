package com.lmac.sfs.server.utils;

import com.lmac.sfs.server.config.Options;

public class Log {

	public static void print(String txt) {
		if (Options.logging) {
			System.out.println(new String("LOG: " + txt));
		}
	}
	
	public static void error(String txt) {
		if (Options.logging) {
			System.out.println(new String("ERROR: " + txt));
		}
	}
	
	public static void info(String txt){
		System.out.println(new String("Server Info: " + txt));
		
	}
}
