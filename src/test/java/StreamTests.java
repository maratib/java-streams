import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.*;

import org.junit.jupiter.api.Test;

public class StreamTests {

    @Test
    public void int_stream_test() {
        IntStream // source
                .range(1, 10) // intermediate operation
                .skip(5) // intermediate operation
                .forEach(System.out::println); // terminal operation
    }

    @Test
    public void sort_stream_test() {
        Stream // source
                .of("Waleed", "Musa", "Maratib") // intermediate operation
                .sorted() // intermediate operation
                .findFirst() // intermediate operation
                .ifPresent(System.out::println); // terminal operation
    }

    @Test
    public void sort_stream_test1() {

        Stream // source
                .of("Waleed", "Musa", "Maratib") // intermediate operation
                .filter(x -> x.startsWith("M"))
                .sorted() // intermediate operation
                .forEach(System.out::println); // terminal operation

    }

    @Test
    public void multi_operations_stream_test1() {

        List<String> people = Arrays.asList("Al", "Ankit", "Brent", "Sarika", "amanda", "Hans", "Shiva");

        people.stream()
                .map(String::toLowerCase) // convert all to lower case
                .filter(x -> x.startsWith("a")) // filter all starting with 'a'
                .forEach(System.out::println); // print filtered.

    }

    @Test
    public void file_lines_stream_test1() throws IOException {

        // data.txt
        // A,1,3.7
        // B,2,2.8
        // C,3,1.9
        // D,4,2.7
        // E
        // F,6,3.4

        Stream<String> rows = Files.lines(Paths.get("./assets/data.txt"));
        int rowCount = (int) rows
                .map(x -> x.split(","))
                .filter(x -> x.length == 3)
                .count();
        System.out.println("Rows Count: " + rowCount);

        rows.close();

    }

    @Test
    public void collect_stream_test1() throws IOException {

        Stream<String> rows = Files.lines(Paths.get("./assets/data.txt"));
        Map<String, Integer> map = new HashMap<>();
        map = rows
                .map(x -> x.split(","))
                .filter(x -> x.length == 3)
                .collect(Collectors.toMap(
                        x -> x[0],
                        x -> Integer.parseInt(x[1])

                ));
        rows.close();
        for (String key : map.keySet()) {
            System.out.println(key + "-" + map.get(key));
        }

    }

}
