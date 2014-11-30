package models

import play.api.libs.json._

case class Demand(
	uid: String,
	tags: String,
	// location: Location,
	lon: Double,
	lat: Double,
	distance: Int,
	priceMin: Double,
	priceMax: Double)

object Demand {

  implicit val demandFormat = Json.format[Demand]
}