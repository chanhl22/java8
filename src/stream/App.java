package stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class App {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        names.add("chanhee");
        names.add("keesun");
        names.add("whiteship");
        names.add("toby");

        /**
         * Funtional in nature
         */
        names.stream().map(s -> s.toUpperCase());
        Stream<String> stringStream = names.stream().map(String::toUpperCase);

        names.forEach(System.out::println);

        /**
         * 중개 오퍼레이션 -> 근본적으로 lazy
         */
        List<String> collect = names.stream().map(s -> {
            System.out.println(s);
            return s.toUpperCase();
        }).collect(Collectors.toList());

        System.out.println("=====");

        collect.forEach(System.out::println);

        System.out.println("=====");

        names.forEach(System.out::println);

        System.out.println("=====");

        /**
         * 병렬 처리
         */
        for (String name : names) {
            System.out.println(name.toUpperCase());
        }

        System.out.println("=====");

        List<String> collect1 = names.parallelStream().map(String::toUpperCase)
                .collect(Collectors.toList());
        collect1.forEach(System.out::println);

        System.out.println("=====");

        /**
         * parallelStream 과 stream
         */
        List<String> collect2 = names.parallelStream().map(s -> {
            System.out.println(s + " " + Thread.currentThread().getName());
            return s.toUpperCase();
        }).collect(Collectors.toList());
        collect2.forEach(System.out::println);

        List<String> collect3 = names.stream().map(s -> {
            System.out.println(s + " " + Thread.currentThread().getName());
            return s.toUpperCase();
        }).collect(Collectors.toList());
        collect3.forEach(System.out::println);
    }
}
