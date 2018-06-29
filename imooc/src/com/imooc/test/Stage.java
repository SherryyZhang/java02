package com.imooc.test;

public class Stage extends Thread {

	public void run(){
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		AnmyRunnable anmy1=new AnmyRunnable();
		AnmyRunnable anmy2 = new AnmyRunnable();
		anmy1.keep=true;
		anmy2.keep=true;
		Thread anmyTh1=new Thread(anmy1,"11 ");
		Thread anmyTh2=new Thread(anmy2,"22 ");
		anmyTh1.start();
		anmyTh2.start();
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Thread.interrupted();
		Thread mrC = new KeyPersonThread();
		mrC.setName("ccc  ");
		mrC.start();
		try {
			mrC.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		anmy1.keep=false;
		anmy2.keep=false;
		
		
	}
	public static void main(String[] args) {
		new Stage().run();
	}

}
