package com.github.artemkorsakov.divisors

class PerfectNumbers {}

/*
/**
 * @see <a href="https://en.wikipedia.org/wiki/Perfect_number">Perfect number</a>
 */
public class PerfectDeficientAbundantNumbers {
    public static TypeNumber getTypeNumber(int number) {
        int sum = Divisors.getSumOfDivisorsLessThanN(number);
        return sum == number ? TypeNumber.Perfect : sum < number ? TypeNumber.Deficient : TypeNumber.Abundant;
    }

    public enum TypeNumber {
        Perfect, Deficient, Abundant
    }
}
 */
