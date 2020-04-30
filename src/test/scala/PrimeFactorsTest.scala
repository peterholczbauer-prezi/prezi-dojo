import Main.PrimeFactors
import org.specs2.mutable._

class PrimeFactorsTest extends SpecificationWithJUnit {
  "factorize" should {
    val dataProvider = Map(
      1 -> List.empty,
      2 -> List(2),
      3 -> List(3),
      4 -> List(2, 2),
      5 -> List(5),
      6 -> List(2, 3),
      8 -> List(2, 2, 2),
      9 -> List(3, 3)

    )

    "one has no prime factors" in {
      dataProvider.forall { case (input, result) =>
        PrimeFactors.factorize(input) === result
      }
    }
  }
}
