# Algorithms Library

Algorithms library contains the most popular and interesting algorithms.

The following books, articles and resources served as a source for the algorithms - [source of algorithms](https://artemkorsakov.github.io/algorithms/sources_of_algorithms.html).

## Installation

[![Maven Central](https://img.shields.io/maven-central/v/com.github.artemkorsakov/algorithms-core_2.13.svg?label=Maven%20Central&color=success)](https://search.maven.org/search?q=g:%22com.github.artemkorsakov%22%20AND%20a:%22algorithms-core_2.13%22) 
[![latest snapshot](https://img.shields.io/nexus/s/https/oss.sonatype.org/com.github.artemkorsakov/algorithms-core_2.13.svg?label=latest%20snapshot&color=success)](https://oss.sonatype.org/content/repositories/snapshots/com/github/artemkorsakov/algorithms-core_2.13/)
![release](https://img.shields.io/github/v/release/artemkorsakov/algorithms?include_prereleases)

[![master](https://img.shields.io/travis/com/artemkorsakov/algorithms/master?label=master)](https://travis-ci.com/artemkorsakov/algorithms)
[![develop](https://img.shields.io/travis/com/artemkorsakov/algorithms/develop?label=develop)](https://travis-ci.com/artemkorsakov/algorithms)
![last commit](https://img.shields.io/github/last-commit/artemkorsakov/algorithms)

Add the following to your build.sbt
```
libraryDependencies += "com.github.artemkorsakov" %% "algorithms-core" % "0.1.0"
```

**Using**
```scala
import com.github.artemkorsakov.primes.Primes._
import com.github.artemkorsakov.primes.PhiFunction._
import com.github.artemkorsakov.combinatorics.BinomialCoefficient._
import com.github.artemkorsakov.combinatorics.Coins._
import com.github.artemkorsakov.combinatorics.Factorials._
import com.github.artemkorsakov.divisors.ChineseRemainderTheorem
import com.github.artemkorsakov.str.NumbersDescription._
import com.github.artemkorsakov.str.RomanNumerals._

val res0 = 1000999.isPrime
// res0: Boolean = true

val res1 = 87109.totient
// res1: Long = 79180

val res2 = binomialCoefficient(100, 68)
// res2: BigInt = 143012501349174257560226775

val res3 = 1000.partition
// res3: BigInt = 24061467864032622473692149727991

val res4 = 30.factorial
// res4: BigInt = 265252859812191058636308480000000

val res5 = ChineseRemainderTheorem.solution(Array(707, 527), Array(0, 5))
// res5: BigInt = 258762

val res6 = 1435.inEnglish
// res6: Option[String] = Some(one thousand four hundred and thirty-five)

val res7 = "MCMLXXXIV".toArabic
// res7: Option[Long] = Some(1984)
```

## Documentation
The library homepage is available [here](https://artemkorsakov.github.io/algorithms/).
<br>The library documentation is available [here](https://artemkorsakov.github.io/algorithms/docs/).
<br>The library API is available [here](https://artemkorsakov.github.io/algorithms/api/).