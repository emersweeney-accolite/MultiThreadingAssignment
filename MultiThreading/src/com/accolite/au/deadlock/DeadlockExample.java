package com.accolite.au.deadlock;

public class DeadlockExample {

	 
	public static void main(String[] args) {
		final String resource1 = "Nishant Saurabh";  
		final String resource2 = "Antony";

		// t1 tries to lock resource1 then resource2
	    Thread t1 = new Thread() {
	      public void run() {
	          synchronized (resource1) {
	           System.out.println("Thread 1: locked resource 1");
	           try { Thread.sleep(100);} catch (Exception e) {}
	           synchronized (resource2) {
	            System.out.println("Thread 1: locked resource 2");
	           }
	         }
	      }
	    };

	 	// t2 tries to lock resource2 then resource1
		// AMENDED to lock resource1 first then resource2 to resolve deadlock
	    Thread t2 = new Thread() {  
	      public void run() {  
	        synchronized (resource1) {
	          System.out.println("Thread 2: locked resource 1");
	          try { Thread.sleep(100);} catch (Exception e) {}
	          synchronized (resource2) {
	            System.out.println("Thread 2: locked resource 2");
	          }  
	        }  
	      }  
	    };

	    t1.start();  
	    t2.start();  

	}

}
