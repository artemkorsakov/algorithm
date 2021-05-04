import sbt._

object Dependencies {

  object Version {
    val Scala213 = "2.13.4"
    val Scala212 = "2.12.13"

    val Scalatest      = "3.2.6"
    val Scalatestplus  = "3.2.6.0"
    val Pureconfig     = "0.14.1"
    val Logback        = "1.2.3"
    val ScalaLogging   = "3.9.2"
  }

  val algorithms = Def.setting(
    Seq(
      "org.scalatestplus"          %% "selenium-3-141"                          % Version.Scalatestplus,
      "org.scalatest"              %% "scalatest"                               % Version.Scalatest,
      "com.github.pureconfig"      %% "pureconfig"                              % Version.Pureconfig,
      "com.github.pureconfig"      %% "pureconfig-enumeratum"                   % Version.Pureconfig,
      "ch.qos.logback"              % "logback-classic"                         % Version.Logback,
      "com.typesafe.scala-logging" %% "scala-logging"                           % Version.ScalaLogging,
    )
  )

}
