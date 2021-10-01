package com.qbrainx.app

import akka.kafka.scaladsl.Consumer
import akka.kafka.{ConsumerSettings, Subscriptions}
import akka.stream.scaladsl.Sink
import org.apache.kafka.common.serialization.StringDeserializer
import com.qbrainx.actor.Implicits._
import com.qbrainx.config.AppConfig

object ConsumerApp extends App {

  val topic: String = AppConfig.topic
  val config=system.settings.config.getConfig("akka.kafka.consumer")
  val consumerSettings =
    ConsumerSettings(config, new StringDeserializer, new StringDeserializer)

  Consumer
    .plainSource(consumerSettings, Subscriptions.topics(topic))
    .map(_.value().toInt)
    .map({f=>
          println(s"Square Root of value is $f")
          f
    })
    .async
    .map(f=>f*f*f)
    .map({
         f=>println(s"CubeRoot of value is $f" )
         f
    })
    .runWith(Sink.ignore)

}
