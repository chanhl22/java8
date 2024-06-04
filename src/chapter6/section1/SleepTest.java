package chapter6.section1;

public class SleepTest {
    public static void main(String[] args) {
        TestThread thread = new TestThread();
        thread.start();

        try {
            System.out.println("main에서 호출되었다!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class TestThread extends Thread {
    public void run() {
        try {
            Thread.sleep(10000);
            System.out.println("TestThread 에서 호출되었다!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}