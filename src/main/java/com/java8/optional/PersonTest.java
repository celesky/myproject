package com.java8.optional;

import java.util.Optional;

public class PersonTest {

    public static void main(String[] args) {
        System.out.println("args = " + PersonTest.getCarInsuranceName(Optional.empty()));
    }

    public static String getCarInsuranceName(Optional<Person> optPerson) {
        return optPerson.flatMap(Person::getCar)
                .flatMap(Person.Car::getInsurance)
                .map(Person.Insurance::getName)
                .orElse("Unknown");
    }
}
