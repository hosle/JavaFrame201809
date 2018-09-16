package com.hosle;

public class Main {

    public static String obj1 = "obj1";
    public static String obj2 = "obj2";

    public static void main(String[] args) {
	// write your code here
        new Thread(new DeadLock("obj1")).start();
        new Thread(new DeadLock("obj2")).start();
    }
}

