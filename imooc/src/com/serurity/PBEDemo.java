package com.serurity;

import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.PBEParameterSpec;

import org.apache.commons.codec.binary.Base64;


public class PBEDemo {
public static String src = "i am immoc pbe";
	public static void main(String[] args) {
		
		jdkPBE();
	}
	public static void jdkPBE(){
		try {
			//初始化盐
			SecureRandom random = new SecureRandom();
			byte[] salt = random.generateSeed(8);
			//口令秘钥
			String password = "immoc";
			PBEKeySpec keyspec = new PBEKeySpec(password.toCharArray());
			SecretKeyFactory factory = SecretKeyFactory.getInstance("PBEWITHMD5andDES");
			Key key = factory.generateSecret(keyspec);
			//加密
			PBEParameterSpec p = new PBEParameterSpec(salt, 100);
			Cipher cipher = Cipher.getInstance("PBEWITHMD5andDES");
			cipher.init(Cipher.ENCRYPT_MODE, key,p);
			byte[] result= cipher.doFinal(src.getBytes());
			System.out.println(Base64.encodeBase64String(result));
			//解密
			cipher.init(Cipher.DECRYPT_MODE,key,p);
			result = cipher.doFinal(result);
			System.out.println(new String(result));
			
			
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (NoSuchPaddingException e) {
			e.printStackTrace();
		} catch (InvalidKeySpecException e) {
			e.printStackTrace();
		} catch (InvalidKeyException e) {
			e.printStackTrace();
		} catch (InvalidAlgorithmParameterException e) {
			e.printStackTrace();
		} catch (IllegalBlockSizeException e) {
			e.printStackTrace();
		} catch (BadPaddingException e) {
			e.printStackTrace();
		}
		
		
	}

}
