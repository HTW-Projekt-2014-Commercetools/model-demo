package domain

case class OfferData(
	userId: String,
	productId: String,
	tags: String,
	lon: Double,
	lat: Double,
	price: Double)