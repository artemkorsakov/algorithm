import _root_.sbtcrossproject.CrossPlugin.autoImport.CrossType
import microsites.MicrositeEditButton

val release_version = "0.0.8"
val badge =
  "[![Maven Central](https://img.shields.io/maven-central/v/com.github.artemkorsakov/algorithms-core_2.13.svg?label=Maven%20Central&color=success)](https://search.maven.org/search?q=g:%22com.github.artemkorsakov%22%20AND%20a:%22algorithms-core_2.13%22)"


val apache2 = "Apache-2.0" -> url("https://www.apache.org/licenses/LICENSE-2.0.html")
val gh = GitHubSettings(
  org = "artemkorsakov",
  proj = "algorithms",
  publishOrg = "artemkorsakov",
  license = apache2
)

val github = "https://github.com/artemkorsakov"
val mainDev =
  Developer(
    "Artem Korsakov",
    "@artemkorsakov",
    "artemkorsakov@mail.ru",
    new java.net.URL(github)
  )

val devs = List(Developer)

lazy val libs = org.typelevel.libraries

lazy val rootSettings = buildSettings ++ commonSettings ++ publishSettings ++ scoverageSettings
lazy val module       = mkModuleFactory(gh.proj, mkConfig(rootSettings, commonJvmSettings, commonJsSettings))
lazy val prj          = mkPrjFactory(rootSettings)

lazy val Algorithms = project
  .in(file("."))
  .configure(mkRootConfig(rootSettings, rootJVM))
  .aggregate(rootJVM)
  .dependsOn(rootJVM)
  .settings(noPublishSettings)

lazy val rootJVM = project
  .configure(mkRootJvmConfig(gh.proj, rootSettings, commonJvmSettings))
  .aggregate(coreJVM, testsJVM, docs)
  .dependsOn(coreJVM, testsJVM)
  .settings(noPublishSettings)

lazy val rootJS = project
  .configure(mkRootJsConfig(gh.proj, rootSettings, commonJsSettings))
  .aggregate(coreJS, testsJS)
  .dependsOn(coreJS, testsJS)
  .settings(noPublishSettings)

lazy val core    = prj(coreM)
lazy val coreJVM = coreM.jvm
lazy val coreJS  = coreM.js
lazy val coreM = module("core", CrossType.Pure)
  .settings(
    libs.dependencies("cats-core")
  )

lazy val tests    = prj(testsM)
lazy val testsJVM = testsM.jvm
lazy val testsJS  = testsM.js
lazy val testsM = module("tests", CrossType.Pure)
  .dependsOn(coreM)
  .settings(
    noPublishSettings,
    libs.testDependencies("scalatest")
  )

lazy val docsMappingsAPIDir = settingKey[String]("Name of subdirectory in site target directory for api docs")

/** Docs - Generates and publishes the scaladoc API documents and the project web site using sbt-microsite.
  * https://47degrees.github.io/sbt-microsites/docs/settings/
  */
lazy val docs = project
  .configure(mkDocConfig(gh, rootSettings, Nil, core))
  .enablePlugins(MicrositesPlugin)
  .enablePlugins(ScalaUnidocPlugin)
  .settings(
    crossScalaVersions := Seq(scalaVersion.value),
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
    unidocProjectFilter in (ScalaUnidoc, unidoc) := inProjects(coreJVM),
    docsMappingsAPIDir := "api",
    addMappingsToSiteDir(mappings in (ScalaUnidoc, packageDoc), docsMappingsAPIDir),
    fork in (ScalaUnidoc, unidoc) := true,
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

lazy val commonSettings =
  addCompilerPlugins(libs, "kind-projector") ++ sharedCommonSettings ++ scalacAllSettings ++ Seq(
    organization := "com.github.artemkorsakov",
    parallelExecution in Test := true,
    crossScalaVersions := Seq(
        libs.vers("scalac_2.12"),
        libs.vers("scalac_2.13")
      )
  )

lazy val commonJsSettings = Seq(scalaJSStage in Global := FastOptStage)

lazy val commonJvmSettings = Seq()

lazy val publishSettings = sharedPublishSettings(gh) ++ credentialSettings ++ sharedReleaseProcess

lazy val scoverageSettings = sharedScoverageSettings(60)

addCommandAlias("com", "all compile test:compile")
