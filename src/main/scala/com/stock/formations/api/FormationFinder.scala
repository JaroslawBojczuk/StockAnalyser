package com.stock.formations.api

import com.stock.commons.TickerData

trait FormationFinder[A <: Formation] {
  def apply(data: Seq[TickerData]): Option[A]
}
