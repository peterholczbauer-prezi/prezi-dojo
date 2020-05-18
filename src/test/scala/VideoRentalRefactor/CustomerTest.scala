package VideoRentalRefactor

import org.specs2.mutable._

class CustomerTest extends SpecificationWithJUnit{
  "statement" should {
    "generate statement for children's movie" in {
      val customer = new Customer("Joe")

      customer.addRental(new Rental(new ChildrensMovie("Rambo 1"), 1))

      customer.renderTextStatement === "Rental Record for Joe\n\tRambo 1	1.5\nAmount owed is 1.5\nYou earned 1 frequent renter points"
    }

    "generate statement for two rentals for a day" in {
      val customer = new Customer("Joe")

      customer.addRental(new Rental(new ChildrensMovie("Rambo 1"), 1))
      customer.addRental(new Rental(new NewReleaseMovie("Rambo 2"), 1))

      customer.renderTextStatement === "Rental Record for Joe\n\tRambo 1	1.5\n\tRambo 2	3.0\nAmount owed is 4.5\nYou earned 2 frequent renter points"
    }

    "generate statement for two rentals with different length" in {
      val customer = new Customer("Joe")

      customer.addRental(new Rental(new ChildrensMovie("Rambo 1"), 1))
      customer.addRental(new Rental(new NewReleaseMovie("Rambo 2"), 2))

      customer.renderTextStatement === "Rental Record for Joe\n\tRambo 1	1.5\n\tRambo 2	6.0\nAmount owed is 7.5\nYou earned 3 frequent renter points"
    }

    "generate statement for three rentals with different price codes" in {
      val customer = new Customer("Joe")

      customer.addRental(new Rental(new ChildrensMovie("Rambo 1"), 1))
      customer.addRental(new Rental(new NewReleaseMovie("Rambo 2"), 2))
      customer.addRental(new Rental(new RegularMovie("Rambo 3"), 1))

      customer.renderTextStatement === "Rental Record for Joe\n\tRambo 1	1.5\n\tRambo 2	6.0\n\tRambo 3	2.0\nAmount owed is 9.5\nYou earned 4 frequent renter points"
    }
  }
}
