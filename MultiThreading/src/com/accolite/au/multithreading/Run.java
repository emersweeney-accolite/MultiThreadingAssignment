package com.accolite.au.multithreading;

public class Run {

	public static void main(String[] args) {
		AccolitethreadEx3 accolitethreadEx3 = new AccolitethreadEx3();
		AccolitethreadEx4 accolitethreadEx4 = new AccolitethreadEx4();
		accolitethreadEx3.start();
		accolitethreadEx4.start();

	}

}
