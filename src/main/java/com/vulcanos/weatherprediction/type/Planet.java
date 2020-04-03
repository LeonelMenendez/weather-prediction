package com.vulcanos.weatherprediction.type;

import org.locationtech.jts.geom.Coordinate;

/**
 * Planets in the solar system.
 */
public enum Planet {

    BETASOIDE(3, 2000, 0),
    FERENGI(1, 500, 0),
    VULCANO(-5, 1000, 0);

    /**
     * The angular velocity of the planet, expressed in degrees per day.
     *
     * @HasGetter
     */
    private final double angularVelocity;

    /**
     * The radius of the planet, expressed in kilometers (km).
     *
     * @HasGetter
     */
    private final double radius;

    /**
     * The initial position of the planet, expressed in degrees.
     *
     * @HasGetter
     */
    private final double initialPosition;

    Planet(double angularVelocity, double radius, double initialPosition) {
        this.angularVelocity = angularVelocity;
        this.radius = radius;
        this.initialPosition = initialPosition;
    }

    public double getAngularVelocity() {
        return angularVelocity;
    }

    public double getRadius() {
        return radius;
    }

    public double getInitialPosition() {
        return initialPosition;
    }

    /**
     * Returns the position of the planet on the specified day.
     *
     * @param day the number of days that have passed since day zero.
     * @return the position of the planet on the specified day.
     */
    public Coordinate getPosition(int day) {
        final double currentAngle = Math.toRadians((this.initialPosition + day * this.angularVelocity) % 360);
        final double x = this.radius * Math.cos(currentAngle);
        final double y = this.radius * Math.sin(currentAngle);
        return new Coordinate(x, y);
    }
}
