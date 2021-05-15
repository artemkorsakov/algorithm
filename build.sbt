import Dependencies.Version._
import microsites._
import sbtcatalysts.CatalystsKeys.docsMappingsAPIDir
import sbtcrossproject.CrossPlugin.autoImport.CrossType

addCommandAlias("com", "all compile test:compile")
addCommandAlias("fmt", "all scalafmtSbt scalafmtAll")
addCommandAlias("fmtCheck", "all scalafmtSbtCheck scalafmtCheckAll")
addCommandAlias("stl", "all scalastyle test:scalastyle")
addCommandAlias("gitSnapshots", ";set version in ThisBuild := git.gitDescribedVersion.value.get + \"-SNAPSHOT\"")

val release_version = "0.1.3"
val badge =
  "[![Maven Central](https://img.shields.io/maven-central/v/com.github.artemkorsakov/algorithms-core_2.13.svg?label=Maven%20Central&color=success)](https://search.maven.org/search?q=g:%22com.github.artemkorsakov%22%20AND%20a:%22algorithms-core_2.13%22)"

val gh = GitHubSettings(
  org = "artemkorsakov",
  proj = "algorithms",
  publishOrg = "com.github.artemkorsakov",
  license = apache
)

val github = "https://github.com/artemkorsakov"
val mainDev =
  Developer(
    "Artem Korsakov",
    "@artemkorsakov",
    "artemkorsakov@mail.ru",
    new java.net.URL(github)
  )

val devs = List(mainDev)
val libs = org.typelevel.libraries

ThisBuild / crossScalaVersions := Seq(Scala212, Scala213)
ThisBuild / scalaVersion := Scala213

lazy val rootSettings = buildSettings ++ commonSettings ++ publishSettings ++ scoverageSettings
lazy val module       = mkModuleFactory(gh.proj, mkConfig(rootSettings, commonJvmSettings, commonJsSettings))
lazy val prj          = mkPrjFactory(rootSettings)

lazy val rootPrj = project
  .configure(mkRootConfig(rootSettings, rootJVM))
  .aggregate(rootJVM, rootJS)
  .dependsOn(rootJVM, rootJS)
  .settings(
    noPublishSettings,
    crossScalaVersions := Nil
  )

lazy val rootJVM = project
  .configure(mkRootJvmConfig(gh.proj, rootSettings, commonJvmSettings))
  .aggregate(macrosJVM, platformJVM, docs, algorithms)
  .dependsOn(macrosJVM, platformJVM)
  .settings(noPublishSettings, crossScalaVersions := Nil)

lazy val rootJS = project
  .configure(mkRootJsConfig(gh.proj, rootSettings, commonJsSettings))
  .aggregate(macrosJS, platformJS)
  .settings(
    noPublishSettings,
    crossScalaVersions := Nil
  )

/** Macros - cross project that defines macros. */
lazy val macros    = prj(macrosM)
lazy val macrosJVM = macrosM.jvm
lazy val macrosJS  = macrosM.js
lazy val macrosM = module("macros", CrossType.Pure).settings(
  noPublishSettings
)

/** Platform - cross project that provides cross platform support. */
lazy val platform    = prj(platformM)
lazy val platformJVM = platformM.jvm
lazy val platformJS  = platformM.js
lazy val platformM = module("platform", CrossType.Dummy)
  .dependsOn(macrosM)
  .settings(
    noPublishSettings,
    libs.dependencies("specs2-core", "specs2-scalacheck"),
    libs.testDependencies("scalatest")
  )

/** Docs - Generates and publishes the scaladoc API documents and the project web site. */
lazy val docs = project
  .dependsOn(algorithms)
  .configure(mkDocConfig(gh, rootSettings, Seq(), platformJVM, macrosJVM))
  .enablePlugins(MicrositesPlugin, ScalaUnidocPlugin)
  .settings(
    micrositeName := "Algorithms Library",
    micrositeDescription := "Algorithms library contains the most popular and interesting algorithms.",
    micrositeUrl := "https://artemkorsakov.github.io",
    micrositeBaseUrl := "/algorithms",
    micrositeDocumentationUrl := "/algorithms/docs",
    micrositeDocumentationLabelDescription := "Documentation",
    micrositeAuthor := "Artem Korsakov",
    micrositeGithubOwner := "artemkorsakov",
    micrositeGithubRepo := "algorithms",
    micrositeTheme := "pattern",
    micrositeEditButton := Some(
      MicrositeEditButton("Improve this Page", "/edit/master/docs/docs/{{ page.path }}")
    ),
    micrositeGithubToken := sys.env.get("GITHUB_TOKEN"),
    micrositePushSiteWith := GitHub4s,
    micrositeGitterChannel := false,
    micrositePalette := Map(
      "brand-primary"   -> "#5B5988",
      "brand-secondary" -> "#292E53",
      "brand-tertiary"  -> "#222749",
      "gray-dark"       -> "#49494B",
      "gray"            -> "#7B7B7E",
      "gray-light"      -> "#E5E5E6",
      "gray-lighter"    -> "#F4F3F4",
      "white-color"     -> "#FFFFFF"
    ),
    apiURL := Some(url(s"${micrositeUrl.value}${micrositeBaseUrl.value}/api/")),
    autoAPIMappings := true,
    unidocProjectFilter in (ScalaUnidoc, unidoc) := inProjects(algorithms),
    docsMappingsAPIDir := "api",
    addMappingsToSiteDir(mappings in (ScalaUnidoc, packageDoc), docsMappingsAPIDir),
    scalacOptions in (ScalaUnidoc, unidoc) ~= { _.filter(_ != "-Xlint:-unused,_") },
    mdocVariables := Map(
      "VERSION"                   -> release_version,
      "SCALA_VERSIONS"            -> "2.13, 2.12",
      "MAVEN_BADGE"               -> badge,
      "DESCRIPTION"               -> micrositeDescription.value,
      "EMAIL"                     -> s"mailto:${mainDev.email}",
      "GITHUB"                    -> github,
      "ISSUES"                    -> s"$github/algorithms/issues",
      "PULLS"                     -> s"$github/algorithms/pulls",
      "WEBSITE"                   -> s"${micrositeUrl.value}${micrositeBaseUrl.value}",
      "DOC_SITE"                  -> s"${micrositeUrl.value}${micrositeDocumentationUrl.value}",
      "API_SITE"                  -> apiURL.value.get.toString,
      "SOURCE_OF_ALGORITHMS_LINK" -> s"${micrositeUrl.value}/algorithms/sources_of_algorithms.html"
    )
  )

lazy val buildSettings = sharedBuildSettings(gh, libs)

lazy val commonSettings = sharedCommonSettings ++ Seq(
  scalaVersion := (ThisBuild / scalaVersion).value,
  crossScalaVersions := (ThisBuild / crossScalaVersions).value,
  parallelExecution in Test := false,
  developers := devs,
  scalacOptions := scalacOptions.value.filterNot(_.startsWith("-Wunused")).filterNot(_.startsWith("-Ywarn-unused"))
) ++ unidocCommonSettings

lazy val commonJsSettings = Seq(scalaJSStage in Global := FastOptStage)

lazy val commonJvmSettings = Seq()

lazy val publishSettings = sharedPublishSettings(gh) ++ credentialSettings ++ sharedReleaseProcess

lazy val scoverageSettings = sharedScoverageSettings(60)

lazy val algorithms = project
  .settings(
    moduleName := "algorithms-core",
    commonSettings,
    libraryDependencies ++= Dependencies.algorithms.value,
    libs.dependencies("cats-core"),
    libs.testDependencies("scalatest")
  )
