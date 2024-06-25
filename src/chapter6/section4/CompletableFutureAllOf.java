package chapter6.section4;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableFutureAllOf {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<String> hello = CompletableFuture.supplyAsync(() -> {
            System.out.println("Hello " + Thread.currentThread().getName());
            return "Hello";
        });

        CompletableFuture<String> world = CompletableFuture.supplyAsync(() -> {
            System.out.println("Hello " + Thread.currentThread().getName());
            return "World";
        });


        CompletableFuture<Void> future = CompletableFuture.allOf(hello, world)
                .thenApply(result -> {
                    System.out.println(result);
                    return result;
                });

        System.out.println(future.get());
    }

}
