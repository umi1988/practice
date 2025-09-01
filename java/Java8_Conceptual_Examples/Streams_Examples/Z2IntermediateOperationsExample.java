package Java8_Conceptual_Examples.Streams_Examples;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * filter(name -> name.startsWith("A")): Keeps only "Alice" and "Alice".
 * map(String::toUpperCase): Converts "Alice" to "ALICE".
 * distinct(): Removes duplicate "ALICE".
 * sorted(): Not needed here since there’s only one element, but included for demonstration.
 * collect(Collectors.toList()): Terminal operation to collect results into a List.
 *
 */
public class Z2IntermediateOperationsExample
{
    public static void main(String[] args) {
            List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "David", "Alice");

        // Filter names starting with 'A' and convert to uppercase
        List<String> result = names.stream()
                .filter(name -> name.startsWith("A"))// Keep names starting with 'A'
                .map(String::toUpperCase) // Convert to uppercase
                .distinct() // Remove duplicates
                .sorted() // Sort alphabetically
                .collect(Collectors.toList()); // Collect to a List

        System.out.println(result); // Output: [ALICE]

        //Another example

        List<Integer> lst  = Arrays.asList(3000,5000,1000,10000,7000);
      Optional<Integer> second =  lst.stream().sorted(Comparator.reverseOrder())
               .distinct().skip(1).findFirst();

        System.out.println(second);

    }
}
