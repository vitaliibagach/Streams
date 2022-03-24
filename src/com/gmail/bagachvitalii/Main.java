package com.gmail.bagachvitalii;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) throws IOException {

        final Set<Integer> simpleSet = getRandomList(3000);
        System.out.println(simpleSet);

      /*  List<String> result1 = simpleSet
                .parallelStream()
                .filter(x -> x > 50)
                .filter(x-> !(x%2 ==0))
                .sorted((x1,x2) -> x2.compareTo(x1))
                .map(x -> "myMapValue=" + x)
                .map(s -> s.toUpperCase(Locale.ROOT))

                .collect(Collectors.toList());

        System.out.println(result1);

       */

// test
        long result2 = simpleSet
                .parallelStream()
                .filter(x -> x > 50 && x < 100)
                .mapToInt(Integer::intValue)
                .count();
        System.out.println(result2);

        Path path = Paths.get("TextFile.txt");
        Stream<String> lineStream = Files.lines(path);

        lineStream
                //  .parallel()
                .map(s -> s.toUpperCase(Locale.ROOT))
                .map(s-> new StringBuilder(s).reverse())
                .forEach(System.out::println);

    }


    public static Set<Integer> getRandomList(int quantity) {
        final Random random = new Random();
        final Set<Integer> result = new HashSet<>(quantity);
        for (int i = 0; i < quantity; i++) {
            // result.add(i, random.nextInt(100));
            result.add(random.nextInt(1000));
        }

        return result;
    }
}
