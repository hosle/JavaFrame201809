package com.hosle.singleton;

public class Singleton {

    private static Singleton instance;

    public static Singleton getInstance(){
        if(null == instance){
            synchronized(Singleton.class){
                if(null == instance){
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}
