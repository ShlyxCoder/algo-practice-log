package cn.org.shelly.leetcode.design;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class MyThreadPoolTest {
    public static void main(String[] args) {
        // 创建线程池：核心线程2，最大线程4，非核心线程空闲超时5秒，队列容量3
        MyThreadPool pool = new MyThreadPool(2, 4, 5, TimeUnit.SECONDS, 3);

        // 提交10个任务，简单打印线程名和任务编号
        for (int i = 1; i <= 10; i++) {
            final int taskNum = i;
            pool.execute(() -> {
                System.out.println(Thread.currentThread().getName() + " 执行任务 " + taskNum);
                try {
                    Thread.sleep(1000); // 模拟任务执行1秒
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            });
        }
        // 主线程等待一段时间，让任务都执行完
        try {
            Thread.sleep(15000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        System.out.println("测试结束");
    }
}
class MyThreadPool{
    private final int maxThreadCount;
    private final int coreThreadCount;

    private long timeOut;
    private TimeUnit timeUnit;

    private int capacity;

    private final MyQueue<Runnable> myQueue;

    private final Set<Worker> workers = new HashSet<>();

    public MyThreadPool(int coreThreadCount, int maxThreadCount, long timeOut, TimeUnit timeUnit, int capacity) {
        this.myQueue = new MyQueue<>(capacity);
        this.capacity = capacity;
        this.coreThreadCount = coreThreadCount;
        this.maxThreadCount = maxThreadCount;
        this.timeOut = timeOut;
        this.timeUnit = timeUnit;
    }
    public void execute(Runnable task) {
        synchronized (workers) {
            if (workers.size() < coreThreadCount) {
                // 核心线程没满，直接新建核心线程
                Worker worker = new Worker(task, true);
                workers.add(worker);
                worker.start();
            } else if (myQueue.size() < capacity) {
                // 核心线程满了，队列还有空间，直接放队列，任务入队会阻塞等待
                myQueue.push(task);
            } else if (workers.size() < maxThreadCount) {
                // 队列满了，非核心线程未满，创建非核心线程处理任务
                Worker worker = new Worker(task, false);
                workers.add(worker);
                worker.start();
            } else {
                // 线程数满了，队列也满了，拒绝任务（这里先抛异常）
                throw new RuntimeException("线程池和队列已满，拒绝任务");
            }
        }
    }

    class Worker extends Thread {
        private Runnable r;
        private final boolean core;

        public Worker(Runnable runnable, boolean isCore) {
            this.r = runnable;
            this.core = isCore;
        }

        @Override
        public void run() {
            try {
                while (true) {
                    if (r != null) {
                        try {
                            r.run();
                        } catch (Exception e) {
                            e.printStackTrace();
                        } finally {
                            r = null;
                        }
                    }
                    r = core ? myQueue.get() : myQueue.tryGet(timeOut, timeUnit);
                    // 非核心线程在超时未获取到任务时退出循环，结束线程
                    if (!core && r == null) {
                        break;
                    }
                    // 核心线程阻塞等待，r 永远不会为 null，循环继续
                }
            } finally {
                if (!core) {
                    synchronized (workers) {
                        workers.remove(this);
                    }
                }
            }
        }
    }



}
class MyQueue<T> {
    private Deque<T> taskQueue;
    private int maxSize;

    private final ReentrantLock lock = new ReentrantLock();
    private final Condition notFull = lock.newCondition();
    private final Condition notEmpty = lock.newCondition();

    public MyQueue(int maxSizeValue) {
        this.maxSize = maxSizeValue;
        taskQueue = new ArrayDeque<>();
    }

    public void push(T task) {
        lock.lock();
        try {
            while (taskQueue.size() == maxSize) {
                notFull.await();
            }
            taskQueue.addLast(task);
            notEmpty.signal();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        } finally {
            lock.unlock();
        }
    }

    public T get() {
        lock.lock();
        try {
            while (taskQueue.isEmpty()) {
                notEmpty.await();
            }
            T task = taskQueue.removeFirst();
            notFull.signal();
            return task;
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        } finally {
            lock.unlock();
        }
    }

    public int size() {
        lock.lock();
        try {
            return taskQueue.size();
        } finally {
            lock.unlock();
        }
    }

    public boolean tryPush(T task, long timeout, TimeUnit unit) {
        long nanos = unit.toNanos(timeout);
        lock.lock();
        try {
            while (taskQueue.size() == maxSize) {
                if (nanos <= 0) {
                    return false;
                }
                nanos = notFull.awaitNanos(nanos);
            }
            taskQueue.addLast(task);
            notEmpty.signal();
            return true;
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        } finally {
            lock.unlock();
        }
    }

    public T tryGet(long timeout, TimeUnit unit) {
        long nanos = unit.toNanos(timeout);
        lock.lock();
        try {
            while (taskQueue.isEmpty()) {
                if (nanos <= 0) {
                    return null;
                }
                nanos = notEmpty.awaitNanos(nanos);
            }
            T task = taskQueue.removeFirst();
            notFull.signal();
            return task;
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        } finally {
            lock.unlock();
        }
    }
}



