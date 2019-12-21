package com.example.esdemo.thread;

public class MyThread extends Thread {

    @Override
    public void run() {
        int i=100;
        while(i>0){
            System.out.println(Thread.currentThread().getName()+":"+i--);
        }
    }
}
