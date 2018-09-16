package com.hosle.singleton;

/**
 * 饿汉式方式是只要Singleton类被装载就会实例化，
 * 没有Lazy-Loading的作用，而静态内部类方式在Singleton类被装载时并不会立即实例化，
 * 而是在需要实例化时，调用getInstance方法，才会装载SingletonInstance类，
 * 从而完成Singleton的实例化。
 */
public class Singleton2 {

    private static class SingletonInstance{
        private static final Singleton2 instance = new Singleton2();
    }

    public static Singleton2 getInstance(){
        return SingletonInstance.instance;
    }
}
