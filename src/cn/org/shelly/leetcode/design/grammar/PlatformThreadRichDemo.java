package cn.org.shelly.leetcode.design.grammar;
import java.util.Set;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
public class PlatformThreadRichDemo {

    static final int TASK_COUNT = 5000;

    public static void main(String[] args) throws Exception {

        ExecutorService executor = Executors.newFixedThreadPool(100);

        AtomicInteger counter = new AtomicInteger();
        Set<String> threadNames = ConcurrentHashMap.newKeySet();

        long start = System.currentTimeMillis();

        for (int i = 0; i < TASK_COUNT; i++) {
            executor.submit(() -> {
                threadNames.add(Thread.currentThread().getName());

                try {
                    Thread.sleep(300);
                } catch (InterruptedException ignored) {}

                int done = counter.incrementAndGet();
                if (done % 1000 == 0) {
                    System.out.println(
                            "[平台线程] 已完成：" + done +
                                    "，当前线程：" + Thread.currentThread().getName()
                    );
                }
            });
        }

        executor.shutdown();
        executor.awaitTermination(5, TimeUnit.MINUTES);

        long end = System.currentTimeMillis();

        System.out.println("\n========== 平台线程统计 ==========");
        System.out.println("任务总数：" + TASK_COUNT);
        System.out.println("不同线程数：" + threadNames.size());
        System.out.println("线程示例：" + threadNames.stream().limit(5).toList());
        System.out.println("总耗时：" + (end - start) + " ms");

//        ========== 平台线程统计 ==========
//        任务总数：5000
//        不同线程数：100
//        线程示例：[pool-1-thread-39, pool-1-thread-38, pool-1-thread-37, pool-1-thread-36, pool-1-thread-35]
//        总耗时：15580 ms
    }
}