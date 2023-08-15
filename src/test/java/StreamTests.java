import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;

public class StreamTests {

    @Test
    public void int_stream_test() {
        IntStream
                .range(1, 10)
                .forEach(System.out::println);
    }

}
