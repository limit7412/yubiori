package models.slack

import scala.beans.BeanProperty
import java.net.URLDecoder

case class SlashCommand(
    @BeanProperty var token: String = "",
    @BeanProperty var teamID: String = "",
    @BeanProperty var teamDomain: String = "",
    @BeanProperty var channelID: String = "",
    @BeanProperty var channelName: String = "",
    @BeanProperty var userID: String = "",
    @BeanProperty var userName: String = "",
    @BeanProperty var command: String = "",
    @BeanProperty var text: Seq[String] = Seq.empty,
    @BeanProperty var responseURL: String = "",
    @BeanProperty var triggerID: String = ""
)

object SlashCommand {
  def parse(input: String): SlashCommand = {
    val list = input
      .split('&')
      .map(item => {
        val kv = item.split('=')
        kv.size match {
          case 1 => Map(kv(0) -> "")
          case _ => Map(kv(0) -> URLDecoder.decode(kv(1), "UTF-8"))
        }
      })
      .reduceLeft(_ ++ _)

    new SlashCommand(
      list("token"),
      list("team_id"),
      list("team_domain"),
      list("channel_id"),
      list("channel_name"),
      list("user_id"),
      list("user_name"),
      list("command"),
      list("text").split(" ").toList,
      list("response_url"),
      list("trigger_id")
    )
  }
}
