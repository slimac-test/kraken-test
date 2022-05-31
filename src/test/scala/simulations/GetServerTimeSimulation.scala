package simulations

import scenarios.GetServerTimeScenario
import config.Configuration._
import io.gatling.core.Predef._

import scala.concurrent.duration.DurationInt
import scala.language.postfixOps
import org.slf4j.LoggerFactory
import ch.qos.logback.classic.{Level, LoggerContext}



class GetServerTimeSimulation extends Simulation{
  val context: LoggerContext = LoggerFactory.getILoggerFactory.asInstanceOf[LoggerContext]
  // Log all HTTP requests
  context.getLogger("io.gatling.http").setLevel(Level.valueOf("INFO"))

    private val getServerTimeRamExec = GetServerTimeScenario.getServerTimeScenario
      .inject(rampUsers(users) during (rampUp minutes))
    setUp(getServerTimeRamExec)
      .assertions(
          global.responseTime.max.lt( threshold = 5000),
          global.failedRequests.percent.lt(5),
          global.successfulRequests.percent.gt(90))
      .maxDuration(maxDuration minutes)


}
