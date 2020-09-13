package repository

import models.slack

import sttp.client._
import scala.concurrent.duration._

object Slack {
  def sendAttachments(
      webhook: String,
      payload: slack.Payload
  ): String = {
    implicit val backend = HttpURLConnectionBackend()
    val res = basicRequest
      .body(payload.toString())
      .post(uri"$webhook")
      .send()

    res.body.toString()
  }
}
