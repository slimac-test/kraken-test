package requests
import config.Configuration.krakenURL
import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.http.request.builder.HttpRequestBuilder


object GetTradableRecentTradesRequest {

  val getRecentTradesRequest: HttpRequestBuilder = http(session => "Get Recent Trades Request")
    .get(krakenURL + "/Trades")
    .header(name = "content-type", value = "application/x-www-form-urlencoded")
    .header(name = "User-Agent", value  = "Gatling")
    .queryParam("pair", session => session("pair2").as[String])
    .check(status is 200)
    .check(jsonPath("$.result.last").find.saveAs("lastData"))
}
