package com.exercise.question;

import java.io.IOException;

public class Exercise4 {

    public static void main(String[] args) throws IOException {

        // Use

        // Print the value from intNumberMono when it emits
        ReactiveSources.intNumberMono().subscribe(
                number-> System.out.println(number)
        );

        // Get the value from the Mono into an integer variable
        Integer v = ReactiveSources.intNumberMono().block();
        System.out.println(v);
        System.out.println("Press a key to end");
        System.in.read();
    }

}
