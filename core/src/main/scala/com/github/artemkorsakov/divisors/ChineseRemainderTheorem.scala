package com.github.artemkorsakov.divisors

class ChineseRemainderTheorem {}

/*

/**
 * Chinese remainder theorem.
 *
 * @see <a href="https://en.wikipedia.org/wiki/Chinese_remainder_theorem">Chinese remainder theorem</a>
 */
public class ChineseRemainderTheorem {
    /**
 * Return n, such than n % a[i] == r [i]
 */
    public static long getSolution(long[] aArray, long[] rArray) {
        // Step 1
        long m = Arrays.stream(aArray).reduce((v1, v2) -> v1 * v2).orElse(1);

        // Step 2
        long[] mArray = new long[aArray.length];
        for (int i = 0; i < mArray.length; i++) {
            mArray[i] = m / aArray[i];
        }

        // Step 3
        long[] mMinus1Array = new long[aArray.length];
        for (int i = 0; i < mArray.length; i++) {
            mMinus1Array[i] = Divisors.gcdInverse(mArray[i], aArray[i]);
        }

        // Step 4
        long x = 0;
        for (int i = 0; i < mArray.length; i++) {
            x += rArray[i] * mArray[i] * mMinus1Array[i] % m;
        }

        return x;
    }

    /**
 * Return n, such than n % a[i] == r [i]
 */
    public static BigInteger getSolution(BigInteger[] aArray, BigInteger[] rArray) {
        // Step 1
        BigInteger m = Arrays.stream(aArray).reduce(BigInteger::multiply).orElse(BigInteger.ONE);

        // Step 2
        BigInteger[] mArray = new BigInteger[aArray.length];
        for (int i = 0; i < mArray.length; i++) {
            mArray[i] = m.divide(aArray[i]);
        }

        // Step 3
        BigInteger[] mMinus1Array = new BigInteger[aArray.length];
        for (int i = 0; i < mArray.length; i++) {
            mMinus1Array[i] = BigInteger.valueOf(Divisors.gcdInverse(mArray[i].longValueExact(), aArray[i].longValueExact()));
        }

        // Step 4
        BigInteger x = BigInteger.ZERO;
        for (int i = 0; i < mArray.length; i++) {
            x = x.add(rArray[i].multiply(mArray[i]).mod(m).multiply(mMinus1Array[i]).mod(m));
        }

        return x;
    }
}

 */
