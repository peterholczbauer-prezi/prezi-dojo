package VideoRentalRefactor

class Movie(val title: String, val priceCode: PriceCode) {

}

sealed trait PriceCode {
  val value: Integer
}

object PriceCode {
  case object Regular extends PriceCode {
    override val value = 0
  }

  case object NewRelease extends PriceCode {
    override val value = 1
  }

  case object Childrens extends PriceCode {
    override val value = 2
  }
}
