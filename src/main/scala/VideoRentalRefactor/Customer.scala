package VideoRentalRefactor

import scala.collection.mutable.ListBuffer

class Customer(val name: String) {
  var rentals: ListBuffer[Rental] = ListBuffer()

  def addRental(rental: Rental) = { rentals += rental }

  def statement = {
    var totalAmount:Double = 0
    var frequentRenterPoints:Integer = 0
    val rentals = this.rentals

    var result = "Rental Record for " + name + "\n"


    rentals.foreach(each => {

      var thisAmount:Double = 0

      each.movie.priceCode match {
        case PriceCode.Regular => {
          thisAmount += 2
          if (each.daysRented > 2) {
            thisAmount += (each.daysRented - 2) * 1.5
          }
        }
        case PriceCode.NewRelease => {
          thisAmount += each.daysRented * 3
        }
        case PriceCode.Childrens => {
          thisAmount += 1.5
          if (each.daysRented > 3) {
            thisAmount += (each.daysRented - 3) * 1.5
          }
        }
      }

      totalAmount += thisAmount

      frequentRenterPoints += 1

      if(each.movie.priceCode == PriceCode.NewRelease && each.daysRented > 1)
        frequentRenterPoints += 1

      result += "\t" + each.movie.title + "\t" + thisAmount + "\n"
    })

    result += "Amount owed is " + totalAmount + "\n"
    result += "You earned "  + frequentRenterPoints + " frequent renter points"

    result
  }
}
