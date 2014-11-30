package controllers

import play.api._
import play.api.mvc._
import play.api.data.Form
import play.api.data.Forms._
import play.api.libs.json.Json
import play.api.data.format.Formats._
import models._
import domain._

object Offers extends Controller {

  def index = Action {
    Ok(views.html.offer(offersForm))
  }

  val offersForm: Form[OfferData] = Form {
  	mapping(
      // "userId" -> mapping(
      //   "value" -> of[Long]
      //   )(UserId.apply)(UserId.unapply),
      "userId" -> nonEmptyText,
      "productId" -> nonEmptyText,
      "tags" -> nonEmptyText,
      "lon" -> of[Double],
      "lat" -> of[Double],
      "price" -> of[Double]
  	)(OfferData.apply)(OfferData.unapply)
  }

  def addOffer = Action { implicit request =>
  	offersForm.bindFromRequest.fold(
      formWithErrors => {
        // binding failure, you retrieve the form containing errors:
        BadRequest(views.html.offer(formWithErrors))
      },
      offerData => {
        /* binding success, you get the actual value. */
        val offer = Offer(offerData.userId, offerData.productId, offerData.tags,
          offerData.lon, offerData.lat, offerData.price)
        DB.save(offer)
        Redirect(routes.Offers.getOffers)
      }
    )
  }

  def getOffers = Action {
  	val offers = DB.query[Offer].fetch()
  	Ok(Json.toJson(offers))
  }
}