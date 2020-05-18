package VideoRentalRefactor

import scala.collection.mutable.ListBuffer

case class RentalRecord(customer: Customer) { // Bad Name
  private[this] val _rentals: ListBuffer[Rental] = ListBuffer()

  def rentals: List[Rental] = _rentals.toList

  def addRental(rental: Rental): Unit = { _rentals += rental }

  def totalAmount(): Double = this.rentals.map(_.amount()).sum
  def frequentRenterPoints(): Int = this.rentals.map(_.frequentRenterPoints()).sum

}
