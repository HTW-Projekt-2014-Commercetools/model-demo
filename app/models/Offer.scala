package models

import play.api.libs.json._

case class Offer(
	userId: String,
	productId: String,
	tags: String,
	lon: Double,
	lat: Double,
	price: Double)

object Offer {

  implicit val offerFormat = Json.format[Offer]
}