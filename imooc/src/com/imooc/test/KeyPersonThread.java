package com.imooc.test;

public class KeyPersonThread extends Thread {

	public void run(){
		for(int i=0;i<10;i++)
			System.out.println(Thread.currentThread().getName()+"run   "+i+"  times-----------------");
			//ÈÃ³öÏß³Ì
			Thread.yield();
			
		}	
}
