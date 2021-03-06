package usecase

import models.slack
import repository._

object Error {
  def notify(err: Exception): Unit = {
    val message = "エラーみたい…確認してみよっか"
    val user = sys.env("SLACK_ID")
    val attachment = new slack.Attachments(
      fallback = message,
      pretext = s"<@$user> $message",
      title = err.getMessage(),
      text = err.getStackTrace().map(_.toString()).mkString("\n"),
      color = "#EB4646",
      footer = "yubiori"
    )

    repository.Slack.sendAttachments(
      sys.env("ALERT_WEBHOOK_URL"),
      new slack.Payload(List(attachment))
    )
  }
}
