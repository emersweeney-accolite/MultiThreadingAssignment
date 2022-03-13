package com.accolite.au.assignment;

public class OddEvenEx1 {
    static int counter = 0;
    static int n = 100;

    public static void main(String[] args)
    {
        OddEvenEx1 example = new OddEvenEx1();
        Thread even = new Thread(new Runnable(){public void run(){example.printEven();}});
        Thread odd = new Thread(new Runnable(){public void run(){example.printOdd();}});

        even.start();
        odd.start();
    }

    public void printOdd() {
        while (counter <n) {
            synchronized (this) {
                if (counter % 2 == 1) {
                    System.out.println(Thread.currentThread() + " " + counter);
                    counter++;
                }
            }
        }
    }

    public void printEven() {
        while (counter<n) {
            synchronized (this) {
                if (counter % 2 == 0) {
                    System.out.println(Thread.currentThread() + " " + counter);
                    counter++;
                }
            }
        }
    }
}
