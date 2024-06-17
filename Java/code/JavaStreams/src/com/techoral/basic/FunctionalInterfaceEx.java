package com.techoral.basic;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class FunctionalInterfaceEx {
    public static void main(String[] args) {
        // Supplier to provide a list of names
        Supplier<List<String>> nameSupplier = () -> Arrays.asList("Avi", "Nash", "techoral", "bob");
        
        // Predicate to check if a name starts with 'A'
        Predicate<String> startsWithA = (s) -> s.startsWith("A");
        
        // Consumer to print names
        Consumer<String> printName = (s) -> System.out.println(s);
        
        // Get the list of names
        List<String> names = nameSupplier.get();
        
        // Filter names that start with 'A' and print them
        List<String> namesStartingWithA = names.stream()
                                               .filter(startsWithA)
                                               .collect(Collectors.toList());
        
        namesStartingWithA.forEach(printName);  // Output: Alice
    }
}

