package com.qbrainx.actor

import akka.actor.ActorSystem

import scala.concurrent.{ExecutionContext, ExecutionContextExecutor}

object Implicits {
  implicit val system: ActorSystem = ActorSystem("myActor")
  implicit val ec: ExecutionContextExecutor = ExecutionContext.global
}
