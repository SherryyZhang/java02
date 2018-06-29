package com.imooc.energy;

public class EnergySystem {

	private final double[] energyBoxs;
	private final Object o=new Object();
	
	public EnergySystem(int n,double initEnergy) {
		energyBoxs = new double[n];
		for(int i=0;i<energyBoxs.length;i++){
			energyBoxs[i]=initEnergy;
		}
	}
	
	public void transfer(int from,int to,double amount){
		synchronized(o){
//		if(energyBoxs[from]<amount){
//			return;
//		}
		while(energyBoxs[from]<amount){
			try {
				o.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}	
		System.out.println(Thread.currentThread().getName());
		energyBoxs[from]-=amount;
		System.out.printf("from %d transfer %10.2f  to  %d    ",from,amount,to);
		energyBoxs[to]+=amount;
		System.out.printf("   energy :%10.2f%n",getTotal());
		o.notify();
	}}
	public double getTotal(){
		double sum=0;
		for(double amount :energyBoxs){
			sum+=amount;
		}
		return sum;
	}
	public int getEnergyAmount(){
		return energyBoxs.length;
	}
}
