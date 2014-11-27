package controllers

import play.api._
import play.api.mvc._
import play.api.data.Form
import play.api.data.Forms._
import play.api.libs.json.Json
import play.api.data.format.Formats._
import models._
import domain._

object Demands extends Controller {

  def index = Action {
    Ok(views.html.demand(demandsForm))
  }

  val demandsForm: Form[DemandData] = Form {
  	mapping(
      "userId" -> nonEmptyText,
      "tags" -> nonEmptyText,
      "lon" -> of[Double],
      "lat" -> of[Double],
      "radius" -> number(min = 0),
      "priceMin" -> of[Double],
      "priceMax" -> of[Double]
  	)(DemandData.apply)(DemandData.unapply)
  }

  def addDemand = Action { implicit request =>
  	demandsForm.bindFromRequest.fold(
      formWithErrors => {
        // binding failure, you retrieve the form containing errors:
        BadRequest(views.html.demand(formWithErrors))
      },
      demandData => {
        /* binding success, you get the actual value. */
        val demand = Demand(demandData.userId, demandData.tags, demandData.lon,
          demandData.lat, demandData.radius, demandData.priceMin,
          demandData.priceMax)
        DB.save(demand)
        Redirect(routes.Demands.getDemands)
      }
    )
  }

  def getDemands = Action {
  	val demands = DB.query[Demand].fetch()
  	Ok(Json.toJson(demands))
  }
}