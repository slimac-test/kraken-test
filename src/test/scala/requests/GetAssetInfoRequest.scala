package requests

import config.Configuration.krakenURL
import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.http.request.builder.HttpRequestBuilder

object GetAssetInfoRequest  {
  val curFilter  = Seq ("USD", "XBT", "EUR", "GBP", "JPY","CAD","AUD","ETH","CHF")

  val getAssetInfo: HttpRequestBuilder = http(session => "Get Assets Info")
    .get(krakenURL + "/Assets")
    .header(name = "content-type", value = "application/x-www-form-urlencoded")
    .header(name = "User-Agent", value  = "Gatling")
    .queryParam("asset",curFilter.mkString(","))
    .queryParam("aclass", "currency")
    .check(status is 200)

}
