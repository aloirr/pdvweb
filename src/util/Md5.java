package util;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Md5 {

	public static String gerar(String senha) {
		String md5;
		try {
			MessageDigest m;
			m = MessageDigest.getInstance("MD5");
			m.update(senha.getBytes(), 0, senha.length());
			md5 = new BigInteger(1, m.digest()).toString(16);
			return md5;

		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static boolean validar(String md5, String senha) {
		if (gerar(senha).equals(md5)) {
			return true;
		} else {
			return false;
		}
	}
}