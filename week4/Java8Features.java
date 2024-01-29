package week4;

import java.util.*;
import java.util.stream.Collectors;

public class Java8Features {


    public void threadImpl() {
        // Java 7-
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                // Code to run in the new thread
            }
        });
        thread2.start();


        // Java 8+
        Thread thread = new Thread(() -> {
            // Code to run in the new thread
        });
        thread.start();

    }

    public void listIteration(){
        // Java 7-
        List<String> names = Arrays.asList("John", "Alice", "Bob");
        for (String name : names) {
            System.out.println("Hello, " + name);
        }


        // Java 8+
        List<String> names2 = Arrays.asList("John", "Alice", "Bob");
        names2.forEach(name -> System.out.println("Hello, " + name));

    }

    public void filteringandCollectingtoList(){
        // Java 7-
        List<String> fruits = Arrays.asList("Apple", "Banana", "Orange", "Kiwi");
        List<String> result = new ArrayList<>();
        for (String fruit : fruits) {
            if (fruit.startsWith("A")) {
                result.add(fruit);
            }
        }


        // Java 8+
        List<String> fruits2 = Arrays.asList("Apple", "Banana", "Orange", "Kiwi");
        List<String> result2 = fruits2.stream()
                .filter(fruit -> fruit.startsWith("A"))
                .toList();

    }

    public void mappingAndSumming(){
        // Java 7-
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        int sum = 0;
        for (Integer number : numbers) {
            sum += number;
        }


        // Java 8+
        int sumJava8 = numbers.stream()
                .mapToInt(Integer::intValue)
                .sum();
    }

    public void grouping(){
        // Java 7-
        List<String> words = Arrays.asList("Java", "Python", "C", "JavaScript");
        Map<Integer, List<String>> groupedByLength = new HashMap<>();
        for (String word : words) {
            int length = word.length();
            if (!groupedByLength.containsKey(length)) {
                groupedByLength.put(length, new ArrayList<>());
            }
            groupedByLength.get(length).add(word);
        }


        // Java 8+
        Map<Integer, List<String>> groupedByLengthJava8 = words.stream()
                .collect(Collectors.groupingBy(String::length));

    }

    public static void handlingNullValues(){
        // Java 7-
        String result;
        String name = getName();
        if (name != null) {
            result = name;
        } else {
            result = "DefaultName";
        }
        System.out.println(result);


        // Java 8+
        String resultJava8 = getNameOptional().orElse("DefaultName");
        System.out.println(resultJava8);

    }

    public static String getName() {
        // Logic to fetch name; may return null
        return null;
    }

    public static Optional<String> getNameOptional() {
        // Logic to fetch name; may return null
        return Optional.empty();
    }


    public static void main(String[] args) {
        handlingNullValues();
    }

}