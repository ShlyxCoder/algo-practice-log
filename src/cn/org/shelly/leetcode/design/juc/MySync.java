package cn.org.shelly.leetcode.design.juc;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class MySync extends AbstractQueuedSynchronizer {
    @Override
    protected boolean tryAcquire(int arg) {
        if(arg == 1 && compareAndSetState(0,1)){
                setExclusiveOwnerThread(Thread.currentThread());
                return true;
            }
        return false;
    }

    @Override
    protected boolean tryRelease(int arg) {
        if(arg == 1 && isHeldExclusively() && compareAndSetState(1,0)){
            setExclusiveOwnerThread(null);
            return true;
        }
        return false;
    }
    protected Condition newCondition() {
        return new ConditionObject();
    }

    @Override
    protected boolean isHeldExclusively() {
        // 判断是不是自己线程
        return getExclusiveOwnerThread() == Thread.currentThread();
    }
}
class MyLock implements Lock{
    private final MySync mySync = new MySync();

    @Override
    public void lock() {
        mySync.acquire(1);
    }

    @Override
    public void lockInterruptibly() throws InterruptedException {
        mySync.acquireInterruptibly(1);
    }

    @Override
    public boolean tryLock() {
        return mySync.tryAcquire(1);
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return mySync.tryAcquireNanos(1, unit.toNanos(time));
    }

    @Override
    public void unlock() {
        mySync.release(1);
    }

    @Override
    public Condition newCondition() {
        return mySync.newCondition();
    }
}
