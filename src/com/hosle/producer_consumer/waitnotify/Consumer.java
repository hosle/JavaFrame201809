package com.hosle.producer_consumer.waitnotify;

import com.hosle.producer_consumer.PCData;

import java.util.List;
import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable {

    private List<PCData> queue;
    private static final int SLEEPTIME = 1000;

    public Consumer(List<PCData> queue){
        this.queue = queue;
    }

    @Override
    public void run() {

        try {

            while (true) {
                if (Thread.currentThread().isInterrupted())
                    break;

                PCData data = null;

                synchronized(queue){
                    while(queue.size() == 0){
                        queue.wait();
                    }

                    data = queue.remove(0);
                    System.out.println("消费"+ data.getIntData());

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
