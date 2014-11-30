package domain

case class DemandData(
	userId: String,
	tags: String,
	lon: Double,
	lat: Double,
	radius: Int,
	priceMin: Double,
	priceMax: Double)