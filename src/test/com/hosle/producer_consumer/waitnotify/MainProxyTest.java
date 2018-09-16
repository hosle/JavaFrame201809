package com.hosle.producer_consumer.waitnotify;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MainProxyTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void doMain() {
        try {
            new MainProxy().doMain();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}