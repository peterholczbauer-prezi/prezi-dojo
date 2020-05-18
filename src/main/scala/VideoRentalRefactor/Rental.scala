package VideoRentalRefactor

import scala.collection.mutable.ListBuffer

case class Rental(customer: Customer) { // Bad Name
  private[this] val items: ListBuffer[RentalItem] = ListBuffer()

  def rentals: List[RentalItem] = items.toList

  def addItem(rental: RentalItem): Unit = { items += rental }

  def totalAmount(): Double = this.rentals.map(_.amount).sum
  def frequentRenterPoints(): Int = this.rentals.map(_.frequentRenterPoints).sum
}
