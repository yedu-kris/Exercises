package com.exercise.question;

import reactor.core.publisher.Flux;

import java.util.stream.Stream;

public class Exercise1 {

    public static void main(String[] args) {

        Stream<Integer> numberStreams = StreamSources.intNumbersStream();

        // Use StreamSources.intNumbersStream() and StreamSources.userStream()

        // Print all numbers in the intNumbersStream stream
        // TODO: Write code here
        // numberStreams.forEach(System.out::println);

        // Print numbers from intNumbersStream that are less than 5
        // TODO: Write code here
        //  numberStreams.filter(number -> number < 5).forEach(System.out::println);

        // Print the second and third numbers in intNumbersStream that's greater than 5
        // TODO: Write code here

//        Flux<Integer> streamInt = Flux.fromStream(numberStreams);
//        int[] c = {0};
//        streamInt.filter(i -> i > 5).
//                subscribe(number -> {
//                    c[0]++;
//                    if (c[0] == 1 || c[0] == 2) {
//                        System.out.println(number);
//                    }
//                });

        //  Print the first number in intNumbersStream that's greater than 5.
        //  If nothing is found, print -1
        // TODO: Write code here


        Flux<Integer> streamInt = Flux.fromStream(numberStreams);
        int[] c = {0};
        streamInt.filter(i -> i > 5).
                take(1).
                defaultIfEmpty(-1).
                subscribe(System.out::println);
        // Print first names of all users in userStream
        // TODO: Write code here

        // Print first names in userStream for users that have IDs from number stream
        // TODO: Write code here

    }

}
