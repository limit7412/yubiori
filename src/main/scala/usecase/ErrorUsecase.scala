package usecase

import models.slack
import repository._

object Error {
  def notify(err: Exception): String = {
    val message = "エラーみたい…確認してみよっか"
    val user = sys.env("SLACK_ID")
    val attachment = new slack.Attachments(
      fallback = message,
      pretext = s"<@$user> $message",
      title = err.getMessage(),
      text = err.getStackTrace().toString(),
      color = "#EB4646",
      footer = "yubiori"
    )

    repository.Slack.sendAttachments(
      sys.env("ALERT_WEBHOOK_URL"),
      new slack.Payload()
    )

    "" // FIXME:
  }
}
