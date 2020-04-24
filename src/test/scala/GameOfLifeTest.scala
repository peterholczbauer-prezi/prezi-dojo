import Main.GameOfLife
import org.specs2.mutable._

class GameOfLifeTest extends SpecificationWithJUnit {

  def fromLines(lines: List[String]) : (Int, Int) => Boolean = {
    (x:Int, y:Int) => { lines(y+1).charAt(x+1) == '*' }
  }

  "evolve" should {
    "empty world stays empty after being evolved" in {
      GameOfLife.evolve((_: Int, _: Int) => false)(0, 0) === false
    }

    "keep middle cell alive when we have 3 cells" in {
      GameOfLife.evolve((x: Int, _: Int) => x == 0)(0, 0) === true
    }

    "one lonely cell should die" in {
      GameOfLife.evolve((x: Int, y: Int) => (x, y) == (0, 0))(0, 0) === false
    }

    "cell with a singe neighbour dies" in {
      GameOfLife.evolve((x: Int, y: Int) => x == 0 && y >= 1)(0, 0) === false
    }

    "dead cell wont be spawned with two neighbours" in {
      val state = fromLines(List(
        ".*.",
        "...",
        ".*."
      ))

      GameOfLife.evolve(state)(0, 0) === false
    }

    "cell stays alive with two neighbours horizontally" in {
      val state = fromLines(List(
        "...",
        "***",
        "..."
      ))

      GameOfLife.evolve(state)(0, 0) === true
    }

    "cell stays alive with two neighbours right diagonal" in {
      val state = fromLines(List(
        "..*",
        ".*.",
        "*.."
      ))

      GameOfLife.evolve(state)(0, 0) === true
    }

    "cell stays alive with two neighbours left diagonal" in {
      val state = fromLines(List(
        "*..",
        ".*.",
        "..*"
      ))

      GameOfLife.evolve(state)(0, 0) === true
    }

    "cell stays alive with three neighbours left diagonal and up" in {
      val state = fromLines(List(
        "**.",
        ".*.",
        "..*"
      ))

      GameOfLife.evolve(state)(0, 0) === true
    }

    "cell spawns with three neighbours left diagonal and up" in {
      val state = fromLines(List(
        "**.",
        "...",
        "..*"
      ))

      GameOfLife.evolve(state)(0, 0) === true
    }
  }
}
