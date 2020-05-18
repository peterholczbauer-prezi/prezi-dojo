package VideoRentalRefactor

trait View {
  def render(rentalRecord: RentalRecord): String
}

case class StringView() extends View {
  def render(rentalRecord: RentalRecord): String = {
    "Rental Record for " + rentalRecord.customer.name + "\n" +
    rentalRecord.rentals.map(rental => {
      "\t" + rental.movie.title + "\t" + rental.amount() + "\n"
    }).mkString("") +
    "Amount owed is " + rentalRecord.totalAmount + "\n" +
    "You earned "  + rentalRecord.frequentRenterPoints + " frequent renter points"
  }
}
