package cn.org.shelly;


import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

class Solution {
    static char next = 'A';
    static final Object lock = new Object();
    static ReentrantLock rlock = new ReentrantLock();
    static final Condition condition = rlock.newCondition();

    public static void fuc() {
        new Thread(() -> {
            for (int i = 0; i < 5; ) {
                rlock.lock();
                try {
                    if (next == 'A') {
                        System.out.print('A');
                        next = 'B';
                        i++;
                    }
                } finally {
                    rlock.unlock();
                }
            }
        }).start();

        new Thread(() -> {
            for (int i = 0; i < 5; ) {
                rlock.lock();
                try {
                    if (next == 'B') {
                        System.out.print('B');
                        next = 'A';
                        i++;
                    }
                } finally {
                    rlock.unlock();
                }
            }
        }).start();
    }
    public static void fuc2() {

        Thread t1 = new Thread(() -> {
            rlock.lock();
            try {
                for (int i = 0; i < 5; i++) {
                    while (next != 'A') {
                        condition.await();   // 释放锁 + 进入等待队列
                    }
                    System.out.print('A');
                    next = 'B';
                    condition.signalAll();  // 唤醒等待线程
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            } finally {
                rlock.unlock();
            }
        });

        Thread t2 = new Thread(() -> {
            rlock.lock();
            try {
                for (int i = 0; i < 5; i++) {
                    while (next != 'B') {
                        condition.await();
                    }
                    System.out.print('B');
                    next = 'A';
                    condition.signalAll();
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            } finally {
                rlock.unlock();
            }
        });

        t1.start();
        t2.start();
    }

    public static void main(String[] args) {

//        new Thread(() -> {
//            while (true) {
//                synchronized (lock) {
//                    while (next != 'A') {
//                        try {
//                            lock.wait();
//                        } catch (Exception e) {
//                            Thread.currentThread().interrupt();
//                        }
//                    }
//                    System.out.print('A');
//                    next = 'B';
//                    lock.notifyAll();
//                }
//            }
//        }).start();
//
//        new Thread(() -> {
//            while (true) {
//                synchronized (lock) {
//                    while (next != 'B') {
//                        try {
//                            lock.wait();
//                        } catch (Exception e) {
//                            Thread.currentThread().interrupt();
//                        }
//                    }
//                    System.out.print('B');
//                    next = 'A';
//                    lock.notifyAll();
//                }
//            }
//        }).start();
        fuc2();
    }
}