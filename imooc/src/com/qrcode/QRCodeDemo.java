package com.qrcode;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.HashMap;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;


public class QRCodeDemo {

	public static void main(String[] args) {
		createQRCode();
	}
	public static void createQRCode(){
		int width=300;
		int height=300;
		String format = "png";
		String content = "www.immoc.com";
		//定义二维码参数
		HashMap hints = new HashMap();
		hints.put(EncodeHintType.CHARACTER_SET, "utf-8");
		hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);
		hints.put(EncodeHintType.MARGIN, 2);
		
		
		OutputStream stream;
		try {
			stream = new FileOutputStream(new File("d:/w.png"));
			BitMatrix bitMatrix=new MultiFormatWriter().encode(content, BarcodeFormat.QR_CODE, width, height,hints);
			MatrixToImageWriter.writeToStream(bitMatrix, format, stream);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	
	}

}
