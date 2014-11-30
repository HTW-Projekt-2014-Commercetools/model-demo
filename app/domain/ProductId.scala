package domain

import play.api.libs.json._

case class ProductId(value: Long)

object ProductId {

  implicit val productIdFormat = Json.format[ProductId]
}