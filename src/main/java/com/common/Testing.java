package com.common;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Testing {
    public static void tempCode() {
        List<Integer> number = Arrays.asList(2, 3, 4, 5);
        List square = number.stream().map(x -> x * x).collect(Collectors.toList());
        System.out.println(square);

        List<String> names = Arrays.asList("Reflection", "Collection", "Stream");
        List result = names.stream().filter(s -> s.startsWith("S")).collect(Collectors.toList());
        System.out.println(result);

        List result1 = names.stream().sorted().collect(Collectors.toList());
        System.out.println(result1);

        String input = "Hello Wold!";
        String[] input1 = input.split(" ");
        List<String> resuList = Arrays.asList(input1);
        List<String> result2 = resuList.stream().map(s -> new StringBuilder(s).reverse().toString())
                .collect(Collectors.toList());
        System.out.println(result2);
    }

    public static void main(String[] args) {
        String inpString = "Hello World";
        List<String> input = Arrays.asList(inpString.split(" "));
        List<String> result = input.stream().map(s -> new StringBuilder(s).reverse().toString())
                .collect(Collectors.toList());
        System.out.println(String.join(" ", result));

    }

}
