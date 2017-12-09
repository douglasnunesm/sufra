package br.ucb.security;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Criptografia {

	private static MessageDigest md = null;
	
	public static String md5(String senha){
		String sen = "";
		MessageDigest md = null;
		try {
			md = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		BigInteger hash = new BigInteger(1, md.digest(senha.getBytes()));
		sen = hash.toString(16);			
		return sen;
	}

	static {
		try {
			md = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException ex) {
			ex.printStackTrace();
		}
	}

	private static char[] hexCodes(byte[] text) {
		char[] hexOutput = new char[text.length * 2];
		String hexString;

		for (int i = 0; i < text.length; i++) {
			hexString = "00" + Integer.toHexString(text[i]);
			hexString.toUpperCase().getChars(hexString.length() - 2, hexString.length(), hexOutput, i * 2);
		}
		return hexOutput;
	}

	public static String criptografar(String pwd) {
		if (md != null) {
			return new String(hexCodes(md.digest(pwd.getBytes())));
		}
		return null;
	}
}
