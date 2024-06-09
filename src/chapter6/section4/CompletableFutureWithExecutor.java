package chapter6.section4;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CompletableFutureWithExecutor {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // 사용자 정의 Executor 생성
        ExecutorService executor = Executors.newFixedThreadPool(2);

        // 사용자 정의 Executor를 사용하여 비동기 작업 실행
        CompletableFuture<Void> future1 = CompletableFuture.runAsync(() -> {
            System.out.println("Hello1 " + Thread.currentThread().getName());
        }, executor);

        CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> {
            System.out.println("Hello2 " + Thread.currentThread().getName());
            return "Hello";
        }, executor);


        System.out.println(future1.get());
        System.out.println(future2.get());

        executor.shutdown();
    }

}
