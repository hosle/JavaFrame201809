package com.hosle.producer_consumer.blockqueue;

import com.hosle.producer_consumer.PCData;

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class Producer implements Runnable {


    private volatile boolean isRunning = true;

    private BlockingQueue<PCData> queue;

    private static AtomicInteger count = new AtomicInteger();

    private static final int SLEEPTIME = 1000;

    public Producer(BlockingQueue<PCData> queue){
        this.queue = queue;
    }

    @Override
    public void run() {

        PCData data = null;

        try {

            while (isRunning) {
                Thread.sleep(SLEEPTIME);
                data = new PCData(count.incrementAndGet());
                System.out.println("生产"+ data.getIntData());

                if (!queue.offer(data, 2, TimeUnit.SECONDS)) {
                    System.out.println("添加到队列失败");
                }

            }
        } catch (InterruptedException e) {
            e.printStackTrace();
            Thread.currentThread().interrupt();
        }
    }

    public void stop(){
        isRunning = false;
    }
}
