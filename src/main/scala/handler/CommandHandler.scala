package handler

import models.aws.lambda
import models.slack
import usecase._

import com.amazonaws.services.lambda.runtime.{Context, RequestHandler}
import org.apache.logging.log4j.{LogManager, Logger}

import scala.jdk.CollectionConverters._

class Command
    extends RequestHandler[
      lambda.ApiGatewayRequest,
      lambda.ApiGatewayResponse
    ] {

  def handleRequest(
      input: lambda.ApiGatewayRequest,
      context: Context
  ): lambda.ApiGatewayResponse = {
    try {
      val request = slack.SlashCommand.parse(input.body)
      val txt = request.text.mkString(",")
      val attachments = new slack.Attachments(
        title = "test",
        text = s"input txt: $txt"
      )
      val headers = Map(
        "x-custom-response-header" -> "my custom response header value"
      )
      lambda.ApiGatewayResponse(
        200,
        attachments.toString(),
        headers.asJava,
        true
      )
    } catch {
      case e: Exception => {
        usecase.Error.notify(e)
        lambda.ApiGatewayResponse(
          500,
          "internal backend error",
          Map().asJava,
          true
        )
      }
    }

  }
}
