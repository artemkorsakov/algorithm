import sbt.Credentials
import sbt.Keys.credentials
ThisBuild / organization := "com.github.artemkorsakov"
ThisBuild / organizationName := "algorithm"
ThisBuild / organizationHomepage := Some(url("https://github.com/artemkorsakov"))

ThisBuild / scmInfo := Some(
  ScmInfo(
    url("https://github.com/artemkorsakov/algorithms"),
    "scm:git@github.com:artemkorsakov/algorithms.git"
  )
)
ThisBuild / developers := List(
  Developer(
    id = "@artemkorsakov",
    name = "Artem Korsakov",
    email = "artemkorsakov@mail.ru",
    url = url("http://github.com/artemkorsakov")
  )
)

ThisBuild / description := "Algorithms library contains the most popular and efficient algorithms."
ThisBuild / licenses := List("Apache 2" -> new URL("http://www.apache.org/licenses/LICENSE-2.0.txt"))
ThisBuild / homepage := Some(url("https://artemkorsakov.github.io/algorithms/"))

// Remove all additional repository other than Maven Central from POM
ThisBuild / pomIncludeRepository := { _ => false }
ThisBuild / credentials += Credentials(Path.userHome / ".sbt" / ".sonatype_credentials")
ThisBuild / publishTo := {
  val nexus = "https://oss.sonatype.org/"
  if (isSnapshot.value) Some("snapshots" at nexus + "content/repositories/snapshots")
  else Some("releases" at nexus + "service/local/staging/deploy/maven2")
}
ThisBuild / publishMavenStyle := true
