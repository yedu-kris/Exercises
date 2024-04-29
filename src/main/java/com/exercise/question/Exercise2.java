package com.exercise.question;

import reactor.core.publisher.Mono;

import java.io.IOException;

public class Exercise2 {

    public static void main(String[] args) throws IOException {

        // Use ReactiveSources.intNumbersFlux() and ReactiveSources.userFlux()

        // Print all numbers in the ReactiveSources.intNumbersFlux stream

        ReactiveSources.intNumbersFlux()
                .subscribe(number-> System.out.println(number));
        // Print all users in the ReactiveSources.userFlux stream
        ReactiveSources.userFlux().subscribe(System.out::println);


        System.out.println("Press a key to end");
        System.in.read();
    }

}
