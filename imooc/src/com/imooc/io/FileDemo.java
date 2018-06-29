package com.imooc.io;

import java.io.File;
import java.io.IOException;

public class FileDemo {

	public static void main(String[] args) {
		File f = new File("D:\\dae.txt");
		System.out.println(f.exists());
		File f2=new File("d:"+File.separator+"dae1.txt");
		System.out.println(f2.exists());
		if(!f2.exists())
			try {
				f2.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		else
			f2.delete();
	}

}
