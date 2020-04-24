package Main

object GameOfLife {
  def evolve(state: (Int, Int) => Boolean): (Int,Int) => Boolean = (_: Int, _:Int) => {
    (neighbourCount(state) == 2 && state(0, 0)) || neighbourCount(state) == 3
  }

  private def neighbourCount(state: (Int, Int) => Boolean) = {
    List(
      state(-1,-1), state(0, -1), state(1, -1),
      state(-1, 0),               state(1,  0),
      state(-1, 1), state(0,  1), state(1,  1)
    ).map(if(_) 1 else 0).sum
  }
}
