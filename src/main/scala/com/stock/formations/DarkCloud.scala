package com.stock.formations

import com.stock.commons.TickerData
import com.stock.formations.api.{Formation, FormationFinder}

case class DarkCloud(t1: TickerData, t2: TickerData) extends Formation {
  override def toString: String = {
    s""">>>Dark Cloud<<<
       |$t1
        |$t2
        |-------------""".stripMargin
  }
}

object DarkCloudFinder extends FormationFinder[DarkCloud] {
  def apply(tickerData: Seq[TickerData]): Option[DarkCloud] = {

    val array = tickerData.toArray[TickerData]
    val t1 = array(0)
    val t2 = array(1)

    if (t1.close > t1.open && t2.open > t2.close && t2.open > t1.max && t2.close < (t1.open + t2.close) / 2.0) {
      Some(DarkCloud(t1, t2))
    } else {
      None
    }
  }

}