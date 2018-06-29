package com.imooc.test;

public class Actor extends Thread {
@Override
	public void run(){
		System.out.println(getName()+"yanyuan");
		int count =0;
		boolean keep=true;
		while(keep){
			System.out.println(getName()+"yanchu"+(++count));
			if(count>=20)
				keep=false;
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		System.out.println(getName()+"jieshu");
	}
	public static void main(String[] args) {
		Thread actor = new Actor();
		actor.setName("1");
		actor.start();
		Thread actress = new Thread(new Actress(),"2");
		actress.start();
	}
}
class Actress implements Runnable{
	@Override
	public void run(){
		System.out.println(Thread.currentThread().getName()+"yanyuan");
		int count =0;
		boolean keep=true;
		while(keep){
			System.out.println(Thread.currentThread().getName()+"yanchu"+(++count));
			if(count==20)
				keep=false;
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		
		System.out.println(Thread.currentThread().getName()+"jieshu");
	}
}
