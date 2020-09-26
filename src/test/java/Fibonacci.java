import java.math.BigInteger;

public class Fibonacci {

    public static BigInteger fib(long n) {
        if (n == 0)
            return BigInteger.ZERO;
        long num = Math.abs(n);
        if (num <= 2)
            return BigInteger.ONE;


        BigInteger[][] number = {{BigInteger.ONE, BigInteger.ONE}, {BigInteger.ONE, BigInteger.ZERO}};
        BigInteger[][] result = {{BigInteger.ONE, BigInteger.ONE}, {BigInteger.ONE, BigInteger.ZERO}};

        while (num > 0) {
            if (num % 2 == 1)
                result = multiplyMatrix(result, number);
            number = multiplyMatrix(number, number);
            num /= 2;
        }

        return result[1][1].multiply(BigInteger.valueOf(((n < 0) ? -1 : 1)));
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
