package bot
import services.BotService

object BotObject extends App {

  val botServ = new BotService
  botServ.init()

}
