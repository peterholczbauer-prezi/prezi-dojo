package VideoRentalRefactor

object PricingStrategy {
  case object Regular extends PricingStrategy {
    override val value = 0

    override def amount(daysRented: Int): Double =
      if (daysRented > 2) 2 + (daysRented - 2) * 1.5 else 2

  }

  case object NewRelease extends PricingStrategy {
    override val value = 1

    override def amount(daysRented: Int): Double =
      daysRented * 3

    override def frequentRenterPoints(daysRented: Int): Int =
      if(daysRented > 1) 2 else super.frequentRenterPoints(daysRented)
  }

  case object Childrens extends PricingStrategy {
    override val value = 2

    override def amount(daysRented: Int): Double =
      if (daysRented > 3) 1.5 + (daysRented - 3) * 1.5 else 1.5

  }
}

sealed trait PricingStrategy {
  val value: Integer

  def amount(daysRented: Int): Double
  def frequentRenterPoints(daysRented: Int): Int = 1
}
