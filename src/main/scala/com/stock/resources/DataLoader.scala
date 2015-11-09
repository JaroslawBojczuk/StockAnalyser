package com.stock.resources

import com.stock.commons.TickerData

trait DataLoader {

  def load(shortcut: String): Seq[TickerData]

}
