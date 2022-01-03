package bot.services



import scala.concurrent.{Await, Future}
import scala.concurrent.duration.Duration
import bot.ChatBotClass

import scala.concurrent.{Await, Future}



  class BotService {
  val bot = new ChatBotClass("5035168446:AAGn5nbEfvJUI91rUOEnMs_fSO2JebftoTM")

  def init(): Future[Unit] = bot.run()

}
//  bot.shutdown() // initiate shutdown
// Wait for the bot end-of-life