package chapter1.lambda;

import java.util.function.Consumer;
import java.util.function.IntConsumer;

public class Foo {

    public static void main(String[] args) {
        Foo foo = new Foo();
        foo.run();
    }

    private void run() {
        int baseNumber = 10;
        //baseNumber++; //불가능

        // 로컬 클래스
        class LocalClass {
            void printBaseNumber() {
                System.out.println(baseNumber);
            }
        }

        // 로컬 클래스
        class LocalClassAnother {
            void printBaseNumber() {
                int baseNumber = 11;
                System.out.println(baseNumber); //11
            }
        }

        // 익명 클래스
        Consumer<Integer> integerConsumer = new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) {
                System.out.println(baseNumber);
            }
        };

        // 익명 클래스
        Consumer<Integer> integerConsumerAnother = new Consumer<Integer>() {
            @Override
            public void accept(Integer baseNumber) {
                System.out.println(baseNumber); //11
            }
        };


        // 람다
        IntConsumer printInt = (i) -> {
            System.out.println(i + baseNumber);
        };

        //불가능
        //IntConsumer printIntAnother = (baseNumber) -> {
        //    System.out.println(baseNumber);
        //};

        printInt.accept(10);
    }

}
