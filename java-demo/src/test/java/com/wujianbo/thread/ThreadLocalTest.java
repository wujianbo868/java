package com.wujianbo.thread;

import org.junit.Test;

/**
 * @author wujianbo
 * 多线程每个线程的独有变量
 */
public class ThreadLocalTest {

    @Test
    public void testThreadLocal() throws InterruptedException {
        final TestClass testClass = new TestClass();
        testClass.set();
        System.out.println(testClass.getLong());
        System.out.println(testClass.getString());

        Thread thread1 = new Thread(()->{
            testClass.set();
            System.out.println(testClass.getLong());
            System.out.println(testClass.getString());
        });
        thread1.start();
        thread1.join();

        System.out.println(testClass.getLong());
        System.out.println(testClass.getString());
    }

    class TestClass {
        ThreadLocal<Long> longLocal = new ThreadLocal<>();
        ThreadLocal<String> stringLocal = new ThreadLocal<>();

        private void set() {
            longLocal.set(Thread.currentThread().getId());
            stringLocal.set(Thread.currentThread().getName());
        }

        private long getLong() {
            return longLocal.get();
        }

        private String getString() {
            return stringLocal.get();
        }
    }

}
