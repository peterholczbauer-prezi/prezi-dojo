package VideoRentalRefactor

import org.specs2.mutable._

class CustomerTest extends SpecificationWithJUnit {
  val stringView: View = StringView()
  "statement" should {
    "generate statement for children's movie" in {
      val customer = Customer("Joe")
      val rental = Rental(customer)

      rental.addItem(new RentalItem(new Movie("Rambo 1"), PricingStrategy.Childrens, 1))

      stringView.render(rental) === "Rental Record for Joe\n\tRambo 1	1.5\nAmount owed is 1.5\nYou earned 1 frequent renter points"
    }

    "generate statement for two rentals for a day" in {
      val customer = Customer("Joe")
      val rental = Rental(customer)

      rental.addItem(new RentalItem(new Movie("Rambo 1"), PricingStrategy.Childrens, 1))
      rental.addItem(new RentalItem(new Movie("Rambo 2"), PricingStrategy.NewRelease, 1))

      stringView.render(rental) === "Rental Record for Joe\n\tRambo 1	1.5\n\tRambo 2	3.0\nAmount owed is 4.5\nYou earned 2 frequent renter points"
    }

    "generate statement for two rentals with different length" in {
      val customer = Customer("Joe")
      val rental = Rental(customer)

      rental.addItem(new RentalItem(new Movie("Rambo 1"), PricingStrategy.Childrens, 1))
      rental.addItem(new RentalItem(new Movie("Rambo 2"), PricingStrategy.NewRelease, 2))

      stringView.render(rental) === "Rental Record for Joe\n\tRambo 1	1.5\n\tRambo 2	6.0\nAmount owed is 7.5\nYou earned 3 frequent renter points"
    }

    "generate statement for three rentals with different price codes" in {
      val customer = Customer("Joe")
      val rental = Rental(customer)

      rental.addItem(new RentalItem(new Movie("Rambo 1"), PricingStrategy.Childrens, 1))
      rental.addItem(new RentalItem(new Movie("Rambo 2"), PricingStrategy.NewRelease, 2))
      rental.addItem(new RentalItem(new Movie("Rambo 3"), PricingStrategy.Regular, 1))

      stringView.render(rental) === "Rental Record for Joe\n\tRambo 1	1.5\n\tRambo 2	6.0\n\tRambo 3	2.0\nAmount owed is 9.5\nYou earned 4 frequent renter points"
    }
  }
}
