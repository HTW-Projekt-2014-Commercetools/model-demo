package models

import play.api.libs.json._
import domain.UserId

case class Offer(
	uid: String,
	pid: String,
	tags: String,
	// location: Location,
	lon: Double,
	lat: Double,
	price: Double)

object Offer {

  implicit val offerFormat = Json.format[Offer]
}