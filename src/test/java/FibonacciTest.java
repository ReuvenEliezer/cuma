import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;

public class FibonacciTest {

    @Test
    public void testFib0() {
        testFib(0, 0);
    }

    @Test
    public void testFib1() {
        testFib(1, 1);
    }

    @Test
    public void testFib2() {
        testFib(1, 2);
    }

    @Test
    public void testFib3() {
        testFib(2, 3);
    }

    @Test
    public void testFib4() {
        testFib(3, 4);
    }

    @Test
    public void testFib5() {
        testFib(5, 5);
    }

    @Test
    public void testFib2000000() throws IOException {
        String expectedPath = "src" + File.separator + "test" + File.separator + "resources" + File.separator + "fibonacci_result_2000000.txt";
        String expectedValue = FileUtils.readFileToString(new File(expectedPath), StandardCharsets.UTF_8);
        testFib(expectedValue, 2000000);
    }

    private static void testFib(long expected, long input) {
        testFib(String.valueOf(expected), input);
    }

    private static void testFib(String expected, long input) {
        BigInteger found = null;
        try {
            found = Fibonacci.fib(input);
        } catch (Throwable e) {
            Assert.fail("exception during test: " + e);
        }
        if (found == null)
            Assert.fail();
        Assert.assertEquals(expected, found.toString());
    }


}
