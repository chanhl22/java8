package date_time_api;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.time.temporal.ChronoUnit;

public class PeriodAndDuration {
    public static void main(String[] args) {
        LocalDate today = LocalDate.now();
        LocalDate birthday = LocalDate.of(1995, Month.FEBRUARY, 8);

        Period period = Period.between(today, birthday);
        System.out.println(period);

        Period until = today.until(birthday);
        System.out.println(until.get(ChronoUnit.DAYS));

        Instant now = Instant.now();
        Instant plus = now.plus(10, ChronoUnit.SECONDS);
        Duration between = Duration.between(now, plus);
        System.out.println(between.getSeconds());
    }
}
