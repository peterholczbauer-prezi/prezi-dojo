package VideoRentalRefactor

abstract class Movie(val title: String) {
  def amount(daysRented: Int): Double

  def points(daysRented: Int) = {
    1
  }
}

class RegularMovie(title: String) extends Movie(title) {
  override def amount(daysRented: Int) = {
    if (daysRented > 2) {
      2 + (daysRented - 2) * 1.5
    } else {
      2.0
    }
  }
}

class NewReleaseMovie(title: String) extends Movie(title) {
  override def amount(daysRented: Int) = {
    daysRented * 3.0
  }

  override def points(daysRented: Int): Int = if (daysRented > 1) 2 else super.points(daysRented)
}

class ChildrensMovie(title: String) extends Movie(title) {
  override def amount(daysRented: Int) = {
    if (daysRented > 3) {
      1.5 + (daysRented - 3) * 1.5
    } else {
      1.5
    }
  }
}
