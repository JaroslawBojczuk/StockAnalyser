package com.stock.commons

case class TickerData(shortcut: String, date: String, open: BigDecimal, max: BigDecimal, min: BigDecimal, close: BigDecimal, volume: BigDecimal) {
  override def toString = {
    s"""$shortcut - $date
        | Close: $close
        | Open:  $open
        | Min:   $min
        | Max:   $max
        | Vol:   $volume""".stripMargin
  }
}
