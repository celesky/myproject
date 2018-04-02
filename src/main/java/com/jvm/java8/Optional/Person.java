package com.jvm.java8.Optional;

import java.util.Optional;

public class Person {
    private Optional<Car> car;


    public Optional<Car> getCar() {
        return car;
    }

    public void setCar(Optional<Car> car) {
        this.car = car;
    }

    static class Car{
        String color;
        String seatNum;
        Optional<Insurance> insurance;

        public Optional<Insurance> getInsurance() {
            return insurance;
        }

        public void setInsurance(Optional<Insurance> insurance) {
            this.insurance = insurance;
        }
    }

    static class Insurance{
        String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
