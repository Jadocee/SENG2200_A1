package com.SENG2200.assignment1.polygon;

import com.SENG2200.assignment1.polygon.point.Point;


/**
 * Class
 **/
public class Polygon<T> implements Comparable<T> {
    private final Point[] points;

    /**
     * <code>Class</code> Constructor specifying the vertex/vertices of the <code>Polygon</code>.
     *
     * @param points Series of <code>Point</code> objects or an iterable of <code>Point</code> objects
     **/
    public Polygon(Point... points) {
//        if (points.length > max) this.points = new Point[points.length];
//        else this.points = new Point[max];
        this.points = points;
    }


    /**
     * @param o The object being queried against.
     * @return <code>true</code> if both objects are an instance of <code>Polygon</code> and have the same vertices<br/>
     * <code>false</code> if the objects are different types, or they have different vertices.
     **/
    @Override
    public boolean equals(Object o) {
        if (o == this) return true;
        if (!(o instanceof Polygon)) return false;

        final Polygon compare = (Polygon) o;
        if (points.length != compare.points.length) return false;

        for (int i = 0; i < this.points.length; i++) {
            if (points[i].getX() != compare.points[i].getX() || points[i].getY() != compare.points[i].getY()) {
                return false;
            }
        }
        return true;
    }


    /**
     * @return The <code>Polygon</code> objects vertices as a <code>String</code> in the format:
     * <p style="font-weight: 700; text-align: left;">[point<sub>0</sub>point<sub>1</sub>...point<sub>n-2</sub>]: area</p>
     **/
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("[");
        for (int i = 0; i < this.points.length - 2; i++) {
            stringBuilder.append(this.points[i].toString());
        }
        stringBuilder.append(String.format("]:%6.2f", calcArea()));
        return stringBuilder.toString();
    }

    public double distance() {
        return 0;
    }

    public double calcArea() {
        double area = 0.0;
        for (int i = 0; i < this.points.length - 2; i++) {
            area += (this.points[i + 1].getX() + this.points[i].getX()) *
                    (this.points[i + 1].getY() - this.points[i].getY());
        }
        if (area < 0) area *= -1;
        area *= 0.5;
        return area;
    }


    /**
     * @param object The object being compared to
     * @return 0 if both objects have the same vertices,
     * 1 if the compared object come after,
     * -1 if the compared object comes before
     **/
    @Override
    public int compareTo(final T object) throws Exception {
        if (!(object instanceof Polygon)) {
            throw new Exception(String.format("Cannot compare with type %s", object.getClass()));
        }

        if (this.equals(object)) return 0;

        return 1;
    }
}
