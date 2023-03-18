package midnightrocket.java.singlethread;

import java.util.Arrays;

public class Prime {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(generateArray(10000)));
    }

    public static boolean isPrime(long n) {
        if (n == 2) return true;
        if (n % 2 == 0 || n == 1) return false;
        for (long i = 3; i < (long) Math.sqrt(n) + 1; i += 2) {
            if (n % i == 0) return false;
        }
        return true;
    }

    public static long[] generateArray(int size, long start) {
        long[] out = new long[size];
        int index = 0;
        long number = start;
        while (index < out.length) {
            if (isPrime(number)) {
                out[index] = number;
                index++;
            }
            number++;
        }
        return out;
    }

    public static long[] generateArray(int size) {
        return generateArray(size, 2);
    }
}