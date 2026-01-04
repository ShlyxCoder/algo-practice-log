package cn.org.shelly.leetcode.design.juc;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ProducerConsumerDemo {

    // ===== 共享资源 =====
    private int value;
    private boolean hasValue = false;

    private final Lock lock = new ReentrantLock();
    private final Condition notEmpty = lock.newCondition();
    private final Condition notFull = lock.newCondition();

    // ===== 生产 =====
    public void produce(int v) throws InterruptedException {
        lock.lock();
        try {
            while (hasValue) {
                notFull.await();   // 满了，生产者等待
            }
            value = v;
            hasValue = true;
            System.out.println(Thread.currentThread().getName() + " 生产：" + v);

            notEmpty.signal();    // 唤醒消费者
        } finally {
            lock.unlock();
        }
    }

    // ===== 消费 =====
    public int consume() throws InterruptedException {
        lock.lock();
        try {
            while (!hasValue) {
                notEmpty.await(); // 空了，消费者等待
            }
            int v = value;
            hasValue = false;
            System.out.println(Thread.currentThread().getName() + " 消费：" + v);

            notFull.signal();     // 唤醒生产者
            return v;
        } finally {
            lock.unlock();
        }
    }

    // ===== 启动 =====
    public static void main(String[] args) {
        ProducerConsumerDemo demo = new ProducerConsumerDemo();

        Runnable producer = () -> {
            int i = 0;
            try {
                while (true) {
                    demo.produce(i++);
                    Thread.sleep(500);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        };

        Runnable consumer = () -> {
            try {
                while (true) {
                    demo.consume();
                    Thread.sleep(800);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        };

        new Thread(producer, "Producer").start();
        new Thread(consumer, "Consumer").start();
    }
}
