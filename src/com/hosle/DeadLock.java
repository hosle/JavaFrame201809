package com.hosle;

public class DeadLock implements Runnable {

    private String tag;
    public DeadLock(String tag){
        this.tag = tag;
    }

    @Override
    public void run() {
        while(true){
            synchronized (tag.equals("obj1") ? Main.obj1 : Main.obj2) {
                try {
                    Thread.sleep(200);

                    synchronized (tag.equals("obj1") ? Main.obj2 : Main.obj1) {

                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
