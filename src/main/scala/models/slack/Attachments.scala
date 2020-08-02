package models.slack

import scala.beans.BeanProperty
import io.circe.Json._

class Attachments(
    @BeanProperty var fallback: String = "",
    @BeanProperty var authorName: String = "",
    @BeanProperty var authorIcon: String = "",
    @BeanProperty var authorLink: String = "",
    @BeanProperty var title: String = "",
    @BeanProperty var titleLink: String = "",
    @BeanProperty var text: String = "",
    @BeanProperty var footer: String = "",
    @BeanProperty var footerIcon: String = ""
) {
  override def toString: String = {
    val json = obj(
      "fallback" -> fromString(fallback),
      "author_name" -> fromString(authorName),
      "author_icon" -> fromString(authorIcon),
      "author_link" -> fromString(authorLink),
      "title" -> fromString(title),
      "titleLink" -> fromString(titleLink),
      "text" -> fromString(text),
      "author_name" -> fromString(authorName),
      "footer" -> fromString(footer),
      "footer_icon" -> fromString(footerIcon)
    )

    json.toString()
  }
}
