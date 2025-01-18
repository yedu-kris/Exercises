package com.exercise.question;

import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.exercise.question.log.logging;

public class Stream2 {
    public static void main(String[] args) {
//        logging(
        Stream.of(1,2,3,4,5,6,7,8,9,20,10,30,500,1000,2,4,5000,9000,45,56,78)
                .max(Integer::compare)
                .ifPresent(System.out::println);
//        );
        logging(
                "Thou find the way one always looking for in the most unexpected way"
                        .toLowerCase()
                        .chars()
                        .filter(c->!Character.isWhitespace(c))
                        .mapToObj(c->(char)c)
                        .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
        );
    }


}
