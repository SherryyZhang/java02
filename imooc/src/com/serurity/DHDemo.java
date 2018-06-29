package com.serurity;

import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;

import javax.crypto.Cipher;
import javax.crypto.KeyAgreement;
import javax.crypto.SecretKey;
import javax.crypto.interfaces.DHPublicKey;
import javax.crypto.spec.DHParameterSpec;

import org.apache.commons.codec.binary.Base64;

public class DHDemo {
	public static String src="immoc";
	public static void main(String[] args) {
		jdkDH();
	}

	public static void jdkDH(){
		try {
			//发送方密钥
			KeyPairGenerator senderkeyPairGenerator = KeyPairGenerator.getInstance("DH");
			senderkeyPairGenerator.initialize(512);
			KeyPair senderKeyPair = senderkeyPairGenerator.generateKeyPair();
			byte[] senderPublicKeyEnc = senderKeyPair.getPublic().getEncoded();
			//接收方密钥
			KeyFactory receiverKeyFactory = KeyFactory.getInstance("DH");
			X509EncodedKeySpec X509keySpec = new X509EncodedKeySpec(senderPublicKeyEnc);
			PublicKey receiverPublicKey = receiverKeyFactory.generatePublic(X509keySpec);
			DHParameterSpec params=((DHPublicKey)receiverPublicKey).getParams();
			KeyPairGenerator receiverKeyPairGenerator = KeyPairGenerator.getInstance("DH");
			receiverKeyPairGenerator.initialize(params);
			KeyPair receiverKeyPair = receiverKeyPairGenerator.generateKeyPair();
			PrivateKey receiverPrivateKey = receiverKeyPair.getPrivate();
			byte[] receiverPublicKeyEnc = receiverKeyPair.getPublic().getEncoded();
			//密钥构建
			KeyAgreement receiverKeyAgree = KeyAgreement.getInstance("DH");
			receiverKeyAgree.init(receiverPrivateKey);
			receiverKeyAgree.doPhase(receiverPublicKey, true);
			SecretKey receiverDesKey = receiverKeyAgree.generateSecret("DES");
			
			KeyFactory senderKeyFactory = KeyFactory.getInstance("DH");
			X509keySpec = new X509EncodedKeySpec(receiverPublicKeyEnc);
			PublicKey senderPublicKey = senderKeyFactory.generatePublic(X509keySpec);
			KeyAgreement senderKeyA = KeyAgreement.getInstance("DH");
			senderKeyA.init(senderKeyPair.getPrivate());
			senderKeyA.doPhase(senderPublicKey, true);
			SecretKey senderDseKey = senderKeyA.generateSecret("DES");
			
			if(receiverDesKey.equals(senderDseKey)){
				System.out.println("the secrets is the same");
			}
			
			//加密
			Cipher cipher = Cipher.getInstance("DES");
			cipher.init(Cipher.ENCRYPT_MODE,senderDseKey);
			byte[] result = cipher.doFinal(src.getBytes());
			System.out.println(Base64.encodeBase64String(result));
			
			//解密
			cipher.init(Cipher.DECRYPT_MODE,receiverDesKey);
			result = cipher.doFinal(result);
			System.out.println(new String(result));
			
		
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	}
}
