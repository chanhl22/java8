package chapter6.section3;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableInvokeAll {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(4);

        Callable<String> hello = () -> {
            Thread.sleep(2000L);
            return "Hello";
        };

        Callable<String> java = () -> {
            Thread.sleep(3000L);
            return "Java";
        };

        Callable<String> spring = () -> {
            Thread.sleep(1000L);
            return "Spring";
        };

        List<Future<String>> futures = executorService.invokeAll(List.of(hello, java, spring));
        for (Future<String> future : futures) {
            System.out.println(future.get());
        }

        executorService.shutdown();
    }

}
