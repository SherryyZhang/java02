package com.imooc.energy;

public class Test {
public static final int BOX=100;
public static final int ENERGY=1000;
	public static void main(String[] args) {
		EnergySystem e=new EnergySystem(BOX, ENERGY);
		for(int i=0;i<BOX;i++){
			EnergyTransferTask task=new EnergyTransferTask(e, i, ENERGY);
			Thread t=new Thread(task,"TransferThread_"+i);
			t.start();
		}
	}

}
