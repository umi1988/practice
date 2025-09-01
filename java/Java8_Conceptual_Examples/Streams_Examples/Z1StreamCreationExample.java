package Java8_Conceptual_Examples.Streams_Examples;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * stream() creates a sequential stream from a collection.
 * Arrays.stream() converts an array to a stream.
 * Stream.of() creates a stream from explicit values.
 * Stream.iterate() generates an infinite stream with a seed and function (limited to 5 elements here).
 * Stream.generate() produces an infinite stream based on a supplier (limited to 3 elements here).
 *
 */
public class Z1StreamCreationExample
{
    public static void main(String[] args) {
        // From a List
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie");
        Stream<String> nameStream = names.stream();

        // From an Array
        Integer[] numbers = {1, 2, 3, 4, 5};
        Stream<Integer> numberStreams = Arrays.stream(numbers);

        // Using Stream.of
        Stream<String> streamOf = Stream.of("One", "Two", "Three");

        // Using Stream.iterate
        Stream.iterate(0,n->n+2).limit(5); // 0, 2, 4, 6, 8

        // Using Stream.generate
        Stream<Double> randomStream = Stream.generate(Math::random).limit(3); // 3 random numbers
    }
}
