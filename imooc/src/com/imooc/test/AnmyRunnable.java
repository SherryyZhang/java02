package com.imooc.test;

public class AnmyRunnable implements Runnable {
	//��֤�߳̿�����ȷ��ȡ�����̵߳�ֵ
	volatile boolean keep;

	@Override
	public void run() {
	while(keep){
		for(int i=0;i<5;i++)
			System.out.println(Thread.currentThread().getName()+"run   "+i+"  times");
			//�ó��߳�
			Thread.yield();
			
		}	

	}

}
