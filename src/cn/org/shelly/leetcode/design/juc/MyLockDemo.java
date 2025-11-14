package cn.org.shelly.leetcode.design.juc;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class MyLockDemo {

    // =======================
    // 自定义AQS锁
    // =======================
    abstract static class MyAbstractSync extends AbstractQueuedSynchronizer {
        abstract boolean isReentrant(); // 是否可重入

        @Override
        protected boolean tryAcquire(int arg) {
            Thread current = Thread.currentThread();
            int c = getState();

            if (c == 0) {
                // 公平锁检查队列
                if ((!isFair() || !hasQueuedPredecessors()) && compareAndSetState(0, arg)) {
                        setExclusiveOwnerThread(current);
                        return true;
                    }
            } else {
                if (isReentrant() && current == getExclusiveOwnerThread()) {
                    setState(c + arg); // 可重入加锁
                    return true;
                }
            }
            return false;
        }

        @Override
        protected boolean tryRelease(int arg) {
            if (Thread.currentThread() != getExclusiveOwnerThread())
                throw new IllegalMonitorStateException();
            int c = getState() - arg;
            boolean free = false;
            if (c == 0) {
                free = true;
                setExclusiveOwnerThread(null);
            }
            setState(c);
            return free;
        }

        protected Condition newCondition() {
            return new ConditionObject();
        }

        @Override
        protected boolean isHeldExclusively() {
            return getExclusiveOwnerThread() == Thread.currentThread();
        }

        // 默认非公平
        protected boolean isFair() {
            return false;
        }
    }

    // =====================================
    // 四种锁实现类
    // =====================================
    static class NonReentrantNonFairSync extends MyAbstractSync {
        @Override
        boolean isReentrant() { return false; }
    }

    static class NonReentrantFairSync extends MyAbstractSync {
        @Override
        boolean isReentrant() { return false; }
        @Override
        protected boolean isFair() { return true; }
    }

    static class ReentrantNonFairSync extends MyAbstractSync {
        @Override
        boolean isReentrant() { return true; }
    }

    static class ReentrantFairSync extends MyAbstractSync {
        @Override
        boolean isReentrant() { return true; }
        @Override
        protected boolean isFair() { return true; }
    }

    // =====================================
    // 锁封装类
    // =====================================
    static class MyLock implements Lock {
        private final MyAbstractSync sync;
        public MyLock(MyAbstractSync sync) { this.sync = sync; }

        @Override public void lock() { sync.acquire(1); }
        @Override public void lockInterruptibly() throws InterruptedException { sync.acquireInterruptibly(1); }
        @Override public boolean tryLock() { return sync.tryAcquire(1); }
        @Override public boolean tryLock(long time, TimeUnit unit) throws InterruptedException { return sync.tryAcquireNanos(1, unit.toNanos(time)); }
        @Override public void unlock() { sync.release(1); }
        @Override public Condition newCondition() { return sync.newCondition(); }
    }

    // =====================================
    // main方法演示
    // =====================================
    public static void main(String[] args) {
        // 创建四种锁
        Lock lock1 = new MyLock(new NonReentrantNonFairSync());
        Lock lock2 = new MyLock(new NonReentrantFairSync());
        Lock lock3 = new MyLock(new ReentrantNonFairSync());
        Lock lock4 = new MyLock(new ReentrantFairSync());

        System.out.println("非公平不可重入锁示例：");
        demoLock(lock1);

        System.out.println("\n公平不可重入锁示例：");
        demoLock(lock2);

        System.out.println("\n非公平可重入锁示例：");
        demoLock(lock3);

        System.out.println("\n公平可重入锁示例：");
        demoLock(lock4);
    }

    // 演示锁的基本使用
    private static void demoLock(Lock lock) {
        Runnable task = () -> {
            lock.lock();
            try {
                System.out.println(Thread.currentThread().getName() + " 获得锁");
                // 模拟工作
                try { Thread.sleep(100); } catch (InterruptedException ignored) {}
            } finally {
                lock.unlock();
                System.out.println(Thread.currentThread().getName() + " 释放锁");
            }
        };

        Thread t1 = new Thread(task, "T1");
        Thread t2 = new Thread(task, "T2");
        Thread t3 = new Thread(task, "T3");

        t1.start();
        t2.start();
        t3.start();

        try {
            t1.join(); t2.join(); t3.join();
        } catch (InterruptedException ignored) {}
    }
}
