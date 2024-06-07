package chapter6.section4;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableFutureNew {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        CompletableFuture<String> future = new CompletableFuture<>();
//        future.complete("Hello");

        CompletableFuture<String> future = CompletableFuture.completedFuture("Hello");

        System.out.println(future.get());
    }

}
