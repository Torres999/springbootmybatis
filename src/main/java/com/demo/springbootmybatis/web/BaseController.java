package com.demo.springbootmybatis.web;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BaseController {
    private static Lock lock = new ReentrantLock();
    private static Condition condition = lock.newCondition();

    private static Thread thread1;
    private static Thread thread2;

    private static ThreadLocal threadLocal = new ThreadLocal();

    public static void main(String[] args) {

        lock.lock(); // 获取锁
        ThreadA ta = new ThreadA("ta");
        System.out.println("lock: " + lock);
        System.out.println("Parent thread: " + Thread.currentThread());
        threadLocal.set(Thread.currentThread());
        thread1 = Thread.currentThread();
        try {
            System.out.println(Thread.currentThread().getName() + " start ta");
            ta.start();

            System.out.println(Thread.currentThread().getName() + " block");
            condition.await();    // 等待

            System.out.println(Thread.currentThread().getName() + " continue");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();    // 释放锁
        }
    }

    static class ThreadA extends Thread {
        public ThreadA(String name) {
            super(name);
        }

        public void run() {
            System.out.println("===================");
            System.out.println("threadLocal: " + threadLocal.get());
            System.out.println("lock: " + lock);
            lock.lock();    // 获取锁
            System.out.println("lock: " + lock);
            System.out.println("Inner thread: " + Thread.currentThread());
            thread2 = Thread.currentThread();
            System.out.println("thread2 =? thread1: " + String.valueOf(thread2.equals(thread1)));
            try {
                System.out.println(Thread.currentThread().getName() + " wakup others");
                condition.signal();    // 唤醒“condition所在锁上的其它线程”
            } finally {
                lock.unlock();    // 释放锁
            }
            System.out.println("===================");
        }
    }
}
