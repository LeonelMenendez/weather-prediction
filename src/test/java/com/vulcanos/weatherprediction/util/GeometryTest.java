package com.vulcanos.weatherprediction.util;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.locationtech.jts.geom.Coordinate;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
public class GeometryTest {

    @Test
    public void whenPointsAreCollinear_thenReturnTrue() {
        final Coordinate pointA = new Coordinate(1, 1);
        final Coordinate pointB = new Coordinate(2, 2);
        final Coordinate pointC = new Coordinate(3, 3);

        assertThat(Geometry.areCollinear(pointA, pointB, pointC)).isTrue();
    }

    @Test
    public void whenPointsAreNotCollinear_thenReturnFalse() {
        final Coordinate pointA = new Coordinate(1, 3);
        final Coordinate pointB = new Coordinate(2, 4);
        final Coordinate pointC = new Coordinate(3, 7);

        assertThat(Geometry.areCollinear(pointA, pointB, pointC)).isFalse();
    }

    @Test
    public void whenPointIsInsideTriangle_thenReturnTrue() {
        final Coordinate pointA = new Coordinate(1, 1);
        final Coordinate pointB = new Coordinate(3, 4);
        final Coordinate pointC = new Coordinate(5, 2);
        final Coordinate pointToCheck = new Coordinate(3, 2);

        assertThat(Geometry.isPointInsideTriangle(pointA, pointB, pointC, pointToCheck)).isTrue();
    }

    @Test
    public void whenPointIsNotInsideTriangle_thenReturnFalse() {
        final Coordinate pointA = new Coordinate(1, 1);
        final Coordinate pointB = new Coordinate(3, 4);
        final Coordinate pointC = new Coordinate(5, 2);
        final Coordinate pointToCheck = new Coordinate(4, 4);

        assertThat(Geometry.isPointInsideTriangle(pointA, pointB, pointC, pointToCheck)).isFalse();
    }

    @Test
    public void testGetTrianglePerimeter() {
        final Coordinate pointA = new Coordinate(4, 5);
        final Coordinate pointB = new Coordinate(10, 6);
        final Coordinate pointC = new Coordinate(8, 3);
        final BigDecimal perimeter = new BigDecimal(Geometry.getTrianglePerimeter(pointA, pointB, pointC));

        assertThat(perimeter.setScale(2, RoundingMode.HALF_UP).doubleValue()).isEqualTo(14.16);
    }
}
