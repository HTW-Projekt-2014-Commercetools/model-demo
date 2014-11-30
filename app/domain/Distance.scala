package domain

import play.api.libs.json._

case class Distance(value: Int)

object Distance {

  implicit val distanceFormat = Json.format[Distance]
}