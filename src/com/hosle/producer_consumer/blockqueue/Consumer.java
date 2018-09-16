package com.hosle.producer_consumer.blockqueue;

import com.hosle.producer_consumer.PCData;

import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable {

    private BlockingQueue<PCData> queue;
    private static final int SLEEPTIME = 1000;

    public Consumer(BlockingQueue<PCData> queue){
        this.queue = queue;
    }

    @Override
    public void run() {

        try {

            while (true) {
                PCData data = queue.take();
                if(data != null){
                    int re = data.getIntData();

                    System.out.println("消费"+re);

                    Thread.sleep(SLEEPTIME);
                }
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
            Thread.currentThread().interrupt();
        }
    }
}
