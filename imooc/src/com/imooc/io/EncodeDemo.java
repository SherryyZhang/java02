package com.imooc.io;


public class EncodeDemo {

	public static void main(String[] args) throws Exception {
		EncodeDemo d = new EncodeDemo();
		String s="Ä½¿ÎÍøaA";
		byte[] b1=s.getBytes();
		d.bytePrint(b1);
		byte[] b2=s.getBytes("GBK");
		d.bytePrint(b2);
		byte[] b3=s.getBytes("UTF-8");
		d.bytePrint(b3);
		byte[] b4=s.getBytes("UTF-16be");
		d.bytePrint(b4);
		String str1 = new String(b1,"utf-8");
		System.out.println(str1);
		byte[] b5=str1.getBytes("utf-8");
		d.bytePrint(b5);
		String str2= new String(b5,"utf-8");
		System.out.println(str2);

	}

	public void bytePrint(byte[] b1){
		for(byte b:b1){
			System.out.print(Integer.toHexString(b&0xff)+" ");
			
		}
		System.out.println();
	}
}
