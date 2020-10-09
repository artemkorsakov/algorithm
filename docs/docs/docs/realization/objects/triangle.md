---
layout: docs
title: "Realization: Triangle"
parent_link: ../../objects/triangle.html
---

## {{page.title}}

Realizations for [Triangle]({{ page.parent_link }}).

### getPointOnTriangleType

[Algorithm]({{ page.parent_link }}{{ "#getPointOnTriangleType" | downcase }})

**Realization**
```scala
import com.github.artemkorsakov.objects.Triangle.PointOnTriangleType

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
}
```

---

### isZeroPointInside

[Algorithm]({{ page.parent_link }}{{ "#isZeroPointInside" | downcase }})

**Realization**
```scala
import com.github.artemkorsakov.objects.Triangle.PointOnTriangleType

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
```

---
