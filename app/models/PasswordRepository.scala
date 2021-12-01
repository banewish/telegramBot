package models

import javax.inject._
import play.api.db.slick.DatabaseConfigProvider
import slick.jdbc.JdbcProfile

import scala.concurrent.{Future, ExecutionContext}


class PasswordRepository @Inject()(dbConfigProvider: DatabaseConfigProvider)(implicit ec: ExecutionContext) {

  private val dbConfig = dbConfigProvider.get[JdbcProfile]
  import controllers.HomeController
  import dbConfig._
  import profile.api._

  private class PasswordTable(tag: Tag) extends Table[PasswordHash](tag, "hashes") {

    def password_hash = column[String]("password_hash")

    def * = password_hash <> ((PasswordHash.apply _), PasswordHash.unapply _)
  }

  private val passwords = TableQuery[PasswordTable]


  def create(password_hash: String): Future[Int] = db.run {

    val queryForCreate =
    passwords.map(p => (p.password_hash)) += passwordHash(passwords.toString)

    queryForCreate
  }

  def list(): Future[Seq[PasswordHash]] = db.run {
    passwords.result

  }
  def delete() : Future[Int] = db.run {
    passwords.filter(p => p.password_hash === "509dc12b1b19acd95bb69c9276487837")
      .delete
  }


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