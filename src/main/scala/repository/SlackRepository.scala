package repository

import models.slack

import com.softwaremill.sttp._

import scala.concurrent.duration._

object Slack {
  def sendAttachments(
      webhook: String,
      payload: slack.Payload
  ): String = {
    val request = sttp
      .method(Method.POST, uri"$webhook")
      .body(payload.toString())
    val response = request.send()

    ""
  }
}
