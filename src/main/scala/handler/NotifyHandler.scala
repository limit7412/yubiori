package handler

import models.aws.lambda

import com.amazonaws.services.lambda.runtime.{Context, RequestHandler}
import org.apache.logging.log4j.{LogManager, Logger}

import scala.jdk.CollectionConverters._

class Notify extends RequestHandler[lambda.Request, lambda.Response] {

  val logger: Logger = LogManager.getLogger(getClass)

  def handleRequest(
      input: lambda.Request,
      context: Context
  ): lambda.Response = {
    logger.info(s"Received a request: $input")
    lambda.Response("たべるんご！", input)
  }
}
