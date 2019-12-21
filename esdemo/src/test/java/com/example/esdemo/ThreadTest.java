package com.example.esdemo;
import com.example.esdemo.thread.MyRunnable;
import com.example.esdemo.thread.MyThread;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

@SpringBootTest
public class ThreadTest {
    @Test
    public void testMyRunnable(){
        MyRunnable myRunnable=new MyRunnable();
        Thread thread1=new Thread(myRunnable,"线程1");
        Thread thread2=new Thread(myRunnable,"线程2");
        thread1.start();
        thread2.start();
    }
    @Test
    public void testMyThread(){
        MyThread myThread1=new MyThread();
        MyThread myThread2=new MyThread();
        myThread1.setName("线程一");
        myThread2.setName("线程二");
        myThread1.start();
        myThread2.start();
    }
//    @Test
//    public void testCallable() throws ExecutionException, InterruptedException {
//        MyCallable myCallable=new MyCallable();
//        FutureTask futureTask=new FutureTask(myCallable);
//        Thread thread1=new Thread(futureTask);
//        thread1.start();
//        System.out.println(futureTask.get());
//    }

    @Test
    public void testExecutorService(){
        ExecutorService executorService= Executors.newFixedThreadPool(10);
        executorService.submit(new MyRunnable());
        executorService.submit(new MyRunnable());
        executorService.submit(new MyRunnable());
        executorService.shutdown();
    }
}
