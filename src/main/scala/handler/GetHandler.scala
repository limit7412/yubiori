package handler

import models.aws.lambda.runtime

import com.amazonaws.services.lambda.runtime.{Context, RequestHandler}
import org.apache.logging.log4j.{LogManager, Logger}

import scala.jdk.CollectionConverters._

class Get extends RequestHandler[runtime.Request, runtime.ApiGatewayResponse] {

  def handleRequest(
      input: runtime.Request,
      context: Context
  ): runtime.ApiGatewayResponse = {
    val headers = Map(
      "x-custom-response-header" -> "my custom response header value"
    )
    runtime.ApiGatewayResponse(
      200,
      "こいつはりんごろう",
      headers.asJava,
      true
    )
  }
}
