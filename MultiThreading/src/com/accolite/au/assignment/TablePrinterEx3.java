package com.accolite.au.assignment;

public class TablePrinterEx3 {

    //prints times table up to 10 x n
    public synchronized static void printTable(int n){
        System.out.println(Thread.currentThread()+ " " + n+" times table:");
        for (int i=1; i<=10; i++){
            System.out.println(n + " x " + i + " = " + n*i);
        }
        try{
            Thread.sleep(400);
        } catch(InterruptedException e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args){

        //t1 to print 5 times table
        Thread t1 = new Thread(new Runnable(){
            public void run(){
                printTable(5);
            }
        });

        //t2 to print 7 times table
        Thread t2 = new Thread(new Runnable(){
            public void run(){
                printTable(7);
            }
        });

        //t3 to print 8 times table
        Thread t3 = new Thread(new Runnable(){
            public void run(){
                printTable(8);
            }
        });

        //t4 to print 12 times table
        Thread t4 = new Thread(new Runnable(){
            public void run(){
                printTable(12);
            }
        });

        /*
        class is locked by each thread until task is done
        so tables print completely before next thread executes task
         */

        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}
