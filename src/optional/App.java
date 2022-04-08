package optional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class App {
    public static void main(String[] args) {
        List<stream_api.OnlineClass> springClasses = new ArrayList<>();
        springClasses.add(new stream_api.OnlineClass(1, "spring boot", true));
        springClasses.add(new stream_api.OnlineClass(2, "spring data jpa", true));
        springClasses.add(new stream_api.OnlineClass(3, "spring mvc", false));
        springClasses.add(new stream_api.OnlineClass(4, "spring core", false));
        springClasses.add(new stream_api.OnlineClass(5, "rest api development", false));

        OnlineClass spring_boot = new OnlineClass(1, "spring boot", true);
        Optional<Progress> progress = spring_boot.getProgress();
        progress.ifPresent(p -> System.out.println(p.getStudyDuration()));
    }
}
