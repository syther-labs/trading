import sbt._
import org.portablescala.sbtplatformdeps.PlatformDepsPlugin.autoImport._

object Dependencies {

  object V {
    val cats          = "2.12.0"
    val catsEffect    = "3.6.1"
    val circe         = "0.14.10"
    val circeRefined  = "0.15.1"
    val ciris         = "3.8.0"
    val doobie        = "1.0.0-RC8"
    val flyway        = "8.5.13"
    val fs2Core       = "3.12.0"
    val fs2Kafka      = "3.6.0"
    val http4s        = "1.0.0-M43"
    val http4sMetrics = "1.0.0-M38"
    val http4sWs      = "1.0.0-M9"
    val ip4s          = "3.7.0"
    val iron          = "2.6.0"
    val kittens       = "3.4.0"
    val log4cats      = "2.7.0"
    val monocle       = "3.3.0"
    val natchez       = "0.3.7"
    val natchezHttp4s = "0.6.0"
    val neutron       = "0.8.0"
    val odin          = "0.15.0"
    val redis4cats    = "1.7.2"
    val refined       = "0.11.3"

    val scalajsTime = "2.4.0"
    val tyrian      = "0.6.1"

    val scalacheck = "1.18.1"
    val weaver     = "0.8.4"

    val organizeImports = "0.6.0"
    val zerowaste       = "0.2.27"
  }

  object Libraries {
    def circe(artifact: String) = Def.setting("io.circe" %%% s"circe-$artifact" % V.circe)

    def http4s(artifact: String): ModuleID = "org.http4s" %% s"http4s-$artifact" % V.http4s

    val cats       = Def.setting("org.typelevel" %%% "cats-core" % V.cats)
    val catsEffect = Def.setting("org.typelevel" %%% "cats-effect" % V.catsEffect)
    val fs2Core    = Def.setting("co.fs2" %%% "fs2-core" % V.fs2Core)
    val kittens    = Def.setting("org.typelevel" %%% "kittens" % V.kittens)

    val cirisCore    = Def.setting("is.cir" %%% "ciris" % V.ciris)
    val cirisRefined = Def.setting("is.cir" %%% "ciris-refined" % V.ciris)

    val circeCore   = circe("core")
    val circeParser = circe("parser")

    val circeRefined = Def.setting("io.circe" %%% "circe-refined" % V.circeRefined)

    val doobieH2 = "org.tpolecat" %% "doobie-h2"       % V.doobie
    val doobiePg = "org.tpolecat" %% "doobie-postgres" % V.doobie
    val flyway   = "org.flywaydb"  % "flyway-core"     % V.flyway

    val http4sDsl    = http4s("dsl")
    val http4sServer = http4s("ember-server")
    val http4sClient = http4s("ember-client")
    val http4sCirce  = http4s("circe")

    val http4sJdkWs   = "org.http4s" %% "http4s-jdk-http-client"    % V.http4sWs
    val http4sMetrics = "org.http4s" %% "http4s-prometheus-metrics" % V.http4sMetrics

    val ironCore  = Def.setting("io.github.iltotore" %%% "iron" % V.iron)
    val ironCats  = Def.setting("io.github.iltotore" %%% "iron-cats" % V.iron)
    val ironCirce = Def.setting("io.github.iltotore" %%% "iron-circe" % V.iron)

    val ip4sCore = Def.setting("com.comcast" %%% "ip4s-core" % V.ip4s)

    val natchezCore      = "org.tpolecat" %% "natchez-core"      % V.natchez
    val natchezHoneycomb = "org.tpolecat" %% "natchez-honeycomb" % V.natchez
    val natchezHttp4s    = "org.tpolecat" %% "natchez-http4s"    % V.natchezHttp4s

    val neutronCore       = "dev.profunktor" %% "neutron-core"       % V.neutron
    val redis4catsEffects = "dev.profunktor" %% "redis4cats-effects" % V.redis4cats

    val monocleCore = Def.setting("dev.optics" %%% "monocle-core" % V.monocle)

    val odin = "dev.scalafreaks" %% "odin-core" % V.odin

    // only for ember
    val log4catsNoop = "org.typelevel" %% "log4cats-noop" % V.log4cats

    // webapp
    val scalajsTime = Def.setting("io.github.cquiroz" %%% "scala-java-time" % V.scalajsTime)
    val tyrian      = Def.setting("io.indigoengine" %%% "tyrian" % V.tyrian)
    val tyrianIO    = Def.setting("io.indigoengine" %%% "tyrian-io" % V.tyrian)

    // test
    val catsLaws         = "org.typelevel"       %% "cats-laws"         % V.cats
    val monocleLaw       = "dev.optics"          %% "monocle-law"       % V.monocle
    val scalacheck       = "org.scalacheck"      %% "scalacheck"        % V.scalacheck
    val weaverCats       = "com.disneystreaming" %% "weaver-cats"       % V.weaver
    val weaverDiscipline = "com.disneystreaming" %% "weaver-discipline" % V.weaver
    val weaverScalaCheck = "com.disneystreaming" %% "weaver-scalacheck" % V.weaver

    // only for demo
    val fs2Kafka    = "com.github.fd4s" %% "fs2-kafka" % V.fs2Kafka
    val refinedCore = Def.setting("eu.timepit" %%% "refined" % V.refined)
    val refinedCats = Def.setting("eu.timepit" %%% "refined-cats" % V.refined)
  }

  object CompilerPlugins {
    val zerowaste = compilerPlugin("com.github.ghik" % "zerowaste" % V.zerowaste cross CrossVersion.full)
  }

}
