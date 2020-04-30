package Main

object GameOfLife {
  def evolve(state: (Int, Int) => Boolean): (Int,Int) => Boolean = (x: Int, y:Int) => {
    (neighbourCount(x, y)(state) == 2 && state(x, y)) || neighbourCount(x, y)(state) == 3
  }

  private def neighbourCount(x: Int, y: Int)(state: (Int, Int) => Boolean) = {
    List(
      (-1,-1), (0, -1), (1, -1),
      (-1, 0),          (1,  0),
      (-1, 1), (0,  1), (1,  1)
    ).map{
      case (dx, dy) =>
        if (state(x+dx,y+dy)) 1 else 0
    }.sum
  }
}
