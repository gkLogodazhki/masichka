package com.websystique.springmvc.servlets;

import java.util.Random;

public class SecurityCodeGenerator {
	private static final char UPPER_A = 'A';
	private static final char UPPER_Z = 'Z';
	private static final char LOWER_A = 'a';
	private static final char LOWER_Z = 'z';
	private static final char ONE = '1';
	private static final char NINE = '9';
	private Random r = new Random();
	private StringBuilder securityCode;
	
	public SecurityCodeGenerator() {
		securityCode = new StringBuilder();
	}
	
	
	public StringBuilder getCode() {
		for (int i = 0; i < 8; i++) {
			int n = r.nextInt(3) + 1;
			switch(n) {
			case 1: getSecurityCode().append((char)(r.nextInt((UPPER_Z - UPPER_A) + 1) + UPPER_A));
				break;
			case 2: getSecurityCode().append((char)(r.nextInt((LOWER_Z - LOWER_A) + 1) + LOWER_A));
				break;
			case 3: getSecurityCode().append((char)(r.nextInt((NINE - ONE) + 1) + ONE));
				break;
			}
		}
		return getSecurityCode();
	}


	public StringBuilder getSecurityCode() {
		return securityCode;
	}

}
