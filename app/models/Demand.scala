package models

import play.api.libs.json._

case class Demand(
	userId: String,
	tags: String,
	lon: Double,
	lat: Double,
	radius: Int,
	priceMin: Double,
	priceMax: Double)

object Demand {

  implicit val demandFormat = Json.format[Demand]
}