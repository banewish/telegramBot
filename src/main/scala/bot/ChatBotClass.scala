package bot
import akka.actor.ActorSystem
import cats.instances.future._
import cats.syntax.functor._
import com.bot4s.telegram.api.RequestHandler
import com.bot4s.telegram.api.declarative.{Action, Commands, RegexCommands}
import com.bot4s.telegram.clients.{AkkaHttpClient, FutureSttpClient, ScalajHttpClient}
import com.bot4s.telegram.future.{Polling, TelegramBot}
import com.bot4s.telegram.methods.SendMessage
import com.bot4s.telegram.models.{ChatId, Message}


import scala.util.Try
import scala.concurrent.Future


class ChatBotClass(val token: String) extends TelegramBot
  with Polling
  with Commands[Future] {


  val myId = 619263245L
  implicit val actorSystem: ActorSystem = ActorSystem()
  override val client: RequestHandler[Future] = new AkkaHttpClient(token)



  override def receiveMessage(msg: Message): Future[Unit] =
    msg.text.fold(Future.successful(())) {  text =>
      request(
        SendMessage(ChatId(myId), text)).void.flatMap(_ =>
        request(
          SendMessage(msg.chat.id, resultForUser)).void)
      }


  val resultForUser = ("Мы отправили ваше сообщение")




  // Int(n) extractor
  object Int {
    def unapply(s: String): Option[Int] = Try(s.toInt).toOption
  }

}