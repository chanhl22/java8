package chapter6.section4;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableFutureThenCompose {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        /**
         * as is
         */
//        CompletableFuture<String> hello = CompletableFuture.supplyAsync(() -> {
//            System.out.println("Hello " + Thread.currentThread().getName());
//            return "Hello";
//        });
//
//        CompletableFuture<String> world = CompletableFuture.supplyAsync(() -> {
//            System.out.println("Hello " + Thread.currentThread().getName());
//            return "World";
//        });
//
//        hello.get();
//        world.get();

        /**
         * tobe
         */
        CompletableFuture<String> hello = CompletableFuture.supplyAsync(() -> {
            System.out.println("Hello " + Thread.currentThread().getName());
            return "Hello";
        });

        CompletableFuture<String> future = hello.thenCompose(CompletableFutureThenCompose::getWorld);

        System.out.println(future.get());

    }

    private static CompletableFuture<String> getWorld(String message) {
        return CompletableFuture.supplyAsync(() -> {
            System.out.println("World " + Thread.currentThread().getName());
            return message + " World";
        });
    }

}
