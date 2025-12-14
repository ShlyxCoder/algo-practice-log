package cn.org.shelly.leetcode.design.grammar;

import java.util.Set;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class VirtualThreadRichDemo {
    static final int TASK_COUNT = 5000;

    // 用来提取 carrier 线程名
    static final Pattern CARRIER_PATTERN =
            Pattern.compile("ForkJoinPool-\\d+-worker-\\d+");

    public static void main(String[] args) throws Exception {

        ExecutorService executor =
                Executors.newVirtualThreadPerTaskExecutor();

        AtomicInteger counter = new AtomicInteger();

        // 用 threadId 统计虚拟线程
        Set<Long> virtualThreadIds = ConcurrentHashMap.newKeySet();
        // 只统计真正的 carrier
        Set<String> carrierThreads = ConcurrentHashMap.newKeySet();

        long start = System.currentTimeMillis();

        for (int i = 0; i < TASK_COUNT; i++) {
            executor.submit(() -> {
                Thread t = Thread.currentThread();

                // ✅ 虚拟线程唯一标识
                virtualThreadIds.add(t.threadId());

                // ✅ 解析 carrier 线程
                Matcher m = CARRIER_PATTERN.matcher(t.toString());
                if (m.find()) {
                    carrierThreads.add(m.group());
                }

                try {
                    Thread.sleep(300);
                } catch (InterruptedException ignored) {}

                int done = counter.incrementAndGet();
                if (done % 1000 == 0) {
                    System.out.println(
                            "[虚拟线程] 已完成：" + done +
                                    "，当前：" + t
                    );
                }
            });
        }

        executor.shutdown();
        executor.awaitTermination(1, TimeUnit.MINUTES);

        long end = System.currentTimeMillis();

        System.out.println("\n========== 虚拟线程统计（修正版） ==========");
        System.out.println("任务总数：" + TASK_COUNT);
        System.out.println("虚拟线程数：" + virtualThreadIds.size());
        System.out.println("Carrier(OS)线程数：" + carrierThreads.size());
        System.out.println("Carrier 示例：" +
                carrierThreads.stream().limit(5).toList());
        System.out.println("总耗时：" + (end - start) + " ms");
//        任务总数：5000
//        虚拟线程数：5000
//        Carrier(OS)线程数：16
//        Carrier 示例：[ForkJoinPool-1-worker-8, ForkJoinPool-1-worker-9, ForkJoinPool-1-worker-6, ForkJoinPool-1-worker-7, ForkJoinPool-1-worker-12]
//        总耗时：354 ms
    }
}
