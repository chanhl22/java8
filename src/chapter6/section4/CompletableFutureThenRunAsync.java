package chapter6.section4;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CompletableFutureThenRunAsync {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(2);

        CompletableFuture<Void> future = CompletableFuture.supplyAsync(() -> {
            System.out.println("Hello " + Thread.currentThread().getName());
            return "Hello";
        }, executor).thenRunAsync(() -> {
            System.out.println(Thread.currentThread().getName());
        }, executor);

        System.out.println(future.get());
        executor.shutdown();
    }

}
