package com.lemon.chen.test;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class QuickPasswordEncodingGenerator {

	/**
	 * @param args 演示加密-----
	 */
	public static void main(String[] args) {
			String password = "abc123";
			BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
			System.out.println(passwordEncoder.encode(password));
	}

}
