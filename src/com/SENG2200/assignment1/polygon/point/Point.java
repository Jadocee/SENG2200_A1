package com.SENG2200.assignment1.polygon.point;

public class Point implements IPoint{
    private final double x, y;

    public Point (double x, double y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public double fromOrigin() {
        return 0;
    }

    @Override
    public String toString() {
        return String.format("(%4.2f , %4.2f)", this.x, this.y);
    }

    @Override
    public double getX() {
        return this.x;
    }

    @Override
    public double getY() {
        return this.y;
    }

}
