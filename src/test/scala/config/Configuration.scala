package config

object Configuration {
  val krakenURL: String = "https://api.kraken.com/0/public/"
  val users: Int = Integer.getInteger("users", 4).toInt
  val rampUp: Int  = Integer.getInteger("rampup", 4).toInt
  val maxDuration: Int = Integer.getInteger("maxdur", 5).toInt
}
