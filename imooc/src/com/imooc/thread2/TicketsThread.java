package com.imooc.thread2;

class MyThread extends Thread{
	private int ticktsCount=5;
	private String name;
	public MyThread(String name){
		this.name=name;
	}
	public void run(){
		while(ticktsCount>0){
			ticktsCount--;
			System.out.println(name+" sale 1      "+ticktsCount);
		}
	}
}
public class TicketsThread {

	public static void main(String[] args) {
		MyThread my1=new MyThread("1");
		MyThread my2=new MyThread("2");
		MyThread my3 = new MyThread("3");
		my1.start();
		my2.start();
		my3.start();

	}

}
