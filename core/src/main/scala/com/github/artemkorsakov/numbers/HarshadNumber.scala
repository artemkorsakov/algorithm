package com.github.artemkorsakov.numbers

class HarshadNumber {

}

/*
package com.github.artemkorsakov.numbers;

import com.github.artemkorsakov.digital.Digits;
import com.github.artemkorsakov.primes.Primes;

import java.util.ArrayList;
import java.util.List;

public class HarshadNumbers {
    /**
     * Now take the number 2011 which is prime.
     * When we truncate the last digit from it we get 201, a strong Harshad number that is also right truncatable.
     * Let's call such primes strong, right truncatable Harshad primes.
     */
    public static List<Long> getStrongRightTruncatableHarshadPrimes(long strongHarshadNumber) {
        List<Long> results = new ArrayList<>();

        strongHarshadNumber *= 10;
        for (int i = 1; i <= 9; i = i + 2) {
            if (Primes.isPrime(strongHarshadNumber + i)) {
                results.add(strongHarshadNumber + i);
            }
        }

        return results;
    }

    /**
     * Let's call a Harshad number that, when divided by the sum of its digits,
     * results in a prime a strong Harshad number.
     */
    public static boolean isStrongHarshadNumber(long harshadNumber) {
        long sumOfDigits = Digits.getSumOfDigits(harshadNumber);
        return Primes.isPrime(harshadNumber / sumOfDigits);
    }

    /**
     * A Harshad or Niven number is a number that is divisible by the sum of its digits.
     * 201 is a Harshad number because it is divisible by 3 (the sum of its digits.)
     * When we truncate the last digit from 201, we get 20, which is a Harshad number.
     * When we truncate the last digit from 20, we get 2, which is also a Harshad number.
     * Let's call a Harshad number that, while recursively truncating the last digit,
     * always results in a Harshad number a right truncatable Harshad number.
     */
    public static List<Long> getRightTruncatableHarshadNumber(List<Long> harshadNumbers) {
        return harshadNumbers.stream().map(HarshadNumbers::getRightTruncatableHarshadNumber).reduce((l1, l2) -> {
            l1.addAll(l2);
            return l1;
        }).orElse(new ArrayList<>());
    }

    /**
     * Gets right truncatable harshad number.
     */
    public static List<Long> getRightTruncatableHarshadNumber(long harshadNumber) {
        long sumOfDigits = Digits.getSumOfDigits(harshadNumber);

        List<Long> numbers = new ArrayList<>();
        long newNumber = harshadNumber * 10;
        numbers.add(newNumber); // C 0 на конце всегда подходит

        for (int i = 1; i <= 9; i++) {
            newNumber++;
            sumOfDigits++;
            if (newNumber % sumOfDigits == 0) {
                numbers.add(newNumber);
            }
        }

        return numbers;
    }
}

 */
