package com.accolite.au.assignment;

public class OddEvenEx4 {
    int counter = 0;
    int n = 100;

    public static void main(String[] args)
    {
        OddEvenEx4 example = new OddEvenEx4();
        Thread t1 = new Thread(new Runnable(){public void run(){example.printEven();}});
        Thread t2 = new Thread(new Runnable(){public void run(){example.printOdd();}});

        t1.start();
        t2.start();
    }

    public void printOdd() {
        synchronized (this) {
            while (counter < n) {
                while (counter % 2 == 1) {
                    try {wait();} catch (InterruptedException e) {e.printStackTrace();}
                }
                System.out.println(counter+" (t1) "); counter++; notify();
            }
        }
    }

    public void printEven() {
        synchronized (this) {
            while (counter < n) {
                while (counter % 2 == 0) {
                    try {wait();} catch (InterruptedException e) {e.printStackTrace();}
                }
                System.out.println(counter + " (t2) "); counter++; notify();
            }
        }
    }

}