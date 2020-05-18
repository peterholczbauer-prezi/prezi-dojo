package VideoRentalRefactor

class Rental(val movie: Movie, val daysRented: Integer) {

  def amount() = {
    movie.amount(daysRented)
  }

  def points() = {
    movie.points(daysRented)
  }
}

