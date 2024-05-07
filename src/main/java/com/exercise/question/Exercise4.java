package com.exercise.question;

import java.io.IOException;

public class Exercise4 {

    public static void main(String[] args) throws IOException {

        ReactiveSources.intNumberMono().subscribe(
                number-> System.out.println(number)
        );

        Integer v = ReactiveSources.intNumberMono().block();
        System.out.println("Press a key to end");
        System.in.read();
    }

}
