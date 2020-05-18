package VideoRentalRefactor

trait View {
  def render(rentalRecord: Rental): String
}

case class StringView() extends View {
  def render(rental: Rental): String = {
    "Rental Record for " + rental.customer.name + "\n" +
    rental.rentals.map(rental => {
      "\t" + rental.movie.title + "\t" + rental.amount + "\n"
    }).mkString("") +
    "Amount owed is " + rental.totalAmount + "\n" +
    "You earned "  + rental.frequentRenterPoints + " frequent renter points"
  }
}
