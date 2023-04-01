package chapter5.date_time_api;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class ForMachines {
    public static void main(String[] args) {
        Instant instant = Instant.now();
        System.out.println(instant); //기준시 UTC, GMT

        ZoneId zone = ZoneId.systemDefault();
        System.out.println(zone);
        ZonedDateTime zonedDateTime = instant.atZone(zone);
        System.out.println(zonedDateTime);
    }
}
