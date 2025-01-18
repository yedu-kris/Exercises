package com.exercise.question;

import lombok.val;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.exercise.question.log.logging;

public class StreamQuestions1 {
    public static void main(String[] args) {
        List<Integer> randomNumbers = Arrays.asList(9,-1,1,1,2,4,5,2,3,4,5,6,7,8,9,10);


        Set<Integer> evenNumbers = randomNumbers.stream().filter(number -> number % 2 == 0).collect(Collectors.toSet());
        logging("Even numbers");
        logging(evenNumbers);

        logging(" --- ");

        logging(randomNumbers.stream().collect(Collectors.partitioningBy(number->number%2==0)));

        logging(randomNumbers.stream().map(i->i+" ").filter(i->i.startsWith("1")).collect(Collectors.toSet()));

        Set<Integer> dis = new HashSet<>();

        logging(dis);
        logging(randomNumbers.stream().filter(number->!dis.add(number)).collect(Collectors.toList()));
        logging("-----");
        randomNumbers.stream().findFirst().ifPresent(System.out::println);
        logging(randomNumbers.stream().count());

        logging("Maximum");

        randomNumbers.stream().max(Integer::compareTo).ifPresent(System.out::println);
        randomNumbers.stream().min(Integer::compareTo).ifPresent(System.out::println);

        String s= "I am Who you think me who you I am";
       val val= Arrays.stream(s.split(" ")).toList();
       logging(val);
        List<Character> charString;
        Set<Character> set=new HashSet<>();
//        logging(charString=val.stream().flatMap(m->m.chars().mapToObj(c->Character.toLowerCase(Character.valueOf((char)c))).toList());
//       logging(charString.stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting())));
       val value=val.stream().flatMap(e->e.chars().mapToObj(i->(char)i)).map(Character::toLowerCase).collect(Collectors.groupingBy(Function.identity(),LinkedHashMap::new,Collectors.counting()));

       logging(value);

       //value.entrySet().stream().filter(i->i.getValue()==1).findFirst().ifPresent(System.out::println);
        value.entrySet().stream().filter(i->i.getValue()>1).findFirst().ifPresent(System.out::println);
        logging(randomNumbers.stream().sorted(Collections.reverseOrder()).toList());

        List<String> stringList= Arrays.asList("a","b");
        List<Integer> integerList=Arrays.asList(1,2,3);
        logging(Stream.concat(stringList.stream(),integerList.stream()).toList());
        List<Notes> notes=new ArrayList<>();
        for(int i=0;i<5;i++){
            notes.add(new Notes("Note"+i,i));
        }
        notes.add(new Notes("Note"+4,4));

        LinkedHashMap<String, Integer> map = notes.stream().sorted(Comparator
                        .comparing(Notes::getId).reversed())
                .collect(Collectors.toMap(
                        Notes::getName, Notes::getId, (a, b) -> a, LinkedHashMap::new
                ));

        logging(map);

        List<String> words = Arrays.asList("MY","Name","is","khan","Sharuk khan");

        logging(words.stream().collect(Collectors.toMap(
                String::length,
                word->word,
                (a,b)->a+" , "+b
        )));

        logging(" ");

        logging(
                words.stream().collect(Collectors.groupingBy(String::length,Collectors.toList()))
        );
        logging(
                Stream.of("A","B","A","AA","BB","AA","CC","DD","B")
                        .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
                        .entrySet()
                        .stream()
                        .filter(element->element.getValue()>1)
                        .collect(Collectors.toMap(Map.Entry::getKey,Map.Entry::getValue))
        );
    }
}
