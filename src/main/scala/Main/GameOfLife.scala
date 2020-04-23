package Main

object GameOfLife {
  def evolve(state: (Int, Int) => Boolean): (Int,Int) => Boolean = (_: Int, _:Int) => state(0, -1) && state(0, 1)

}
