package com.github.artemkorsakov.digital

class Pandigital {}

object Pandigital {}

/*
public class Pandigital {
    /**
 * Is a number an integer that has among its significant digits each digit used exactly once?
 */
    public static boolean isPandigital(long number) {
        return isPandigital("" + number);
    }

    /**
 * Is a number an integer that has among its significant digits each digit used exactly once?
 */
    public static boolean isPandigital(String number) {
        return number.length() == 9 && !number.contains("0") && number.chars().distinct().count() == 9;
    }

    /**
 * Is a number an integer that has among its significant digits (from 1 to n) each digit used exactly once?
 */
    public static boolean isPandigital(long number, int n) {
        return isPandigital("" + number, n);
    }

    /**
 * Is a number an integer that has among its significant digits (from 1 to n) each digit used exactly once?
 */
    public static boolean isPandigital(String number, int n) {
        if (number.length() != n) {
            return false;
        }

        for (int i = 1; i <= n; i++) {
            if (!number.contains("" + i)) {
                return false;
            }
        }

        return true;
    }

    /**
 * Is a number an integer that has among its significant digits (from digits list) each digit used exactly once?
 */
    public static boolean isPandigital(long number, List<Integer> digits) {
        return isPandigital("" + number, digits);
    }

    /**
 * Is a number an integer that has among its significant digits (from digits list) each digit used exactly once?
 */
    public static boolean isPandigital(String number, List<Integer> digits) {
        if (number.length() != digits.size()) {
            return false;
        }

        for (int digit : digits) {
            if (!number.contains("" + digit)) {
                return false;
            }
        }

        return true;
    }
}

 */
