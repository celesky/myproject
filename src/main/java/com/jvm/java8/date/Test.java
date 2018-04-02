package com.jvm.java8.date;

import java.time.*;

public class Test {

    public static void main(String[] args) {
//        LocalDate today = LocalDate.now();
//        LocalDateTime ldt = LocalDateTime.ofInstant();
    }

    public static void duration(){
//        LocalDate date1 = dt1.toLocalDate();
//        LocalTime time1 = dt1.toLocalTime();
        Instant instant1 = Instant.ofEpochSecond(3);
        Instant instant2 = Instant.ofEpochSecond(3, 0);

//        Duration d1 = Duration.between(time1, time2);
//        Duration d2 = Duration.between(dateTime1, dateTime2);
        Duration d3 = Duration.between(instant1, instant2);
    }
}
