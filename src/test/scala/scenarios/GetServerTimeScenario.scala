package scenarios

import io.gatling.core.Predef._
import io.gatling.core.structure.ScenarioBuilder
import requests.{GetAssetInfoRequest, GetAssetTicksRequest, GetServerTimeRequest, GetSystemStatusRequest, GetTradableAssetPairsRequest, GetTradableRecentTradesRequest}

import scala.util.Random

object GetServerTimeScenario {
  val startTime = 1559347200
  val random = new Random
  val currencyabv = Seq("USD", "XBT", "EUR")
  val pair1: String = currencyabv(random.nextInt(currencyabv.length)).toString
  val pair2: String = currencyabv(random.nextInt(currencyabv.length)).toString

  val getServerTimeScenario: ScenarioBuilder = scenario("Get Server Time Scenario")

    .exec(GetServerTimeRequest.getServerTime)
    .exec(GetSystemStatusRequest.getSystemStatus)
    .exec(GetAssetInfoRequest.getAssetInfo)
    .exec(GetTradableAssetPairsRequest.getTradableAssetPairsRequest)
    .asLongAs(session => !session.isFailed) {
      exec(GetTradableRecentTradesRequest.getRecentTradesRequest)
      exec(GetAssetTicksRequest.getAssetTicksRequest)
      exec(GetTradableAssetPairsRequest.getTradableAssetPairsRequest)
    }
}
