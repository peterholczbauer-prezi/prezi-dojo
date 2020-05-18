package VideoRentalRefactor

class Rental(val movie: Movie, val priceCode: PriceCode, val daysRented: Integer) {

  def amount() : Double = {
    priceCode match {
      case PriceCode.Regular => {
        if (daysRented > 2) {
          2 + (daysRented - 2) * 1.5
        } else {
          2
        }
      }
      case PriceCode.NewRelease => {
        daysRented * 3
      }
      case PriceCode.Childrens => {
        if (daysRented > 3) {
          1.5 + (daysRented - 3) * 1.5
        } else {
          1.5
        }
      }
    }
  }

  def frequentRenterPoints(): Int = if (priceCode == PriceCode.NewRelease && daysRented > 1) 2 else 1
}

