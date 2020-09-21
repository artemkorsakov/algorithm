package com.github.artemkorsakov.digital

class Digits(number: BigInt) {

  /** Returns the digits of a number.
    */
  def digits: Array[Int] = {
    val digits = new Array[Int](number.toString.length)
    var i      = 1
    var n      = number
    while (i <= digits.length) {
      digits(digits.length - i) = (n % 10).toInt
      n /= 10
      i += 1
    }
    digits
  }

  /** Returns the sum of the digits of a number.
    */
  def sumOfDigits: Int = {
    var sum = 0
    var n   = number
    while (n > 0) {
      sum += (n % 10).toInt
      n /= 10
    }
    sum
  }

}

object Digits {
  implicit def int2Digits(n: Int): Digits       = new Digits(BigInt(n))
  implicit def long2Digits(n: Long): Digits     = new Digits(BigInt(n))
  implicit def string2Digits(n: String): Digits = new Digits(BigInt(n))
  implicit def bigint2Digits(n: BigInt): Digits = new Digits(n)

  /** Do two numbers contain the same digits?
    */
  def containTheSameDigits(number1: Long, number2: Long): Boolean =
    containTheSameDigits(String.valueOf(number1), String.valueOf(number2))

  /** Do two numbers contain the same digits?
    */
  def containTheSameDigits(number1: String, number2: String): Boolean =
    (number1.length == number2.length) && number1.toCharArray.sorted.sameElements(number2.toCharArray.sorted)

}

/*
public class Digits {

    /**
 * Is the given digit in the given number at least countOfEqual times?
 */
    public static boolean hasEqualDigits(long number, int countOfEqual, int digit) {
        return getDigits(number).stream().filter(d -> d == digit).count() >= countOfEqual;
    }

    /**
 * Has equal digits?
 */
    public static boolean hasEqualDigits(long number) {
        List<Integer> digits = getDigits(number);
        return digits.size() != digits.stream().distinct().count();
    }

    /**
 * Returns all numbers made up of given digits.
 */
    public static List<Integer> getPossibleVariants(List<Integer> digits) {
        return getStringPossibleVariants(digits).stream().map(Integer::parseInt).collect(Collectors.toList());
    }

    /**
 * Returns all numbers made up of given digits.
 */
    public static List<String> getStringPossibleVariants(List<Integer> digits) {
        if (digits.size() == 1) {
            return Collections.singletonList("" + digits.get(0));
        }

        List<String> products = new ArrayList<>();
        for (int i = 0; i < digits.size(); i++) {
            String digit = "" + digits.get(i);
            List<Integer> tmpDigits = new ArrayList<>();
            tmpDigits.addAll(digits.subList(0, i));
            tmpDigits.addAll(digits.subList(i + 1, digits.size()));
            List<String> tmpVariants = getStringPossibleVariants(tmpDigits);
            for (String tmpVariant : tmpVariants) {
                String newProduct = digit + tmpVariant;
                if (!products.contains(newProduct)) {
                    products.add(newProduct);
                }
            }
        }

        return products;
    }

}

 */
