package com.github.artemkorsakov.numbers

class Palindrome {

}

/*
package com.github.artemkorsakov.numbers;

import java.math.BigInteger;

/**
 * <a href="https://en.wikipedia.org/wiki/Palindrome">Palindrome</a>
 */
public class Palindrome {
    public static boolean isPalindrome(long n) {
        return isPalindrome(n, 10);
    }

    public static boolean isPalindrome(BigInteger n) {
        return n.compareTo(getReversed(n)) == 0;
    }

    public static boolean isPalindrome(long n, int base) {
        return n == getReversed(n, base);
    }

    public static long getReversed(long n) {
        return getReversed(n, 10);
    }

    public static long getReversed(long n, int base) {
        long reversed = 0;
        long k = n;
        while (k > 0) {
            reversed = base * reversed + k % base;
            k /= base;
        }

        return reversed;
    }

    public static BigInteger getReversed(BigInteger n) {
        BigInteger reversed = BigInteger.ZERO;
        BigInteger k = n;
        while (k.compareTo(BigInteger.ZERO) > 0) {
            reversed = reversed.multiply(BigInteger.TEN).add(k.mod(BigInteger.TEN));
            k = k.divide(BigInteger.TEN);
        }

        return reversed;
    }
}

 */