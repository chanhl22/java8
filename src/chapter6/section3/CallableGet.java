package chapter6.section3;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableGet {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newSingleThreadExecutor();

//        Callable<String> hello = new Callable<String>() {
//            @Override
//            public String call() throws Exception {
//                return null;
//            }
//        };

        Callable<String> hello = () -> {
            Thread.sleep(2000L);
            return "Hello";
        };

        Future<String> submit = executorService.submit(hello);
        System.out.println("Started!");

        submit.get();

        System.out.println("End!");
        executorService.shutdown();
    }

}
