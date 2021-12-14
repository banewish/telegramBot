package services
import javax.inject.{Inject, Singleton}

import bot.RandomBot
import scala.concurrent.{Await, Future}
import scala.concurrent.duration.Duration

@Singleton
class BotService {
  val bot = new RandomBot("5035168446:AAGn5nbEfvJUI91rUOEnMs_fSO2JebftoTM")
  val eol = bot.run()
  println("Press [ENTER] to shutdown the bot, it may take a few seconds...")
  scala.io.StdIn.readLine()


  def init(): Future[Unit] = bot.run()
//  bot.shutdown() // initiate shutdown
  // Wait for the bot end-of-life

}
