package com.imooc.energy;

public class EnergyTransferTask implements Runnable {

	private EnergySystem energySystem;
	private int fromBox;
	private double maxAmount;
	private int DELAY=100;
	
	public EnergyTransferTask(EnergySystem e,int f,double m) {
		this.energySystem=e;
		this.fromBox=f;
		this.maxAmount=m;
	}
	public void run(){
		try {
		while(true){
			int toBox=(int)(energySystem.getEnergyAmount()*Math.random());
			double amount =maxAmount*Math.random();
			energySystem.transfer(fromBox,toBox,amount);
				Thread.sleep((int)(DELAY*Math.random()));
			
			}
		} catch (InterruptedException e) {
				System.out.println("====================");
		}
	}
	

}
