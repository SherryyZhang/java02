package com.imooc.thread2;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Scanner;

public class DeaThread {

	public static void main(String[] args) {
		System.out.println("now you are in === "+Thread.currentThread().getName());
		Thread t=new Thread(new DaemonThread(),"aaa");
		t.setDaemon(true);
		t.start();
		Scanner s=new Scanner(System.in);
		s.next();
		System.out.println("is over=== "+Thread.currentThread().getName());

	}

}
class DaemonThread implements Runnable{

	@Override
	public void run() {
		
		System.out.println("now you are in "+Thread.currentThread().getName());
		try {
			writeToFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("is over "+Thread.currentThread().getName());
	}
	
	private void writeToFile() throws IOException, InterruptedException{
		File f=new File("D:"+File.separator+"dae.txt");
		OutputStream out = new FileOutputStream(f,true);
		int count =0;
		while(count <9){
			
			out.write(("\r\nword"+count).getBytes());
			System.out.println("thread   "+Thread.currentThread().getName()+"  write words   "+count++);
			Thread.sleep(5000);
		}
		out.close();
	}
}
