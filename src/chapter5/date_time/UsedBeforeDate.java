package chapter5.date_time;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class UsedBeforeDate {
    public static void main(String[] args) throws InterruptedException {
        Date date = new Date();
        long time = date.getTime();
        System.out.println(date);
        System.out.println(time);
        Calendar calendar = new GregorianCalendar();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat();

        Thread.sleep(1000 * 3);
        Date after3Seconds = new Date();
        System.out.println(after3Seconds);
        after3Seconds.setTime(time);
        System.out.println(after3Seconds);

        Calendar birthday = new GregorianCalendar(1995, Calendar.FEBRUARY, 8);
    }
}
