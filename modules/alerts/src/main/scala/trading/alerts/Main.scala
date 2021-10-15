package trading.alerts

import trading.core.AppTopic
import trading.core.http.Ember
import trading.core.snapshots.SnapshotReader
import trading.domain.Alert
import trading.events.TradeEvent
import trading.lib.inject.given
import trading.lib.{ Consumer, Producer }

import cats.effect.*
import dev.profunktor.pulsar.{ Config, Pulsar, Subscription }
import dev.profunktor.redis4cats.effect.Log.Stdout.*
import fs2.Stream

object Main extends IOApp.Simple:
  def run: IO[Unit] =
    Stream
      .resource(resources)
      .flatMap { (server, engine) =>
        Stream.eval(server.useForever).concurrently(engine.run)
      }
      .compile
      .drain

  val config = Config.Builder.default

  val sub =
    Subscription.Builder
      .withName("alerts-sub")
      .withType(Subscription.Type.Shared)
      .build

  val alertsTopic = AppTopic.Alerts.make(config)
  val eventsTopic = AppTopic.TradingEvents.make(config)

  def resources =
    for {
      pulsar    <- Pulsar.make[IO](config.url)
      _         <- Resource.eval(IO.println(">>> Initializing alerts service <<<"))
      snapshots <- SnapshotReader.make[IO]
      producer  <- Producer.pulsar[IO, Alert](pulsar, alertsTopic)
      consumer  <- Consumer.pulsar[IO, TradeEvent](pulsar, eventsTopic, sub)
      server = Ember.default[IO]
    } yield server -> AlertEngine.make[IO](consumer, producer, snapshots)
