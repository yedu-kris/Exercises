package com.exercise.question;

import reactor.core.publisher.Mono;

import java.io.IOException;
import java.io.PrintStream;
import java.util.List;

public class Exercise3 {

    public static void main(String[] args) throws IOException {

        ReactiveSources.intNumbersFlux().collectList()
        .subscribe(list-> {
            System.out.println(list);
            System.out.println(list.size());
        });

        // Get all numbers in the ReactiveSources.intNumbersFlux stream
        // into a List and print the list and its size
        // TODO: Write code here


        System.out.println("Press a key to end");
        System.in.read();
    }

}
