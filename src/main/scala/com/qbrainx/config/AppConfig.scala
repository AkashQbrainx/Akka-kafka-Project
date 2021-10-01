package com.qbrainx.config

import com.typesafe.config.{Config, ConfigFactory}

object AppConfig {

  val producerConfig: Config =ConfigFactory.load().getConfig("akka.kafka.producer")
  val consumerConfig: Config =ConfigFactory.load().getConfig(" akka.kafka.consumer")

  val topic =producerConfig.getString("topic")


}
