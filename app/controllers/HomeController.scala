package controllers

import models._

import javax.inject._
import play.api._
import play.api.mvc._
import play.api.data.Form
import play.api.data.Forms._
import play.api.http.Writeable

@Singleton
class HomeController @Inject()(val controllerComponents: ControllerComponents) extends BaseController with play.api.i18n.I18nSupport {

  def index() = Action { implicit request: Request[AnyContent] =>


    Ok(views.html.index1())
  }

  def list(page: Int ) = Action { implicit request =>
    val limit: Int = 10
    val offset: Int = page* limit
    val listOfItems: List[Int] = (1 to 1000).toList
    val resultsPerPage = listOfItems.slice(offset, offset + limit)





    Ok("NUMBERS IS " + resultsPerPage)
  }

    def showPage(firstNumber: Int, secondNumber: Option[Int], thirdNumber: Option[Int]) = Action {


      // складывание параметров запроса и выведение на страницу суммы чисел из параметров
      val res: Int = secondNumber.flatMap { second =>
        thirdNumber
          .map(third => firstNumber + second + third)
          .orElse(Some(firstNumber + second))
      }.getOrElse {
        thirdNumber.fold(firstNumber)(third => firstNumber + third)
      }

      Ok("number is :" + res)
    }
}





