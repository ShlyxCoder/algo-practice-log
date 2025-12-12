package cn.org.shelly.leetcode.design.juc;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.*;

public class CompletableFutureDemo {

    // 自定义线程池
    private static final ExecutorService executor = new ThreadPoolExecutor(
            4,
            8,
            60,
            TimeUnit.SECONDS,
            new LinkedBlockingQueue<>(),
            Executors.defaultThreadFactory(),
            new ThreadPoolExecutor.AbortPolicy()
    );

    public static void main(String[] args) throws Exception {

        System.out.println("主线程开始：" + Thread.currentThread().getName());
        // -----------------------------
        // 1. runAsync：异步执行，无返回值
        // -----------------------------
        CompletableFuture<Void> future1 = CompletableFuture.runAsync(() -> {
            sleep(500);
            System.out.println("任务1：runAsync 无返回值 -> " + Thread.currentThread().getName());
        }, executor);
        // -----------------------------
        // 2. supplyAsync：异步执行，有返回值
        // -----------------------------
        CompletableFuture<Integer> future2 = CompletableFuture.supplyAsync(() -> {
            sleep(700);
            System.out.println("任务2：supplyAsync 返回10 -> " + Thread.currentThread().getName());
            return 10;
        }, executor);



        // -----------------------------
        // 3. thenApply：串行处理上一步结果，有返回值
        // -----------------------------
        CompletableFuture<Integer> future3 = future2.thenApply(result -> {
            System.out.println("任务3：thenApply 收到结果 = " + result);
            return result * 2;
        });


        // -----------------------------
        // 4. thenAccept：接收结果，不返回
        // -----------------------------
        CompletableFuture<Void> future4 = future3.thenAccept(res -> {
            System.out.println("任务4：thenAccept 收到结果，不返回 -> " + res);
        });



        // -----------------------------
        // 5. thenRun：不接收结果，也不返回，只做额外动作
        // -----------------------------
        CompletableFuture<Void> future5 = future3.thenRun(() -> {
            System.out.println("任务5：thenRun 不接收结果 -> 做一些额外操作");
        });



        // -----------------------------
        // 6. thenCombine：两个任务都完成后合并结果
        // -----------------------------
        CompletableFuture<Integer> future6 = future2.thenCombine(future3, (r2, r3) -> {
            System.out.println("任务6：thenCombine 合并结果: " + r2 + " + " + r3);
            return r2 + r3;
        });



        // -----------------------------
        // 7. thenCompose：任务扁平化（类似 flatMap）
        // future2 -> futureX
        // -----------------------------
        CompletableFuture<Integer> future7 = future2.thenCompose(num -> {
            return CompletableFuture.supplyAsync(() -> {
                System.out.println("任务7：thenCompose：收到 " + num + " 再次异步处理");
                return num + 5;
            });
        });



        // -----------------------------
        // 8. allOf：等待多个任务全部完成
        // -----------------------------
        CompletableFuture<Void> all = CompletableFuture.allOf(future1, future2, future3, future7);
        all.thenRun(() -> {
            System.out.println("任务8：allOf 所有任务完成！");
        });



        // -----------------------------
        // 9. anyOf：任意一个完成就继续
        // -----------------------------
        CompletableFuture<Object> any = CompletableFuture.anyOf(future2, future7);
        any.thenAccept(result -> {
            System.out.println("任务9：anyOf 最快的任务返回 -> " + result);
        });



        // -----------------------------
        // 10. 异常处理 exceptionally
        // -----------------------------
        CompletableFuture<Integer> future10 = CompletableFuture.supplyAsync(() -> {
            System.out.println("任务10：故意抛异常");
            int i = 1 / 0;
            return 1;
        }).exceptionally(e -> {
            System.out.println("任务10：捕获异常 -> " + e.getMessage());
            return -1;
        });



        // -----------------------------
        // 11. handle：无论成功失败，都能处理
        // -----------------------------
        CompletableFuture<Integer> future11 = CompletableFuture.supplyAsync(() -> {
            System.out.println("任务11：正常执行返回20");
            return 20;
        }).handle((res, ex) -> {
            if (ex != null) {
                System.out.println("任务11出现异常");
                return -1;
            } else {
                System.out.println("任务11执行成功，结果 -> " + res);
                return res + 1;
            }
        });

        // 等待关键结果
        System.out.println("最终结果 future6 = " + future6.get());
        System.out.println("最终结果 future7 = " + future7.get());
        System.out.println("最终结果 future10 = " + future10.get());
        System.out.println("最终结果 future11 = " + future11.get());

        System.out.println("主线程结束：" + Thread.currentThread().getName());
        executor.shutdown();
    }

    private static void sleep(long ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
