package com.vulcanos.weatherprediction.util;

import org.locationtech.jts.algorithm.locate.SimplePointInAreaLocator;
import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.GeometryFactory;
import org.locationtech.jts.geom.Polygon;


public class Geometry {

    /**
     * Tolerance for working with loss of floating point precision.
     */
    public static final double TOLERANCE = 1e-9;

    /**
     * Determines if the specified points are collinear.
     * <p>Three points are collinear, if slope of any two pairs of points is same.</p>
     *
     * @param pointA the first point.
     * @param pointB the second point.
     * @param pointC the third point.
     * @return <code>true</code> if the specified points are collinear, <code>false</code> otherwise.
     */
    public static boolean areCollinear(Coordinate pointA, Coordinate pointB, Coordinate pointC) {
        final double firstPair = (pointC.getY() - pointB.getY()) * (pointB.getX() - pointA.getX());
        final double secondPair = (pointB.getY() - pointA.getY()) * (pointC.getX() - pointB.getX());
        return Math.abs(firstPair - secondPair) <= TOLERANCE;
    }

    /**
     * Determines if <code>pointToCheck</code> is inside the triangle formed by the other three specified points.
     *
     * @return <tt>true</tt> if the given point is inside the triangle formed by the other points, <code>false</code> otherwise.
     */
    public static boolean isPointInsideTriangle(Coordinate pointA, Coordinate pointB, Coordinate pointC, Coordinate pointToCheck) {
        Coordinate[] coordinates = new Coordinate[4];
        coordinates[0] = pointA;
        coordinates[1] = pointB;
        coordinates[2] = pointC;
        coordinates[3] = pointA; // To close triangle

        Polygon triangle = new GeometryFactory().createPolygon(coordinates);
        return SimplePointInAreaLocator.containsPointInPolygon(pointToCheck, triangle);
    }

    /**
     * Returns the perimeter of the triangle formed by the three specified points.
     *
     * @param pointA the first point of the triangle.
     * @param pointB the second point of the triangle.
     * @param pointC the third point of the triangle.
     * @return the perimeter of the triangle.
     */
    public static double getTrianglePerimeter(Coordinate pointA, Coordinate pointB, Coordinate pointC) {
        final double distanceAB = pointA.distance(pointB);
        final double distanceBC = pointB.distance(pointC);
        final double distanceAC = pointC.distance(pointA);
        return distanceAB + distanceBC + distanceAC;
    }
}