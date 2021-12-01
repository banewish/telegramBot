package controllers

import com.google.inject.Inject
import models.{PasswordHash, PasswordRepository}

import scala.concurrent.Future

case class PasswordService @Inject()(repo: PasswordRepository) {

  def list(): Future[Seq[PasswordHash]] = repo.list()

  def create(password_hash: String): Future[Int] = repo.create(password_hash: String)

  def delete(): Future[Int] = repo.delete()




  def passwordHash(s: String): String = {
    import java.security.MessageDigest
    import java.math.BigInteger
    val md = MessageDigest.getInstance("MD5")
    val digest = md.digest(s.getBytes)
    val bigInt = new BigInteger(1, digest)
    val hashedString = bigInt.toString(16)
    hashedString
  }
}
