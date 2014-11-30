package domain

import play.api.libs.json._

case class Location(lon: Double, lat: Double)

object Location {

  implicit val locationFormat = Json.format[Location]
}