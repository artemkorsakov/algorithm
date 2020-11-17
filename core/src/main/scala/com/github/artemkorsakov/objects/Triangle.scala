package com.github.artemkorsakov.objects

import com.github.artemkorsakov.objects.Triangle._

/** <a href="https://en.wikipedia.org/wiki/Triangle">Triangle</a> */
case class Triangle(point1: (Int, Int), point2: (Int, Int), point3: (Int, Int)) {
  def getPointOnTriangleType(point: (Int, Int)): PointOnTriangleType = {
    val first  = (point1._1 - point._1) * (point2._2 - point1._2) - (point2._1 - point1._1) * (point1._2 - point._2)
    val second = (point2._1 - point._1) * (point3._2 - point2._2) - (point3._1 - point2._1) * (point2._2 - point._2)
    val third  = (point3._1 - point._1) * (point1._2 - point3._2) - (point1._1 - point3._1) * (point3._2 - point._2)
    if (first == 0 || second == 0 || third == 0)
      OnTheSide
    else if (first < 0 && second < 0 && third < 0 || first > 0 && second > 0 && third > 0)
      Inside
    else
      Outside
  }

  /** Is zero point inside? */
  def isZeroPointInside: Boolean =
    getPointOnTriangleType((0, 0)).equals(Inside)
}

object Triangle {
  sealed trait PointOnTriangleType
  case object Inside    extends PointOnTriangleType
  case object Outside   extends PointOnTriangleType
  case object OnTheSide extends PointOnTriangleType
}
