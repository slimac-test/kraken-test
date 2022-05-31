package requests

import config.Configuration.krakenURL
import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.http.request.builder.HttpRequestBuilder

object GetTradableAssetPairsRequest {

  val getTradableAssetPairsRequest: HttpRequestBuilder = http( session => "Get Tradable Asset Pairs")
    .get(krakenURL + "/AssetPairs")
    .header(name = "content-type", value = "application/x-www-form-urlencoded")
    .header(name = "User-Agent", value  = "Gatling")
    .check(status in Seq(200,304))
    .check(jsonPath("$.result..altname").findAll.saveAs("pairlist"))
    .check(jsonPath("$.result..altname").findRandom.saveAs("pair1"))
    .check(jsonPath("$.result..altname").findRandom.saveAs("pair2"))
    .check(jsonPath("$.result..altname").findRandom.saveAs("pair3"))


}
