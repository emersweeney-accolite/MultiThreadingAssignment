package com.accolite.au.multithreading;

public class AccolitethreadEx3 extends Thread{
	
	public void run() {
		for (int i=0;i<100;i++)
		System.out.println("Thread AccolitethreadEx3:"+i);
	}
}


