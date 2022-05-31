package requests

import config.Configuration.krakenURL
import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.http.request.builder.HttpRequestBuilder


object GetSystemStatusRequest {
  val getSystemStatus: HttpRequestBuilder = http(session => "Get System Status")
    .get(krakenURL + "/SystemStatus")
    .header(name = "content-type", value = "application/json")
    .check(status is 200)
    .check(jsonPath("$.result.status").is("online"))
}
