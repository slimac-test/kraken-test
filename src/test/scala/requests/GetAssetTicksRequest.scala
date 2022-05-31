package requests

import config.Configuration.krakenURL
import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.http.request.builder.HttpRequestBuilder


object GetAssetTicksRequest {

  val getAssetTicksRequest: HttpRequestBuilder = http(session => "Get Asset Ticks")
    .get(krakenURL + "/Ticker")
    .header(name = "content-type", value = "application/x-www-form-urlencoded")
    .header(name = "User-Agent", value  = "Gatling")
    .queryParam("pair", session => session("pair1").as[String])
    .check(status in Seq(200,304))
    .check(jsonPath("$.result.*.a").find.saveAs("tick"))
}
