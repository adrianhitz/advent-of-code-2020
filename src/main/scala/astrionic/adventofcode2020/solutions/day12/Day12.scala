package astrionic.adventofcode2020.solutions.day12

import astrionic.adventofcode2020.framework.AdventSolution

//noinspection DuplicatedCode
object Day12 extends AdventSolution {

  override def solvePart1(input: String): String = {
    val cmds: List[Command] = parseInput(input)
    val startingPos = (0, 0)
    val ship = cmds.foldLeft(Ship(startingPos))((s: Ship, cmd: Command) => {
      s.movePart1(cmd)
    })
    ship.manhattanDistanceTo(startingPos).toString
  }

  override def solvePart2(input: String): String = {
    val cmds: List[Command] = parseInput(input)
    val startingPos = (0, 0)
    val waypointStartingPos = (10, 1)
    val ship = cmds.foldLeft(Ship(startingPos, waypointStartingPos))((s: Ship, cmd: Command) => {
      s.movePart2(cmd)
    })
    ship.manhattanDistanceTo(startingPos).toString
  }

  private def parseInput(input: String): List[Command] = input
    .split('\n')
    .map(line => {
      val action = line(0) match {
        case 'N' => Action.N
        case 'E' => Action.E
        case 'S' => Action.S
        case 'W' => Action.W
        case 'L' => Action.L
        case 'R' => Action.R
        case 'F' => Action.F
        case _   => throw new Exception("Invalid action")
      }
      val value = line.substring(1).toInt
      Command(action, value)
    })
    .toList
}
