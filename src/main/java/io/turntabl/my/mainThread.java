package io.turntabl.my;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class mainThread {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            try {
                Thread.sleep(10000);
                System.out.println("Hello from " + Thread.currentThread().getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread t2 = new Thread(() -> {
            try {
                Thread.sleep(10000);
                System.out.println("Hello from " + Thread.currentThread().getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        //setDaemon makes the thread background
//        t1.setDaemon(true);
//        t2.setDaemon(true);
//        t1.start();
//        t2.start();
//        t1.join();
//        t2.join();
        System.out.println("Hello from main thread");


       List<Thread> threads = new ArrayList<>();


        IntStream.range(0, 2).forEach(i -> threads.add(new Thread()));

        threads.forEach(thread -> {
            while(true){
                if(thread.isInterrupted()){
                    System.out.println("Thread " + Thread.currentThread().getName() + " has been interrupted!");
                }
            }
        });

    }


}


