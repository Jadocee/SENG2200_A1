package com.SENG2200.assignment1.polygon;
import com.SENG2200.assignment1.polygon.point.Point;

public class Polygon implements IPolygon, ComparePoly {
    private final Point[] points;

    public Polygon(Point... points) {
//        if (points.length > max) this.points = new Point[points.length];
//        else this.points = new Point[max];
        this.points = points;
    }

    public boolean equals(Polygon polygon) {
        if (this.points.length != polygon.points.length) return false;

        for (int i = 0; i < this.points.length; i++) {
            if (this.points[i].getX() != polygon.points[i].getX()
                    || this.points[i].getY() != polygon.points[i].getY()) {
                return false;
            }
        }

        return true;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("[");
        for (int i = 0; i < this.points.length - 2; i++) {
            stringBuilder.append(this.points[i].toString());
        }
        stringBuilder.append(String.format("]:%6.2f", calcArea()));
        return stringBuilder.toString();
    }

    @Override
    public double distance() {
        return 0;
    }

    @Override
    public double calcArea() {
        double area = 0;
        for (int i = 0; i < this.points.length - 2; i++) {
            area += (this.points[i + 1].getX() + this.points[i].getX()) *
                    (this.points[i + 1].getY() - this.points[i].getY());
        }
        if (area < 0) area *= -1;
        area *= 0.5;
        return area;
    }


    @Override
    public boolean ComesBefore(Object o) {
        return false;
    }
}
