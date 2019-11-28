package io.turntabl.dataaccess;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.stream.IntStream;

public class classQueue {

    public static void main(String[] args) throws InterruptedException {
        int capacity = 20;

        ArrayBlockingQueue<Integer> queue = new ArrayBlockingQueue<>(capacity);

       Thread producer = new Thread(() -> {
           IntStream.range(0, capacity).forEach(i -> {
               queue.offer(i);
               System.out.println("Adding " + i + "......");
           });

       });

       Thread consumer = new Thread(() ->{
           IntStream.range(0, capacity).forEach(i -> {
               queue.poll();
               System.out.println("Removing " + i + "......");
           });

       });
       producer.start();
       consumer.start();
       producer.join();
       consumer.join();
       System.out.println(queue);


    }
}
