import Dependencies.Version._
import sbt.Keys.scalaVersion
import sbt._

object Dependencies {

  object Version {
    val Scala213 = "2.13.4"
    val Scala212 = "2.12.13"

    val ScalaParallelCollections = "1.0.2"
  }

  val algorithms = Def.setting(
    CrossVersion.partialVersion(scalaVersion.value) match {
      case Some((2, major)) if major <= 12 =>
        Seq()
      case _ =>
        Seq("org.scala-lang.modules" %% "scala-parallel-collections" % ScalaParallelCollections)
    }
  )

}
