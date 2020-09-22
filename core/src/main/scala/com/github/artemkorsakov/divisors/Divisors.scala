package com.github.artemkorsakov.divisors

class Divisors {}

object Divisors {
  def gcd(aArray: Array[Long]): Long =
    if (aArray.length <= 1) {
      aArray.headOption.getOrElse(1)
    } else {
      gcd(aArray.head, gcd(aArray.tail))
    }

  /** Return the greatest common factor.
    */
  def gcd(u: Long, v: Long): Long =
    if (u == v) {
      u
    } else if (u == 0) {
      v
    } else if (v == 0) {
      u
    } else {
      (~u & 1, ~v & 1) match {
        case (1, 1) => gcd(u >> 1, v >> 1) << 1
        case (1, 0) => gcd(u >> 1, v)
        case (0, 1) => gcd(u, v >> 1)
        case (_, _) => if (u > v) gcd(u - v, v) else gcd(v - u, u)
      }
    }

}
/*
    private static final Map<Long, BigInteger> SUM_OF_DIVISORS_BI_MAP = new HashMap<>();
    private static final Map<Long, Integer> COUNT_OF_DIVISORS = new HashMap<>();


    /**
 * Modular multiplicative inverse.
 *
 * @see <a href="https://en.wikipedia.org/wiki/Modular_multiplicative_inverse">detailed description</a>
 */
    public static long gcdInverse(long a, long m) {
        ExtraEuclid extraEuclid = gcdex(a, m);
        extraEuclid.x = (extraEuclid.x % m + m) % m;
        return extraEuclid.d == 1 ? extraEuclid.x : -1;
    }

    /**
 * Extended Euclidean algorithm.
 *
 * @see <a href="https://en.wikipedia.org/wiki/Extended_Euclidean_algorithm">detailed description</a>
 */
    public static ExtraEuclid gcdex(long a, long b) {
        ExtraEuclid extraEuclid = new ExtraEuclid();
        if (a == 0) {
            extraEuclid.x = 0;
            extraEuclid.y = 1;
            extraEuclid.d = b;
            return extraEuclid;
        }
        ExtraEuclid temp = gcdex(b % a, a);
        extraEuclid.setX(temp.y - (b / a) * temp.x);
        extraEuclid.setY(temp.x);
        extraEuclid.setD(temp.d);
        return extraEuclid;
    }

    /**
 * Returns all divisors of n (more than 1 and less than n).
 */
    public static List<Long> getDivisors(long n) {
        List<Long> divisors = new ArrayList<>();

        if (n < 4) {
            return divisors;
        }

        for (long i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                divisors.add(i);

                long pair = n / i;
                if (pair != i) {
                    divisors.add(pair);
                }
            }
        }

        return divisors;
    }

    /**
 * Return the sum of the divisors of n.
 *
 * @see <a href="https://en.wikipedia.org/wiki/Divisor_function">detailed description</a>
 */
    public static BigInteger getSumOfDivisors(long number) {
        if (SUM_OF_DIVISORS_BI_MAP.containsKey(number)) {
            return SUM_OF_DIVISORS_BI_MAP.get(number);
        }

        BigInteger mul = BigInteger.ONE;

        Map<Integer, Integer> allPrimeFactorsWithPow = Primes.getAllPrimeFactorsWithPow(number);
        for (int prime : allPrimeFactorsWithPow.keySet()) {
            BigInteger den = BigInteger.valueOf(prime).subtract(BigInteger.ONE);
            BigInteger sum = BigInteger.valueOf(prime)
                    .pow(BigInteger.valueOf(allPrimeFactorsWithPow.get(prime)).add(BigInteger.ONE).intValueExact())
                    .subtract(BigInteger.ONE)
                    .divide(den);
            mul = mul.multiply(sum);
        }

        SUM_OF_DIVISORS_BI_MAP.put(number, mul);
        return SUM_OF_DIVISORS_BI_MAP.get(number);
    }

    /**
 * Return the sum of the divisors of n not exceeding n.
 */
    public static int getSumOfDivisorsLessThanN(int n) {
        if (n < 2) {
            return 0;
        }

        int sum = 1;
        for (int i = 2; i <= (int) Math.sqrt(n); i++) {
            if (n % i == 0) {
                int pair = n / i;
                sum += pair == i ? i : i + pair;
            }
        }

        return sum;
    }

    /**
 * Return the count of divisors of n.
 */
    public static int getCountOfDivisors(long n) {
        if (COUNT_OF_DIVISORS.containsKey(n)) {
            COUNT_OF_DIVISORS.get(n);
        }

        Map<Integer, Integer> result = Primes.getAllPrimeFactorsWithPow(n);
        int sum = 1;
        for (int value : result.values()) {
            sum *= value + 1;
        }
        COUNT_OF_DIVISORS.put(n, sum);
        return sum;
    }

    @Data
    public static class ExtraEuclid {
        private long d;
        private long x;
        private long y;
    }

}

 */
