package com.reactor;

import reactor.core.publisher.Flux;

import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Random;

/**
 * @desc:
 * @author: panqiong
 * @date: 2019-11-14
 */
public class Demo {
    public static void main(String[] args) {
//        Flux.just("Hello", "World").subscribe(System.out::println);
//        Flux.fromArray(new Integer[] {1, 2, 3}).subscribe(System.out::println);
//        Flux.empty().subscribe(System.out::println);
//        Flux.range(1, 1000).subscribe(System.out::println);
//        Flux.interval(Duration.of(10, ChronoUnit.SECONDS)).subscribe(System.out::println);
//        //Flux.intervalMillis(1000).subscribe(System.out::println);


//        Flux.generate(sink -> {
//            sink.next("Hello");
//            sink.complete();
//        }).subscribe(System.out::println);
//
//
//        final Random random = new Random();
//        Flux.generate(ArrayList::new, (list, sink) -> {
//            int value = random.nextInt(100);
//            list.add(value);
//            sink.next(value);
//            if (list.size() == 10) {
//                sink.complete();
//            }
//            return list;
//        }).subscribe(System.out::println);


        Flux.just("a", "b")
                .zipWith(Flux.just("c", "d"))
                .subscribe(System.out::println);

        Flux.just("a", "b")
                .zipWith(Flux.just("c", "d"), (s1, s2) -> String.format("%s-%s", s1, s2))
                .subscribe(System.out::println);
    }


}
