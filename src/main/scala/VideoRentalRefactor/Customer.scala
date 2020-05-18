package VideoRentalRefactor

import scala.collection.mutable.ListBuffer

class Customer(val name: String) {
  var rentals: ListBuffer[Rental] = ListBuffer()

  def addRental(rental: Rental) = { rentals += rental }

  def renderTextStatement = {
    "Rental Record for " + name + "\n" +
    this.rentals.map(rental => {
      "\t" + rental.movie.title + "\t" + rental.amount() + "\n"
    }).mkString("") +
    "Amount owed is " + totalAmount + "\n" +
    "You earned "  + totalPoints + " frequent renter points"
  }

  private def totalPoints = this.rentals.map(_.points()).sum

  private def totalAmount = this.rentals.map(_.amount()).sum
}
