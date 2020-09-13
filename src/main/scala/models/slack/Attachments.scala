package models.slack

import scala.beans.BeanProperty
import org.json4s.jackson.JsonMethods._
import org.json4s.JsonDSL._

class Attachments(
    @BeanProperty var fallback: String = "",
    @BeanProperty var authorName: String = "",
    @BeanProperty var authorIcon: String = "",
    @BeanProperty var authorLink: String = "",
    @BeanProperty var title: String = "",
    @BeanProperty var titleLink: String = "",
    @BeanProperty var pretext: String = "",
    @BeanProperty var text: String = "",
    @BeanProperty var color: String = "",
    @BeanProperty var footer: String = "",
    @BeanProperty var footerIcon: String = ""
) {
  override def toString: String = {
    compact(
      render(
        ("fallback" -> fallback) ~
          ("author_name" -> authorName) ~
          ("author_icon" -> authorIcon) ~
          ("author_link" -> authorLink) ~
          ("title" -> title) ~
          ("titleLink" -> titleLink) ~
          ("pretext" -> pretext) ~
          ("text" -> text) ~
          ("color" -> color) ~
          ("author_name" -> authorName) ~
          ("footer" -> footer) ~
          ("footer_icon" -> footerIcon)
      )
    )
  }
}

class Payload(
    @BeanProperty var attachments: Seq[Attachments] = Seq.empty
) {
  override def toString: String = {
    compact(
      render(
        (
          "attachments" -> attachments
            .map { item =>
              ("fallback" -> item.fallback) ~
                ("author_name" -> item.authorName) ~
                ("author_icon" -> item.authorIcon) ~
                ("author_link" -> item.authorLink) ~
                ("title" -> item.title) ~
                ("titleLink" -> item.titleLink) ~
                ("pretext" -> item.pretext) ~
                ("text" -> item.text) ~
                ("color" -> item.color) ~
                ("author_name" -> item.authorName) ~
                ("footer" -> item.footer) ~
                ("footer_icon" -> item.footerIcon)
            }
        )
      )
    )
  }
}
