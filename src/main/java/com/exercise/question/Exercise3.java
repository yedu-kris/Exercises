package com.exercise.question;

import reactor.core.publisher.Mono;

import java.io.IOException;
import java.util.List;

public class Exercise3 {

    public static void main(String[] args) throws IOException {
        // Get all numbers in the ReactiveSources.intNumbersFlux stream
        // into a List and print the list and its size
        Mono<List<Integer>> mono = ReactiveSources.intNumbersFlux().collectList();
        mono.subscribe(list->{
            System.out.println(list+" "+list.size());
        });
        System.out.println("Press a key to end");
        System.in.read();
    }

}
