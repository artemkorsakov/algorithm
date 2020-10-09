package com.github.artemkorsakov.objects

import com.github.artemkorsakov.objects.Triangle.PointOnTriangleType

/** <a href="https://en.wikipedia.org/wiki/Triangle">Triangle</a> */
case class Triangle(point1: (Int, Int), point2: (Int, Int), point3: (Int, Int)) {
  def getPointOnTriangleType(point: (Int, Int)): PointOnTriangleType.Value = {
    val first  = (point1._1 - point._1) * (point2._2 - point1._2) - (point2._1 - point1._1) * (point1._2 - point._2)
    val second = (point2._1 - point._1) * (point3._2 - point2._2) - (point3._1 - point2._1) * (point2._2 - point._2)
    val third  = (point3._1 - point._1) * (point1._2 - point3._2) - (point1._1 - point3._1) * (point3._2 - point._2)
    if (first == 0 || second == 0 || third == 0)
      PointOnTriangleType.OnTheSide
    else if (first < 0 && second < 0 && third < 0 || first > 0 && second > 0 && third > 0)
      PointOnTriangleType.Inside
    else
      PointOnTriangleType.Outside
  }

  /** Is zero point inside? */
  def isZeroPointInside: Boolean =
    getPointOnTriangleType((0, 0)).equals(PointOnTriangleType.Inside)
}

object Triangle {
  object PointOnTriangleType extends Enumeration {
    val Inside, Outside, OnTheSide = Value
  }
}
