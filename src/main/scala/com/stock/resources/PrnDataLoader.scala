package com.stock.resources

import java.io.File

import com.stock.commons.TickerData

import scala.io.Source

class PrnDataLoader extends DataLoader {
  override def load(shortcut: String): Seq[TickerData] = {
    val files = new File("src/main/resources/").listFiles.filter(_.getName.endsWith(".prn")).toSeq
    for {
      file <- files
      ticker <- loadTickerFromFile(shortcut, file.getPath)
    } yield ticker
  }

  private def loadTickerFromFile(shortcut: String, filepath: String): Seq[TickerData] = {
    val lines: Iterator[String] = Source.fromFile(filepath).getLines()
    val all = lines.toList.flatMap(element => {
      val split = element.split(",")
      try {
        Some(TickerData(split(0), split(1), BigDecimal(split(2)), BigDecimal(split(3)), BigDecimal(split(4)), BigDecimal(split(5)), BigDecimal(split(6))))
      } catch {
        case _: Throwable => None
      }
    })
    all.filter(ticker => ticker.shortcut.equals(shortcut))
  }
}
