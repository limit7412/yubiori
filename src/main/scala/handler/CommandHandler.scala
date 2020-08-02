package handler

import models.aws.lambda
import models.slack

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
    val request = slack.SlashCommand.parse(input.body)
    val attachments = new slack.Attachments(
      title = "test",
      text = request.text
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
  }
}
