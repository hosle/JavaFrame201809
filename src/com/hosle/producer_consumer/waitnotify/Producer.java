package com.hosle.producer_consumer.waitnotify;

import com.hosle.producer_consumer.PCData;

import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class Producer implements Runnable {



    private List<PCData> queue;

    private int length;

    private static AtomicInteger count = new AtomicInteger();

    private static final int SLEEPTIME = 1000;

    public Producer(List<PCData> queue, int length){

        this.queue = queue;
        this.length = length;
    }

    @Override
    public void run() {

        PCData data = null;

        try {

            while (true) {

                if (Thread.currentThread().isInterrupted())
                    break;

                data = new PCData(count.incrementAndGet());

                synchronized(queue){
                    while(queue.size() >= length){
                        queue.wait();
                    }
                    System.out.println("生产"+ data.getIntData());

                    queue.add(data);

                    queue.notifyAll();

                }


                Thread.sleep(SLEEPTIME);

            }
        } catch (InterruptedException e) {
            e.printStackTrace();
            Thread.currentThread().interrupt();
        }
    }
}
