package io.turntabl.execution.barriers;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class Horses extends Thread {
    private CyclicBarrier barrier;

    public Horses(String i, CyclicBarrier barrier){
        super(i);
        this.barrier = barrier;
    }
    @Override
    public void run(){
        try{
            System.out.println("horse " + Thread.currentThread().getName() + " ready");
            barrier.await();
            System.out.println("horse " + Thread.currentThread().getName() + " galloping");
            Thread.sleep(10000);
            System.out.println("horse " + Thread.currentThread().getName() + " finished");
            barrier.await();
        }
        catch(InterruptedException ie){}
        catch(BrokenBarrierException bbe){}
    }
}
