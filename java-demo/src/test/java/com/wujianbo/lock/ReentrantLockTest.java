package com.wujianbo.lock;

import org.junit.Test;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @Auther: wujianbo
 * @Date: 2018/5/16 20:52
 * @Description:
 */
public class ReentrantLockTest {

    class Test implements Runnable{
        ReentrantLock lock = new ReentrantLock();

        public void get(){
            lock.lock();
            System.out.println("get:"+Thread.currentThread().getId());
            set();
            lock.unlock();
        }

        public void set(){
            lock.lock();
            System.out.println("set:"+Thread.currentThread().getId());
            lock.unlock();
        }

        @Override
        public void run(){
            get();
        }
    }

    @org.junit.Test
    public void testThread(){
        Test ss = new Test();
        new Thread(ss).start();
        new Thread(ss).start();
        new Thread(ss).start();
        new Thread(ss).start();
        new Thread(ss).start();
        new Thread(ss).start();
        new Thread(ss).start();
        new Thread(ss).start();
        new Thread(ss).start();
        new Thread(ss).start();
        new Thread(ss).start();
        new Thread(ss).start();
    }
}
