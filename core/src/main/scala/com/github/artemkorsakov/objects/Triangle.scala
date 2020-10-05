package com.github.artemkorsakov.objects

class Triangle {

}

/*
package com.github.artemkorsakov.figure;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.awt.*;
import java.util.Arrays;

/**
 * <a href="https://en.wikipedia.org/wiki/Triangle">Triangle</a>
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Triangle {
    private Point point1 = new Point(0, 0);
    private Point point2 = new Point(0, 0);
    private Point point3 = new Point(0, 0);

    public Triangle(String row) {
        int[] points = Arrays.stream(row.split(",")).mapToInt(Integer::parseInt).toArray();
        if (points.length != 6) {
            return;
        }

        point1 = new Point(points[0], points[1]);
        point2 = new Point(points[2], points[3]);
        point3 = new Point(points[4], points[5]);
    }

    public static boolean isRightTriangle(Point point1, Point point2) {
        if (point1.equals(point2) || point1.equals(new Point(0, 0)) || point2.equals(new Point(0, 0))) {
            return false;
        }

        double first = Math.sqrt(Math.pow(point1.x, 2) + Math.pow(point1.y, 2));
        double second = Math.sqrt(Math.pow(point2.x, 2) + Math.pow(point2.y, 2));
        double third = Math.sqrt(Math.pow(point1.x - point2.x, 2) + Math.pow(point1.y - point2.y, 2));
        double max = Math.max(first, Math.max(second, third));
        double diff = Math.abs(2 * Math.pow(max, 2) - Math.pow(first, 2) - Math.pow(second, 2) - Math.pow(third, 2));
        return diff < 1E-10;
    }

    public PointOnTriangleType getPointOnTriangleType(Point point) {
        int first = (point1.x - point.x) * (point2.y - point1.y) - (point2.x - point1.x) * (point1.y - point.y);
        int second = (point2.x - point.x) * (point3.y - point2.y) - (point3.x - point2.x) * (point2.y - point.y);
        int third = (point3.x - point.x) * (point1.y - point3.y) - (point1.x - point3.x) * (point3.y - point.y);

        if (first == 0 || second == 0 || third == 0) {
            return PointOnTriangleType.ON_THE_SIDE;
        }

        if (first < 0 && second < 0 && third < 0 || first > 0 && second > 0 && third > 0) {
            return PointOnTriangleType.INSIDE;
        }

        return PointOnTriangleType.OUTSIDE;
    }

    /**
     * Is zero point inside?
     */
    public boolean isZeroPointInside() {
        return getPointOnTriangleType(new Point(0, 0)).equals(PointOnTriangleType.INSIDE);
    }

    public enum PointOnTriangleType {
        INSIDE,
        OUTSIDE,
        ON_THE_SIDE
    }
}

 */
