package com.qbrainx.app

import akka.kafka.ProducerSettings
import akka.kafka.scaladsl.Producer
import akka.stream.scaladsl.Source
import com.qbrainx.config.AppConfig
import org.apache.kafka.clients.producer.ProducerRecord
import org.apache.kafka.common.serialization.StringSerializer
import com.qbrainx.actor.Implicits._

object ProducerApp extends App {

  val producerProperties=AppConfig.producerConfig
  val topic: String = AppConfig.topic
  println("producing message from "+topic)
  val producerSettings =
    ProducerSettings(producerProperties, new StringSerializer, new StringSerializer)
  Source(1 to 10)
    .map(msg =>
         new ProducerRecord[String, String](topic, s"$msg"))
    .runWith(Producer.plainSink(producerSettings))
}
