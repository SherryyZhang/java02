package com.serurity;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.Security;

import org.apache.commons.codec.binary.Hex;
import org.apache.commons.codec.digest.DigestUtils;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.digests.MD4Digest;
import org.bouncycastle.crypto.digests.MD5Digest;
import org.bouncycastle.jce.provider.BouncyCastleProvider;



public class MDDemo1 {

	private static String str="i im md";
	public static void main(String[] args) {
		jkdMD5();
		bcMD5();
		jkdMD2();
		bcMD4();
		ccMD4();
		m();
	}
	public static void jkdMD5(){

		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			byte[] mdBytes=md.digest(str.getBytes());
			System.out.println(Hex.encodeHexString(mdBytes));
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
	
		
	}
	public static void jkdMD2(){

		try {
			MessageDigest md = MessageDigest.getInstance("MD2");
			byte[] mdBytes=md.digest(str.getBytes());
			System.out.println(Hex.encodeHexString(mdBytes));
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		
			
	}
	public static void bcMD4(){	
		//bc
		try {
			Security.addProvider(new BouncyCastleProvider());
			MessageDigest md = MessageDigest.getInstance("MD4");
			byte[] mdBytes=md.digest(str.getBytes());
			System.out.println(Hex.encodeHexString(mdBytes));
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		Digest digist = new MD4Digest();
		digist.update(str.getBytes(), 0, str.getBytes().length);
		byte[] md4Bytes = new byte[digist.getDigestSize()];
		digist.doFinal(md4Bytes, 0);
		System.out.println(org.bouncycastle.util.encoders.Hex.toHexString(md4Bytes));
	}
	public static void bcMD5(){
		Digest digist = new MD5Digest();
		digist.update(str.getBytes(), 0, str.getBytes().length);
		byte[] md5Bytes = new byte[digist.getDigestSize()];
		digist.doFinal(md5Bytes, 0);
		System.out.println(org.bouncycastle.util.encoders.Hex.toHexString(md5Bytes));
	}
	public static void ccMD4(){
		System.out.println(DigestUtils.md5Hex(str.getBytes()));
	}
	public static void m(){
		Digest d = new MD5Digest();
		d.update(str.getBytes(),0,str.getBytes().length);
		byte[] b = new byte[d.getDigestSize()];
		d.doFinal(b, 0);
		System.out.println(org.bouncycastle.util.encoders.Hex.toHexString(b));
		
	}

}
