import _root_.sbtcrossproject.CrossPlugin.autoImport.CrossType
import microsites.MicrositeEditButton

addCommandAlias("gitSnapshots", ";set version in ThisBuild := git.gitDescribedVersion.value.get + \"-SNAPSHOT\"")

val apache2 = "Apache-2.0" -> url("https://www.apache.org/licenses/LICENSE-2.0.html")
val gh = GitHubSettings(
  org = "artemkorsakov",
  proj = "",
  publishOrg = "artemkorsakov",
  license = apache2
)

val mainDev =
  Developer(
    "Artem Korsakov",
    "@artemkorsakov",
    "artemkorsakov@mail.ru",
    new java.net.URL("http://github.com/artemkorsakov")
  )

val devs = List(Developer)

lazy val libs = org.typelevel.libraries

lazy val rootSettings = buildSettings ++ commonSettings ++ publishSettings ++ scoverageSettings
lazy val module       = mkModuleFactory(gh.proj, mkConfig(rootSettings, commonJvmSettings, commonJsSettings))
lazy val prj          = mkPrjFactory(rootSettings)

lazy val root = project
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

/** Docs - Generates and publishes the scaladoc API documents and the project web site using sbt-microsite.
  * https://47degrees.github.io/sbt-microsites/docs/settings/
  * https://jekyllrb.com/docs/
  */
lazy val docs = project
  .configure(mkDocConfig(gh, rootSettings, Nil, core))
  .enablePlugins(MicrositesPlugin)
  .enablePlugins(ScalaUnidocPlugin)
  .settings(
    crossScalaVersions := Seq(scalaVersion.value),
    //scalacOptions in Tut ~= (_.filterNot(Set("-Ywarn-unused:imports"))),
    micrositeName := "Algorithm Library",
    micrositeDescription := "This is the description of my Algorithm Library",
    micrositeUrl := "https://artemkorsakov.github.io/algorithm",
    micrositeDocumentationUrl := "/docs",
    micrositeDocumentationLabelDescription := "Documentation",
    micrositeAuthor := "Artem Korsakov",
    micrositeGithubOwner := "artemkorsakov",
    micrositeGithubRepo := "algorithm",
    micrositeTheme := "pattern",
    micrositeEditButton := Some(
        MicrositeEditButton("Improve this Page", "/edit/master/microsite/docs/{{ page.path }}")
      ),
    apiURL := Some(url("https://artemkorsakov.github.io/algorithm/api/")),
    micrositeGithubToken := sys.env.get("GITHUB_TOKEN"),
    micrositePushSiteWith := GitHub4s,
    micrositeGitterChannel := false
  )

lazy val buildSettings = sharedBuildSettings(gh, libs)

lazy val commonSettings =
  addCompilerPlugins(libs, "kind-projector") ++ sharedCommonSettings ++ scalacAllSettings ++ Seq(
    organization := "com.github.artemkorsakov",
    parallelExecution in Test := true,
    crossScalaVersions := Seq(libs.vers("scalac_2.11"), scalaVersion.value)
  )

lazy val commonJsSettings = Seq(scalaJSStage in Global := FastOptStage)

lazy val commonJvmSettings = Seq()

lazy val publishSettings = sharedPublishSettings(gh) ++ credentialSettings ++ sharedReleaseProcess

lazy val scoverageSettings = sharedScoverageSettings(60)

addCommandAlias("rel", "reload")
addCommandAlias("com", "all compile test:compile")
addCommandAlias("mksite", "makeMicrosite")
