package com.accolite.au.synchronizedMethod;

public class Table {
	
		/*synchronized void printTable(int n) {
			for(int i=1;i<=5;i++) {
			System.out.println(n*i);
			try {
				Thread.sleep(400);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}
		}*/
		
		void printTable(int n) {
			synchronized(this){
				for(int i=1;i<=5;i++) {
					System.out.println(n*i);
					try {
						Thread.sleep(400);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
}


