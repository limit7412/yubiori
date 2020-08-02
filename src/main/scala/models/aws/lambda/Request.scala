package models.aws.lambda

import scala.beans.BeanProperty

class Request(
    @BeanProperty var key1: String,
    @BeanProperty var key2: String,
    @BeanProperty var key3: String
) {
  def this() = this("", "", "")

  override def toString: String = s"Request($key1, $key2, $key3)"
}

class ApiGatewayRequest(
    @BeanProperty var body: String
) {
  def this() = this("")

  override def toString: String = s"Request($body)"
}
