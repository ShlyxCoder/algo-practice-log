package cn.org.shelly.leetcode.design.grammar;

import java.time.Duration;
import java.util.concurrent.*;

public class VirtualThreadApiDemo {

    public static void main(String[] args) throws Exception {

        // 1️⃣ 直接启动一个虚拟线程
        Thread vt1 = Thread.startVirtualThread(() -> {
            print("startVirtualThread");
        });

        vt1.join();

//        Thread pt1 = new Thread(() -> {
//            print("new Thread");
//        });
//        pt1.start();
//        pt1.join();


        // 2️⃣ 用 Thread.Builder 创建虚拟线程
        Thread vt2 = Thread.ofVirtual()
                .name("vt-builder")
                .start(() -> {
                    print("Thread.ofVirtual()");
                });

        vt2.join();

        Thread pt2 = Thread.ofPlatform()
                .name("pt-builder")
                .start(() -> {
                    print("Thread.ofPlatform()");
                });
        pt2.join();


        // 3️⃣ 虚拟线程 + join / sleep
        Thread vt3 = Thread.ofVirtual().start(() -> {
            try {
                Thread.sleep(Duration.ofMillis(200));
                print("sleep + join");
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        vt3.join();

        // 4️⃣ 虚拟线程 Executor（最重要）
        try (ExecutorService executor =
                     Executors.newVirtualThreadPerTaskExecutor()) {

            Future<String> f1 = executor.submit(() -> {
                print("executor task 1");
                return "A";
            });

            Future<String> f2 = executor.submit(() -> {
                print("executor task 2");
                return "B";
            });

            System.out.println("result = " + f1.get() + f2.get());
        }

        // 5️⃣ 虚拟线程 + Callable + timeout
        try (ExecutorService executor =
                     Executors.newVirtualThreadPerTaskExecutor()) {

            Future<String> future = executor.submit(() -> {
                Thread.sleep(500);
                return "timeout-test";
            });

            try {
                System.out.println(future.get(100, TimeUnit.MILLISECONDS));
            } catch (TimeoutException e) {
                System.out.println("timeout occurred");
            }
        }

        // 6️⃣ 虚拟线程的中断
        Thread vt4 = Thread.ofVirtual().start(() -> {
            try {
                while (true) {
                    Thread.sleep(100);
                }
            } catch (InterruptedException e) {
                print("interrupted");
            }
        });

        Thread.sleep(300);
        vt4.interrupt();
        vt4.join();

        // 7️⃣ 判断是否是虚拟线程
        Thread vt5 = Thread.ofVirtual().start(() -> {
            System.out.println("isVirtual = "
                    + Thread.currentThread().isVirtual());
        });

        vt5.join();
    }

    private static void print(String msg) {
        Thread t = Thread.currentThread();
        System.out.printf(
                "[%s] name=%s, virtual=%s%n",
                msg,
                t.getName(),
                t.isVirtual()
        );
    }
}
