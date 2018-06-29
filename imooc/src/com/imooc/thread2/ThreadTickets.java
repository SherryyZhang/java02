package com.imooc.thread2;

public class ThreadTickets {

	public static void main(String[] args) {
		MyThread2 myT =new MyThread2();
		Thread my1=new Thread(myT,"1");
		Thread my2=new Thread(myT,"2");
		Thread my3 = new Thread(myT,"3");
		my1.start();
		my2.start();
		my3.start();

	}

}
class MyThread2 implements Runnable{
	private int ticktsCount=5;
	public MyThread2(){
	}
	public void run(){
		while((ticktsCount--)>0){
			System.out.println(Thread.currentThread().getName()+" sale 1      "+ticktsCount);
			//ticktsCount--;
		}
	}
}
