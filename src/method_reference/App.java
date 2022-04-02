package method_reference;

import java.util.Arrays;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class App {
    public static void main(String[] args) {

        /**
         * 스태틱 메소드 참조
         */
        UnaryOperator<String> hi_v1 = s -> "hi" + s;
        UnaryOperator<String> hi_v2 = Greeting::hi;

        /**
         * 특정 객체의 인스턴스 메소드 참조
         */
        Greeting greeting = new Greeting();
        UnaryOperator<String> hello_v1 = s -> "hello" + s;
        UnaryOperator<String> hello_v2 = greeting::hello;

        /**
         * 생성자 참조
         */
        Supplier<Greeting> newGreeting_v1 = Greeting::new;
        Greeting makeGreeting = newGreeting_v1.get();

        Function<String, Greeting> newGreeting_v2 = Greeting::new;
        Greeting chan = newGreeting_v2.apply("chan");
        System.out.println(chan.getName());

        /**
         * 임의 객체의 인스턴스 메소드 참조
         */
        String[] names = {"whiteship", "keesun", "chan"};
        Arrays.sort(names, String::compareToIgnoreCase);
        System.out.println(Arrays.toString(names));

    }
}
