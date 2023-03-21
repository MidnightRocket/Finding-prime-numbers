package midnightrocket.java.singlethread;

import midnightrocket.java.interfaces.Generator;

import java.util.Arrays;

public class Prime {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(generateArray(10000)));
    }

    public static boolean isPrime(long n) {
        if (n == 2) return true;
        if (n % 2 == 0 || n == 1) return false; // This also catches 0, as not a prime.
        // Only try to divide with uneven numbers, because we have already checked, it the number is an even number
        for (long i = 3; i < (long) Math.sqrt(n) + 1; i += 2) {
            if (n % i == 0) return false;
        }
        return true;
    }

    public static Long[] generateArray(int size, long start) {
        return Generator.fillArray(new PrimeGenerator(start), new Long[size]);
    }

    public static Long[] generateArray(int size) {
        return generateArray(size, 2);
    }
}