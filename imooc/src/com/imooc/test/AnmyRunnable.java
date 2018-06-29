package com.imooc.test;

public class AnmyRunnable implements Runnable {
	//保证线程可以正确读取其他线程的值
	volatile boolean keep;

	@Override
	public void run() {
	while(keep){
		for(int i=0;i<5;i++)
			System.out.println(Thread.currentThread().getName()+"run   "+i+"  times");
			//让出线程
			Thread.yield();
			
		}	

	}

}
