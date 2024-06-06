package chapter6.section1;

public class RunnableThread {
    public static void main(String[] args) {
//        Thread thread = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("Thread: " + Thread.currentThread().getName());
//            }
//        });

        Thread thread = new Thread(() -> {
            System.out.println("Thread: " + Thread.currentThread().getName());
        });
        thread.start();

        System.out.println("Hello: " + Thread.currentThread().getName());
    }
}
