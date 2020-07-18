package handler

import models.aws.lambda.runtime

import com.amazonaws.services.lambda.runtime.{Context, RequestHandler}
import org.apache.logging.log4j.{LogManager, Logger}

import scala.jdk.CollectionConverters._

class Notify extends RequestHandler[runtime.Request, runtime.Response] {

  val logger: Logger = LogManager.getLogger(getClass)

  def handleRequest(
      input: runtime.Request,
      context: Context
  ): runtime.Response = {
    logger.info(s"Received a request: $input")
    runtime.Response("たべるんご！", input)
  }
}
