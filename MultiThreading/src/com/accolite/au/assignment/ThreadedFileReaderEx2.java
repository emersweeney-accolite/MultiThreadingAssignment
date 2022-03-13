package com.accolite.au.assignment;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class ThreadedFileReaderEx2 {
    File file;
    FileReader fw;
    static Scanner s;
    static String currentString;
    int lineNo=1;

    public ThreadedFileReaderEx2(File file) throws FileNotFoundException {
        this.file = file;
        fw = new FileReader(file);
        s = new Scanner(fw);
    }

    public static void main(String[] args) throws FileNotFoundException{

        ThreadedFileReaderEx2 example = new ThreadedFileReaderEx2(new File("src/com/accolite/au/assignment/HumptyDumpty"));

        Thread t1 = new Thread(() -> example.readEven());
        Thread t2 = new Thread(() -> example.readOdd());

        t1.start();
        t2.start();
    }

    public void readOdd() {
        synchronized (this) {
            while (s.hasNextLine()) {
                while (lineNo % 2 == 1) {
                    try {wait();} catch (InterruptedException e) {e.printStackTrace();} }
                if (s.hasNextLine()) {
                    currentString = s.nextLine();
                    System.out.println(lineNo + " " + Thread.currentThread() + " " + currentString);
                    lineNo++;
                    notify();
                }
            }
        }
    }

    public void readEven() {
        synchronized (this) {
            while (s.hasNextLine()) {
                while (lineNo % 2 == 0) {
                    try {wait();} catch (InterruptedException e) {e.printStackTrace();} }
                if (s.hasNextLine()) {
                    currentString = s.nextLine();
                    System.out.println(lineNo + " " + Thread.currentThread() + " " + currentString);
                    lineNo++;
                    notify();
                }
            }
        }
    }
}


