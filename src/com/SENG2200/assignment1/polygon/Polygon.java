package com.SENG2200.assignment1.polygon;

import com.SENG2200.assignment1.polygon.point.Point;


/**
 * Class
 **/
public class Polygon implements Comparable {
    private final Point[] points;

    /**
     * <code>Class</code> Constructor specifying the vertex/vertices of the <code>Polygon</code>.
     *
     * @param points Series of <code>Point</code> objects or an iterable of <code>Point</code> objects
     **/
    public Polygon(final Point... points) {
//        if (points.length > max) this.points = new Point[points.length];
//        else this.points = new Point[max];
        this.points = new Point[points.length+1];
        for (int i = 0; i < points.length; i++) {
            this.points[i] = points[i];
        }
        this.points[this.points.length-1] = points[0];
    }

//    public Polygon(final int n) {
//        points = new Point[n];
//    }


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
        StringBuilder stringBuilder = new StringBuilder("[ ");
        for (int i = 0; i < this.points.length - 1; i++) {
            stringBuilder.append(this.points[i].toString() + ' ');
        }
        stringBuilder.append(String.format("]:%6.2f", calcArea()));
        return stringBuilder.toString();
    }

    /**
     * Get the distance from the origin of the point which is closest to the origin
     * @return the distance from the point of the origin of the point closest to the origin
     **/
    public double distance() {
        double closest = Math.sqrt(points[0].getX() * points[0].getX() + points[0].getY() * points[0].getY());
        for (Point point : points) {
            final double distance = Math.sqrt(point.getX() * point.getX() + point.getY() * point.getY());
            if (distance < closest) closest = distance;
        }
        return closest;
    }

    public double calcArea() {
        double area = 0.0;
        for (int i = 0; i < this.points.length - 1; i++) {
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
    public boolean comesBefore(final Object object) throws Exception {
        if (object instanceof final Polygon otherPoly) {  // Tests parameter and assigns to variable
            final double[] areas = largestToSmallest(calcArea(), otherPoly.calcArea());
            double diff = areas[0] - areas[1];

            if (diff <= 0.001 * areas[1]) {
                if (distance() > otherPoly.distance()) return true;
                else return false;
            }
            else if (areas[0] > areas[1]) { return true; }
            else { return false; }

        } else {
            throw new Exception(String.format("Cannot compare with type %s", object.getClass()));
        }



//        final double area1 = calcArea(), area2 = otherPoly.calcArea();
//        double smaller;
//
//        if (area1 > area2) smaller = area2;
//        else {smaller = area1;}
//
//        double difference = area1 - area2;
//        if (difference < 0) difference *= -1;
////        if (difference <= 0.001 * smaller)
////        if ((area2 - area1)  <= 0.001 * smaller)
//
//
//        return false;
    }

    public static double[] largestToSmallest(final double... values) {
//        double[] unsortedValues = values;
        double[] sortedValues = new double[values.length];

        for (final double val : values) {
            int pos = 0;
            for (final double toCompare : values) {
                if (toCompare > val) pos++;
            }
            sortedValues[pos] = val;
        }

//        while (unsortedValues.length > 0) {
//            for (int i = 0, j = i + 1; i < unsortedValues.length && j < unsortedValues.length; i++) {
//                if (unsortedValues[i] > unsortedValues[j]);
//            }
//        }
//
//        for (int i = 0; i < values.length; i++) {
////            final double value = values[i];
//            for(int j = i + 1; j < values.length; j++) {
//                if (values[j] > values[i]) {
//                    double temp = values[i];
//                    values[j] = values[i];
//                    values[i] = temp;
//                }
//            }
//        }
//
//        for (final double val : values) {
//            for (int i = 0; i < values.length; i++) {
//                if (val > values[i]) {
//
//                }
//            }
//        }
        return sortedValues;
    }
}
