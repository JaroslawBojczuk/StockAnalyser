package com.stock.formations

import com.stock.commons.TickerData
import com.stock.formations.api.{FormationFinder, Formation}

case class Hammer(tickerData: TickerData) extends Formation {
  override def toString: String = {
    s""">>>Hammer<<<
       |$tickerData
       |-------------""".stripMargin
  }
}


object HammerFinder extends FormationFinder[Hammer] {
  def apply(data: Seq[TickerData]): Option[Hammer] = {
    val tickerData = data(0)
    if (tickerData.close > tickerData.open && tickerData.min < tickerData.open && tickerData.close == tickerData.max) {
      Some(Hammer(tickerData))
    } else {
      None
    }
  }
}
