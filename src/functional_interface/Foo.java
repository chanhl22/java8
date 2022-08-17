package functional_interface;

import java.util.function.*;

public class Foo {
    public static void main(String[] args) {

        /**
         * Function<T, R>
         */
        Plus10 plus10_v1 = new Plus10();
        System.out.println(plus10_v1.apply(1));

        Function<Integer, Integer> plus10_v2 = (integer -> integer + 10);
        System.out.println(plus10_v2.apply(1));


        Function<Integer, Integer> plus10_v3 = (integer -> integer + 10);
        Function<Integer, Integer> multiply2 = (integer -> integer * 2);

        Function<Integer, Integer> multiply2AndPlus10 = plus10_v3.compose(multiply2);
        System.out.println(multiply2AndPlus10.apply(2));

        System.out.println(plus10_v3.andThen(multiply2).apply(2));

        /**
         * Consumer<T>
         */
        Consumer<Integer> printT = integer -> System.out.println(integer);
        printT.accept(10);

        /**
         * Supplier<T>
         */
        Supplier<Integer> get10 = () -> 10;
        System.out.println(get10.get());

        /**
         * Predicate<T>
         */
        Predicate<String> startsWithHello = (s -> s.startsWith("Hello"));
        Predicate<Integer> isEven = i -> i % 2 == 0;
        Predicate<Integer> isOdd = i -> i % 2 != 0;
        System.out.println(startsWithHello.test("Hello"));
        System.out.println(isEven.test(2));
        System.out.println(isEven.or(isOdd).test(2));
        System.out.println(isEven.and(isOdd).test(2));

        /**
         * UnaryOperator<T>
         */
        UnaryOperator<Integer> plus11 = (i -> i + 11);
        UnaryOperator<Integer> multiply3 = (i -> i * 3);

        System.out.println(plus11.apply(2));

    }
}
