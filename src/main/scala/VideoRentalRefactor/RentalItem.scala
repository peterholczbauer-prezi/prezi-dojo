package VideoRentalRefactor

class RentalItem(val movie: Movie, val strategy: PricingStrategy, val daysRented: Integer) {
  val amount : Double = strategy.amount(daysRented)
  val frequentRenterPoints: Int = strategy.frequentRenterPoints(daysRented)
}

