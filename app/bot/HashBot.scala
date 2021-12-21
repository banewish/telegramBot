package bot

import cats.instances.future._
import cats.syntax.functor._
import com.bot4s.telegram.api.RequestHandler
import com.bot4s.telegram.api.declarative.{Action, Commands, RegexCommands}
import com.bot4s.telegram.clients.{FutureSttpClient, ScalajHttpClient}
import com.bot4s.telegram.future.{Polling, TelegramBot}
import com.bot4s.telegram.methods.SendMessage
import com.bot4s.telegram.models.Message

import scala.util.Try
import scala.concurrent.Future


class HashBot(val token: String) extends TelegramBot
  with Polling
  with Commands[Future] {


   override val client: RequestHandler[Future] = new ScalajHttpClient(token)

  onCommand("hash") { implicit msg =>
    withArgs {
      case _ =>
        reply(passwordHash(msg.toString)).void
    }
  }



// method for hash
  def passwordHash(s: String): String = {
    import java.math.BigInteger
    import java.security.MessageDigest
    val md = MessageDigest.getInstance("MD5")
    val digest = md.digest(s.getBytes)
    val bigInt = new BigInteger(1, digest)
    val hashedString = bigInt.toString(16)
    hashedString
  }



  // Int(n) extractor
  object Int {
    def unapply(s: String): Option[Int] = Try(s.toInt).toOption
  }

}