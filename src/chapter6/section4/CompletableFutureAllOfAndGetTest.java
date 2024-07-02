package chapter6.section4;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableFutureAllOfAndGetTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<Void> future1 = CompletableFuture.runAsync(() -> {
            // 작업 1
            try {
                Thread.sleep(1000); // 1초 대기
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("작업 1 완료");
        });

        CompletableFuture<Void> future2 = CompletableFuture.runAsync(() -> {
            // 작업 2
            try {
                Thread.sleep(2000); // 2초 대기
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("작업 2 완료");
        });

        CompletableFuture<Void> allOfFuture = CompletableFuture.allOf(future1, future2);

        CompletableFuture<String> resultFuture = allOfFuture.thenApply(v -> {
            return "모든 작업이 완료되었습니다.";
        });

        try {
            String result = resultFuture.get();
            System.out.println(result); // 출력: 모든 작업이 완료되었습니다.
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }

}

/**
 * 동작 과정
 * 1. CompletableFuture.allOf(future1, future2):
 *    * future1과 future2가 모두 완료될 때까지 기다립니다.
 *    * 이 CompletableFuture는 Void 타입을 반환합니다.
 * 2. allOfFuture.thenApply(v -> "모든 작업이 완료되었습니다."):
 *    * allOfFuture가 완료된 후, "모든 작업이 완료되었습니다."라는 문자열을 반환하는 새로운 CompletableFuture<String>를 생성합니다.
 * 3. resultFuture.get():
 *    * resultFuture가 완료될 때까지 현재 스레드를 블로킹합니다.
 *    * resultFuture가 완료되면 "모든 작업이 완료되었습니다."라는 문자열을 반환합니다.
 *
 * 주요 포인트
 * * allOf()는 여러 비동기 작업이 모두 완료될 때까지 기다리는 CompletableFuture를 생성합니다.
 * * thenApply()는 allOf()가 완료된 후 실행할 작업을 정의하며, 새로운 결과를 반환합니다.
 * * get()은 해당 CompletableFuture가 완료될 때까지 현재 스레드를 블로킹하고, 완료된 후 결과를 반환합니다.
 *
 * 요약
 * * CompletableFuture.allOf().thenApply().get()는 여러 비동기 작업이 모두 완료된 후, 그 결과를 동기적으로 처리하는 방법입니다.
 * * get()을 호출하면 해당 CompletableFuture가 완료될 때까지 블로킹되므로, 결과를 기다리는 동안 현재 스레드는 멈추게 됩니다.
 * * 이 방법을 사용하면 비동기 작업의 결과를 동기적으로 처리할 수 있지만, get()이 블로킹 메서드이므로 주의해서 사용해야 합니다. 주로 메인 스레드나 중요한 스레드에서 사용하지 않는 것이 좋습니다.
 */