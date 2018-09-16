package com.hosle.producer_consumer.waitnotify;

import com.hosle.producer_consumer.PCData;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainProxy {

    public void doMain() throws InterruptedException {
        List<PCData> queue = new ArrayList<PCData>(10);

        Producer p1 = new Producer(queue,10);
        Producer p2 = new Producer(queue,10);
        Producer p3 = new Producer(queue,10);
        Consumer c1 = new Consumer(queue);
        Consumer c2 = new Consumer(queue);
        Consumer c3 = new Consumer(queue);

        ExecutorService service = Executors.newCachedThreadPool();

        service.execute(p1);
        service.execute(p2);
        service.execute(p3);
        service.execute(c1);
        service.execute(c2);
        service.execute(c3);

        Thread.sleep(10* 1000);

        service.shutdown();

    }
}
