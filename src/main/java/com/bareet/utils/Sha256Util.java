package com.bareet.utils;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

//For encrypting password
public class Sha256Util {
	public static byte[] getSHA(String input) throws NoSuchAlgorithmException {
		final MessageDigest md = MessageDigest.getInstance("SHA-256");
		return md.digest(input.getBytes(StandardCharsets.UTF_8));
	}

	public static String toHexString(byte[] hash) {
		final BigInteger number = new BigInteger(1, hash);
		final StringBuilder hexString = new StringBuilder(number.toString(16));
		while (hexString.length() < 32) {
			hexString.insert(0, '0');
		}
		return hexString.toString();
	}

	public static String encrypt(String str) throws NoSuchAlgorithmException {
		return toHexString(getSHA(str));
	}
}