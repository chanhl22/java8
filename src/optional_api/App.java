package optional_api;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class App {
    public static void main(String[] args) {
        List<OnlineClass> springClasses = new ArrayList<>();
        springClasses.add(new OnlineClass(1, "spring boot", true));
        springClasses.add(new OnlineClass(2, "spring data jpa", true));
        springClasses.add(new OnlineClass(3, "spring mvc", false));
        springClasses.add(new OnlineClass(4, "spring core", false));
        springClasses.add(new OnlineClass(5, "rest api development", false));

        /**
         * Optional에 값이 있는지 없는지 확인하기
         */
        Optional<OnlineClass> spring = springClasses.stream()
                .filter(oc -> oc.getTitle().startsWith("spring"))
                .findFirst();

        boolean present1 = spring.isPresent();
        System.out.println(present1);

        Optional<OnlineClass> jpa = springClasses.stream()
                .filter(oc -> oc.getTitle().startsWith("jpa"))
                .findFirst();

        boolean present2 = jpa.isPresent();
        System.out.println(present2);

        /**
         * Optional에 있는 값 가져오기
         * get
         */
        Optional<OnlineClass> optional1 = springClasses.stream()
                .filter(oc -> oc.getTitle().startsWith("spring"))
                .findFirst();

        OnlineClass onlineClass1 = optional1.get();
        System.out.println(onlineClass1.getTitle());

        Optional<OnlineClass> optional2 = springClasses.stream()
                .filter(oc -> oc.getTitle().startsWith("jpa"))
                .findFirst();

        if (optional2.isPresent()) {
            OnlineClass onlineClass2 = optional2.get();
            System.out.println(onlineClass2.getTitle());
        }

        /**
         * Optional에 값이 있는 경우에 그 값을 가지고 ~~를 하라.
         * ifPresent
         */
        Optional<OnlineClass> optional3 = springClasses.stream()
                .filter(oc -> oc.getTitle().startsWith("spring"))
                .findFirst();

        optional3.ifPresent(oc -> System.out.println(oc.getTitle()));

        /**
         * Optional에 값이 있으면 가져오고 없는 경우에 ~~를 리턴하라.
         * orElse
         */
        Optional<OnlineClass> optional4 = springClasses.stream()
                .filter(oc -> oc.getTitle().startsWith("jpa"))
                .findFirst();

        OnlineClass onlineClass2 = optional4.orElse(createNewClasses());
        System.out.println(onlineClass2.getTitle());

        Optional<OnlineClass> optional5 = springClasses.stream()
                .filter(oc -> oc.getTitle().startsWith("spring"))
                .findFirst();

        OnlineClass onlineClass3 = optional5.orElse(createNewClasses());
        System.out.println(onlineClass3.getTitle());

        /**
         * Optional에 값이 있으면 가져오고 없는 경우에 ~~를 하라.
         * orElseGet
         */
        Optional<OnlineClass> optional6 = springClasses.stream()
                .filter(oc -> oc.getTitle().startsWith("spring"))
                .findFirst();

        OnlineClass onlineClass4 = optional6.orElseGet(App::createNewClasses);
//        OnlineClass onlineClass4 = optional6.orElseGet(() -> createNewClasses());
        System.out.println(onlineClass4.getTitle());

        /**
         * Optional에 값이 있으면 가져오고 없는 경우 에러를 던져라.
         * orElseThrow
         */
        Optional<OnlineClass> optional7 = springClasses.stream()
                .filter(oc -> oc.getTitle().startsWith("jpa"))
                .findFirst();

//        OnlineClass onlineClass5 = optional7.orElseThrow(() -> {
//            return new IllegalArgumentException();
//        });
//
//        OnlineClass onlineClass6 = optional7.orElseThrow(IllegalStateException::new);
//
//        System.out.println(onlineClass5.getTitle());

        /**
         * Optional에 들어있는 값 걸러내기
         * filter
         */
        Optional<OnlineClass> optional8 = springClasses.stream()
                .filter(oc -> oc.getTitle().startsWith("spring"))
                .findFirst();

        Optional<OnlineClass> onlineClass7 = optional8.filter(oc -> oc.getId() > 10);
        System.out.println(onlineClass7.isEmpty());

        Optional<OnlineClass> onlineClass8 = optional8.filter(oc -> oc.getId() < 10);
        System.out.println(onlineClass8.isEmpty());

        /**
         * Optional에 들어있는 값 변환하기
         * map
         */
        Optional<OnlineClass> optional9 = springClasses.stream()
                .filter(oc -> oc.getTitle().startsWith("spring"))
                .findFirst();

        Optional<Integer> integer = optional9.map(OnlineClass::getId);
        System.out.println(integer.isPresent());

//        Optional<Optional<Progress>> progress = optional9.map(OnlineClass::getProgress);
//        Optional<Progress> progress1 = progress.orElseThrow();
//        progress1.orElseThrow();

        Optional<Progress> progress2 = optional9.flatMap(OnlineClass::getProgress);
        System.out.println(progress2.isPresent());
    }

    private static OnlineClass createNewClasses() {
        System.out.println("creating new online class");
        return new OnlineClass(10, "New class", false);
    }
}
