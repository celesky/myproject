package com.java8.lambada;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test2 {

    public static void main(String[] args) {
        Stream.iterate(new int[]{0, 1}, x->new int[]{x[1],x[0]+x[1]}).limit(20)
                .collect(Collectors.toList());
                //.forEach(t -> System.out.println("(" + t[0] + "," + t[1] +")"));
        Optional<List> optCar = Optional.empty();

    }


}
