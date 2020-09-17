# Algorithms Library

Algorithms library contains the most popular and interesting algorithms.

The following books, articles and resources served as a source for the algorithms - [source of algorithms](https://artemkorsakov.github.io/algorithms/sources_of_algorithms.html).

## Installation

[![Maven Central](https://img.shields.io/maven-central/v/com.github.artemkorsakov/algorithms-core_2.13.svg?label=Maven%20Central&color=success)](https://search.maven.org/search?q=g:%22com.github.artemkorsakov%22%20AND%20a:%22algorithms-core_2.13%22) 
[![latest snapshot](https://img.shields.io/nexus/s/https/oss.sonatype.org/com.github.artemkorsakov/algorithms-core_2.13.svg?label=latest%20snapshot)](https://oss.sonatype.org/content/repositories/snapshots/com/github/artemkorsakov/algorithms-core_2.13/)
![last commit](https://img.shields.io/github/last-commit/artemkorsakov/algorithms)


Add the following to your build.sbt
```scala
libraryDependencies += "com.github.artemkorsakov" %% "algorithms-core" % "0.0.3"
```

**Using**
```scala
import com.github.artemkorsakov.primes.Primes._

val res = 1000999.isPrime
// res: Boolean = true
```

## Documentation
The library homepage is available [here](https://artemkorsakov.github.io/algorithms/).
<br>The library documentation is available [here](https://artemkorsakov.github.io/algorithms/docs/).
<br>The library API is available [here](https://artemkorsakov.github.io/algorithms/api/).