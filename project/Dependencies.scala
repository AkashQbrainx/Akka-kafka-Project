import sbt._

object Dependencies{
  lazy val akkaVersion = "2.6.16"
  lazy val kafkaversion="2.1.1"
  lazy val kafka="com.typesafe.akka" %% "akka-stream-kafka" % kafkaversion
  lazy val akka ="com.typesafe.akka" %% "akka-stream" % akkaVersion
  def compileDependencies: Seq[ModuleID] =Seq(kafka,akka)
}
