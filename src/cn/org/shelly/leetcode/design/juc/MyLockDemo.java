package cn.org.shelly.leetcode.design.juc;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class MyLockDemo {

    // =======================
    // 自定义AQS锁
    // =======================
    /**
     * 自定义同步器基类，基于 AbstractQueuedSynchronizer(AQS) 实现
     * 支持可重入/不可重入，公平/非公平锁
     */
    abstract static class MyAbstractSync extends AbstractQueuedSynchronizer {

        // 子类实现，返回 true 表示可重入锁，false 表示不可重入锁
        abstract boolean isReentrant();

        /**
         * 尝试获取锁（独占模式）
         * @param arg 请求的锁数量，一般为1
         * @return true 表示成功获取锁，false 表示获取失败
         */
        @Override
        protected boolean tryAcquire(int arg) {
            Thread current = Thread.currentThread();
            int c = getState(); // 获取当前锁状态，0表示未锁定，大于0表示已锁定

            if (c == 0) {
                // 当前锁未被占用
                // 公平锁：检查等待队列，确保先到线程先获取锁
                // 非公平锁：直接尝试 CAS 获取锁
                if ((!isFair() || !hasQueuedPredecessors()) && compareAndSetState(0, arg)) {
                    setExclusiveOwnerThread(current); // 设置当前线程为锁持有者
                    return true;
                }
            } else {
                // 锁已被占用
                // 如果是可重入锁，且当前线程就是持有锁线程，则允许再次获取
                if (isReentrant() && current == getExclusiveOwnerThread()) {
                    setState(c + arg); // 状态累加，表示重入次数
                    return true;
                }
            }

            // 其他情况获取锁失败
            return false;
        }

        /**
         * 尝试释放锁（独占模式）
         * @param arg 释放的锁数量，一般为1
         * @return true 表示锁已完全释放，false 表示锁仍被持有
         */
        @Override
        protected boolean tryRelease(int arg) {
            // 不是锁持有线程调用解锁，抛出异常
            if (Thread.currentThread() != getExclusiveOwnerThread())
                throw new IllegalMonitorStateException();

            int c = getState() - arg; // 减少锁状态
            boolean free = false;
            if (c == 0) {
                // 状态为0表示锁完全释放
                free = true;
                setExclusiveOwnerThread(null); // 清空持有者线程
            }
            setState(c); // 更新锁状态（可能仍大于0，表示可重入锁仍被占用）
            return free;
        }

        /**
         * 创建一个条件变量对象
         * @return Condition 实例，用于 await() / signal() 等操作
         */
        protected Condition newCondition() {
            return new ConditionObject(); // AQS 提供的内部 Condition 实现
        }

        /**
         * 判断当前线程是否独占锁
         * @return true 表示当前线程持有锁
         */
        @Override
        protected boolean isHeldExclusively() {
            return getExclusiveOwnerThread() == Thread.currentThread();
        }

        /**
         * 默认非公平锁，子类可以重写返回 true 表示公平锁
         */
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
