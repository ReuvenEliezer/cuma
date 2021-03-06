import java.math.BigInteger;

public class Fibonacci {
    /**
     * Calculate fib(n) where:
     * Calculate fib(n) where:
     * <p>
     * fib(0) = 0
     * fib(1) = 1
     * fin(n + 2) = fib(n + 1) + fib(n)
     * <p>
     * Write an algorithm that can handle n up to 2000000.
     * <p>
     * Your algorithm must output the exact integer answer, to full precision. Also, it MUST correctly handle negative numbers as input.
     * The score for this question will be highly correlated with the algorithm's speed.
     * <p>
     * see attached files: Fibonacci.java, FibonacciTest.java
     */

    public static BigInteger fib(BigInteger value) {
        if (value.equals(BigInteger.ZERO))
            return BigInteger.ZERO;

        long valueAsLong = value.longValue();
        if (Math.abs(valueAsLong) == 1)
            return BigInteger.ONE;

        BigInteger[][] number = {{BigInteger.ONE, BigInteger.ONE}, {BigInteger.ONE, BigInteger.ZERO}};
        BigInteger[][] result = {{BigInteger.ONE, BigInteger.ONE}, {BigInteger.ONE, BigInteger.ZERO}};

        long originalInput = valueAsLong;
        while (valueAsLong != 0) {
            if (valueAsLong % 2 == 1 || valueAsLong % 2 == -1)
                result = multiplyMatrix(result, number);
            number = multiplyMatrix(number, number);
            valueAsLong /= 2;
        }

        return result[1][1].multiply(BigInteger.valueOf(originalInput < 0 && originalInput % 2 == 0 ? -1 : 1));
    }

    public static BigInteger[][] multiplyMatrix(BigInteger[][] mat1, BigInteger[][] mat2) {
        return new BigInteger[][]{
                {mat1[0][0].multiply(mat2[0][0]).add(mat1[0][1].multiply(mat2[1][0])),
                        mat1[0][0].multiply(mat2[0][1]).add(mat1[0][1].multiply(mat2[1][1]))
                },
                {mat1[1][0].multiply(mat2[0][0]).add(mat1[1][1].multiply(mat2[1][0])),
                        mat1[1][0].multiply(mat2[0][1]).add(mat1[1][1].multiply(mat2[1][1]))
                }
        };
    }

}
