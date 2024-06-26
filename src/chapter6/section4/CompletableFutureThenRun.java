package chapter6.section4;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableFutureThenRun {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<Void> future = CompletableFuture.supplyAsync(() -> {
            System.out.println("Hello " + Thread.currentThread().getName());
            return "Hello";
        }).thenRun(() -> {
            System.out.println(Thread.currentThread().getName());
        });

        System.out.println(future.get());
    }

}
