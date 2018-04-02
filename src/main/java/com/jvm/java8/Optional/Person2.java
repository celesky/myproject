package com.jvm.java8.Optional;

import java.util.Optional;

public class Person2 {

    private Car car;
    public Optional<Car> getCarAsOptional() {
        return Optional.ofNullable(car);
    }

    static class Car{
        String color;
        String seatNum;
    }
}
