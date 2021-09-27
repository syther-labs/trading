import sbt._

object Dependencies {

  object V {
    val cats       = "2.6.1"
    val catsEffect = "3.2.9"
    val circe      = "0.14.1"
    val derevo     = "0.12.5"
    val fs2        = "3.1.3"
    val fs2Kafka   = "2.2.0"
    val http4s     = "0.23.4"
    val monocle    = "3.1.0"
    val neutron    = "0.0.8"
    val newtype    = "0.4.4"
    val refined    = "0.9.26"
    val redis4cats = "1.0.0"
    val scalacheck = "1.15.4"

    val weaver = "0.7.6"

    val betterMonadicFor = "0.3.1"
    val betterToString   = "0.3.8"
    val kindProjector    = "0.13.0"
    val organizeImports  = "0.5.0"
    val semanticDB       = "4.4.28"
  }

  object Libraries {
    def derevo(artifact: String): ModuleID = "tf.tofu"    %% s"derevo-$artifact" % V.derevo
    def http4s(artifact: String): ModuleID = "org.http4s" %% s"http4s-$artifact" % V.http4s

    val cats       = "org.typelevel" %% "cats-core"   % V.cats
    val catsEffect = "org.typelevel" %% "cats-effect" % V.catsEffect
    val fs2        = "co.fs2"        %% "fs2-core"    % V.fs2

    val derevoCats          = derevo("cats")
    val derevoCirceMagnolia = derevo("circe-magnolia")
    val derevoTagless       = derevo("cats-tagless")

    val circeGenericExtras = "io.circe" %% "circe-generic-extras" % V.circe

    val http4sDsl    = http4s("dsl")
    val http4sServer = http4s("ember-server")
    val http4sClient = http4s("ember-client")
    val http4sCirce  = http4s("circe")

    val refinedCore = "eu.timepit" %% "refined"      % V.refined
    val refinedCats = "eu.timepit" %% "refined-cats" % V.refined

    // brokers
    val neutronCore  = "com.chatroulette" %% "neutron-core"  % V.neutron
    val neutronCirce = "com.chatroulette" %% "neutron-circe" % V.neutron
    val fs2Kafka     = "com.github.fd4s"  %% "fs2-kafka"     % V.fs2Kafka

    val newtype = "io.estatico" %% "newtype" % V.newtype

    val monocleCore  = "dev.optics" %% "monocle-core"  % V.monocle
    val monocleMacro = "dev.optics" %% "monocle-macro" % V.monocle

    val redis4catsEffects = "dev.profunktor" %% "redis4cats-effects" % V.redis4cats

    // test
    val monocleLaw       = "dev.optics"          %% "monocle-law"       % V.monocle
    val scalacheck       = "org.scalacheck"      %% "scalacheck"        % V.scalacheck
    val weaverCats       = "com.disneystreaming" %% "weaver-cats"       % V.weaver
    val weaverDiscipline = "com.disneystreaming" %% "weaver-discipline" % V.weaver
    val weaverScalaCheck = "com.disneystreaming" %% "weaver-scalacheck" % V.weaver

    // Scalafix rules
    val organizeImports = "com.github.liancheng" %% "organize-imports" % V.organizeImports
  }

  object CompilerPlugins {
    val betterMonadicFor = compilerPlugin("com.olegpy" %% "better-monadic-for" % V.betterMonadicFor)
    val betterToString = compilerPlugin(
      "org.polyvariant" % "better-tostring" % V.betterToString cross CrossVersion.full
    )
    val kindProjector = compilerPlugin(
      "org.typelevel" %% "kind-projector" % V.kindProjector cross CrossVersion.full
    )
    val semanticDB = compilerPlugin(
      "org.scalameta" % "semanticdb-scalac" % V.semanticDB cross CrossVersion.full
    )
  }

}
