package com.stock

import com.stock.formations.{DarkCloudFinder, HammerFinder}
import com.stock.logging.HasLogger
import com.stock.resources.PrnDataLoader

object Launcher extends HasLogger {

  val dataLoader = new PrnDataLoader

  def main(args: Array[String]) {

    val arctic = dataLoader.load("GROCLIN")

    arctic.sliding(2).flatMap(DarkCloudFinder(_)).foreach(println)
    arctic.sliding(2).flatMap(HammerFinder(_)).foreach(println)

  }

}
