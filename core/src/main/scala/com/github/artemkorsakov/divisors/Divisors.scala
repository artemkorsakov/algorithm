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

  /** Extended Euclidean algorithm.
    *
    * @see <a href="https://en.wikipedia.org/wiki/Extended_Euclidean_algorithm">detailed description</a>
    */
  def gcdex(a: Long, b: Long): (Long, Long, Long) =
    if (a == 0) {
      (b, 0, 1)
    } else {
      val temp = gcdex(b % a, a)
      (temp._1, temp._3 - (b / a) * temp._2, temp._2)
    }

  /** Modular multiplicative inverse.
    *
    * @see <a href="https://en.wikipedia.org/wiki/Modular_multiplicative_inverse">detailed description</a>
    */
  def gcdInverse(a: Long, m: Long): Long = {
    val extraEuclid = gcdex(a, m)
    if (extraEuclid._1 == 1) {
      (extraEuclid._2 % m + m) % m
    } else {
      -1
    }
  }

}
/*
    private static final Map<Long, BigInteger> SUM_OF_DIVISORS_BI_MAP = new HashMap<>();
    private static final Map<Long, Integer> COUNT_OF_DIVISORS = new HashMap<>();

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
}

 */
