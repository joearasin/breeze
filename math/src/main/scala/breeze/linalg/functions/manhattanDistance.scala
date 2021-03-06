package breeze.linalg.functions

import breeze.generic.UFunc
import breeze.linalg._
import breeze.numerics.abs

/**
 * A Manhattan distance measure implementation between two points
 */
object manhattanDistance extends UFunc {

  implicit def manhattanDistanceFromZippedValues[T, U]
      (implicit zipImpl: zipValues.Impl2[T, U, ZippedValues[Double, Double]]): Impl2[T, U, Double] = {
    new Impl2[T, U, Double] {
      def apply(v: T, v2: U): Double = {
        var distance = 0.0
        zipValues(v, v2).foreach{ (a, b) =>
          distance += abs(a - b)
        }
        distance
      }
    }
  }
}
