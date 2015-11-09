package com.stock.logging

import org.slf4j.LoggerFactory


trait HasLogger {

  val log = LoggerFactory.getLogger(super.getClass)

  def info(msg: String) = log.info(msg)
  def debug(msg: String) = log.debug(msg)
  def error(msg: String) = log.error(msg)

}
