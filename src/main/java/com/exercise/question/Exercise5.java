package com.exercise.question;

import reactor.core.publisher.BaseSubscriber;

import java.io.IOException;
import java.util.function.Consumer;

public class Exercise5 {

    public static void main(String[] args) throws IOException {

        // Use ReactiveSources.intNumberMono() and ReactiveSources.userMono()

        // Subscribe to a flux using the error and completion hooks
        ReactiveSources.intNumberMono().subscribe(
                value-> System.out.println(value),
                error-> System.err.println(error),
                ()-> System.out.println("Flux Completed")
        );

        ReactiveSources.userMono().subscribe(
                value-> System.out.println(value),
                error-> System.err.println(error),
                ()-> System.out.println("Flux Completed")
        );

        // Subscribe to a flux using an implementation of BaseSubscriber

        ReactiveSources.userMono().subscribe(new CustomSubscriber<>());



        System.out.println("Press a key to end");
        System.in.read();
    }
    static class CustomSubscriber<T> extends BaseSubscriber<T> {
        @Override
        protected void hookOnNext(T value) {
            System.out.println("Received value: " + value);
        }

        @Override
        protected void hookOnError(Throwable throwable) {
            System.err.println("Error occurred: " + throwable.getMessage());
        }

        @Override
        protected void hookOnComplete() {
            System.out.println("Flux completed");
        }
    }

}