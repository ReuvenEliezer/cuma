import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.File;
import java.io.IOException;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.util.stream.Stream;

public class FibonacciTest {

    @ParameterizedTest()
    @MethodSource({"fibArgumentsProvider"})
    public void testFib(Object expected, long input) {
        if (expected == null)
            Assertions.fail("expected value is null");

        BigInteger result = null;
        try {
            result = Fibonacci.fib(new BigInteger(String.valueOf(input)));
        } catch (Throwable e) {
            Assertions.fail("exception during test: " + e);
        }
        if (result == null)
            Assertions.fail("fib calculation result is null");
        Assertions.assertEquals(expected.toString(), result.toString());
    }

    private static Stream<Arguments> fibArgumentsProvider() {
        return Stream.of(
                Arguments.of(-1, -1),
                Arguments.of(-1, -2),
                Arguments.of(-2, -3),
                Arguments.of(-3, -4),
                Arguments.of(-5, -5),

                Arguments.of(0, 0),
                Arguments.of(1, 1),
                Arguments.of(1, 2),
                Arguments.of(2, 3),
                Arguments.of(3, 4),
                Arguments.of(5, 5),
                Arguments.of("7896325826131730509282738943634332893686268675876375", 250),
                Arguments.of(readTooLongStr("fibonacci_result_2000000.txt"), 2000000)
        );
    }

    private static String readTooLongStr(String filePath) {
        String expectedPath = "src" + File.separator + "test" + File.separator + "resources" + File.separator + filePath;
        String expectedValue = null;
        try {
            expectedValue = FileUtils.readFileToString(new File(expectedPath), StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return expectedValue;
    }

}
