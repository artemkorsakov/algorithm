---
layout: docsplus
title: "Triangle"
realization: objects/Triangle.scala
---

### getPointOnTriangleType
Returns the position of a point relative to a triangle: inside, outside, on the side.

**Algorithm**

**Complexity** 
     
**Sources** 
- [Triangle](https://en.wikipedia.org/wiki/Triangle)

**Using**
```scala mdoc
import com.github.artemkorsakov.objects.Triangle
Triangle((-340, 495), (-153, -910), (835, -947)).getPointOnTriangleType((0, 0))
Triangle((-175, 41), (-421, -714), (574, -645)).getPointOnTriangleType((0, 0))
Triangle((-175, 41), (-421, -714), (574, -645)).getPointOnTriangleType((-175, 41))
```

---

### isZeroPointInside
Is zero point inside the triangle?

**Algorithm**

**Complexity** 
     
**Sources** 

**Using**
```scala mdoc
import com.github.artemkorsakov.objects.Triangle
Triangle((-340, 495), (-153, -910), (835, -947)).isZeroPointInside
Triangle((-175, 41), (-421, -714), (574, -645)).isZeroPointInside
```

---
