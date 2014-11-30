package domain

import play.api.libs.json._

case class UserId(value: Long)

object UserId {

  implicit val userIdFormat = Json.format[UserId]
}