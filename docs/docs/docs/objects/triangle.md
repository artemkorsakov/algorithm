---
layout: docs
title: "Triangle"
realization_link: ../realization/objects/triangle.html
---

## {{page.title}}

### getPointOnTriangleType
Returns the position of a point relative to a triangle: inside, outside, on the side.

**Algorithm**

**Complexity** 
     
[**Algorithm realization**]({{ page.realization_link }}{{ "#getPointOnTriangleType" | downcase }})

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
     
[**Algorithm realization**]({{ page.realization_link }}{{ "#isZeroPointInside" | downcase }})

**Sources** 

**Using**
```scala mdoc
import com.github.artemkorsakov.objects.Triangle
Triangle((-340, 495), (-153, -910), (835, -947)).isZeroPointInside
Triangle((-175, 41), (-421, -714), (574, -645)).isZeroPointInside
```

---
