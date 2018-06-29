package com.qrcode;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import javax.imageio.ImageIO;

import com.google.zxing.BinaryBitmap;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;

public class ReadQRCode {

	public static void main(String[] args) {
	MultiFormatReader reader = new MultiFormatReader();
	File file = new File("d:/w.png");
	BufferedImage image;
	try {
		image = ImageIO.read(file);
		BinaryBitmap bb = new BinaryBitmap(new HybridBinarizer(new BufferedImageLuminanceSource(image)));
		HashMap hints = new HashMap();
		hints.put(EncodeHintType.CHARACTER_SET, "utf-8");
		Result result= reader.decode(bb,hints);
		System.out.println("result   "+result.toString());
		System.out.println("format   "+result.getBarcodeFormat());
		System.out.println("text    "+result.getText());
	} catch (IOException e) {
		e.printStackTrace();
	} catch (NotFoundException e) {
		e.printStackTrace();
	}
	}
	

}
