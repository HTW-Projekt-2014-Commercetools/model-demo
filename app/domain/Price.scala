package domain

import play.api.libs.json._

case class Price(value: Double)

object Price {

  implicit val priceFormat = Json.format[Price]
}