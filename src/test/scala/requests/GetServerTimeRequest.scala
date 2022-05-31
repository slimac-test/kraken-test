package requests

import config.Configuration.krakenURL
import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.http.request.builder.HttpRequestBuilder

object GetServerTimeRequest {
  val getServerTime: HttpRequestBuilder = http(session => "Get Server Time")
    .get(krakenURL + "/Time")
    .header(name = "content-type", value = "application/json")
    .check(status is 200)
    .check(jsonPath("$.result.unixtime").findAll.saveAs("serverunixtime"))
}