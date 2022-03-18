/*
 *  SENG2200 Assignment 1
 *  Jaydon Cameron
 *  C3329145
 *  05/03/2021
 *  This file contains the Polygon class which is used to store an array of Point objects
 */


/**
 * Stores an array of <code>Point</code> objects<br/>
 * Implements <code>ComparePoly</code> interface and the <code>comesBefore()</code> method
 **/
public class Polygon implements ComparePoly {
    // Instance variable
    private final Point[] points;

    /**
     * <code>Class</code> Constructor specifying the vertex/vertices of the <code>Polygon</code>.
     *
     * @param vertices A 2D array of <code>double</code> values corresponding to the x and y coordinates of
     *                 a vertex/point
     * @throws IndexOutOfBoundsException If the parameter <code>vertices</code> is empty
     **/
    public Polygon(final double[][] vertices) throws IndexOutOfBoundsException {
        points = new Point[vertices.length + 1];
        for (byte i = 0; i < vertices.length; i++) {
            points[i] = new Point(vertices[i][0], vertices[i][1]);
        }
        points[points.length - 1] = points[0];

    }

    /**
     * Checks if this <code>Polygon</code> object is the same as another object
     *
     * @param o The object being queried against.
     * @return <code>true</code> if both objects are an instance of <code>Polygon</code> and have the same vertices<br/>
     * <code>false</code> if the objects are different types, or they have different vertices.
     **/
    @Override
    public boolean equals(Object o) {
        // Return true if both objects are the same
        if (o == this) return true;
        // Return false if object is not an instance of Polygon
        if (!(o instanceof Polygon)) return false;
        // typecast object to Polygon object
        final Polygon compare = (Polygon) o;
        // Return false if length of each Point array is not the same
        if (points.length != compare.points.length) return false;
        // Compare each vertex in points array
        for (int i = 0; i < this.points.length; i++) {
            if (points[i].getX() != compare.points[i].getX() || points[i].getY() != compare.points[i].getY()) {
                // Return false if vertex values don't match
                return false;
            }
        }
        return true;
    }

    /**
     * Get the <code>Polygon</code> object as a <code>String</code> in the format
     * <span style="font-weight: 600;">[point<sub>0</sub>point<sub>1</sub>...point<sub>n-2</sub>]: area</span>
     *
     * @return The <code>Polygon</code> object as a <code>String</code>
     **/
    @Override
    public String toString() {
        // Create new StringBuilder object
        StringBuilder stringBuilder = new StringBuilder("[ ");
        // Loop through Point array
        for (int i = 0; i < this.points.length - 1; i++) {
            // concatenate Point object as a string to the StringBuilder
            stringBuilder.append(this.points[i].toString() + ' ');
        }
        // Calculate area of the Polygon and append to the end of the string
        stringBuilder.append(String.format("]:%6.2f", calcArea()));
        // Return Polygon object as a String object in the format "[p0p1...pn-2]: area"
        return stringBuilder.toString();
    }

    /**
     * Get the distance from the origin of the point which is closest to the origin (0,0)
     *
     * @return The distance from the point of the origin of the point closest to the origin
     * as a <code>double</code>
     **/
    public double getDistance() {
        // Initialize the shortest distance using the first point
        double closest = points[0].calcDistance();
        // Loop through each point
        for (Point point : points) {
            // Get distance from the origin of the point
            final double distance = point.calcDistance();
            // Update closest to this distance if it is closer to the origin
            if (distance < closest) closest = distance;
        }
        return closest;
    }

    /**
     * Calculate the area of the <code>Polygon</code> object.
     *
     * @return The area of <code>Polygon</code> object as a <code>double</code>
     **/
    public double calcArea() {
        // Initialise the area value
        double area = 0.0;
        // Loop through each point with a counter
        for (int i = 0; i < this.points.length - 1; i++) {
            // Update area value using formula
            area += (this.points[i + 1].getX() + this.points[i].getX()) *
                    (this.points[i + 1].getY() - this.points[i].getY());
        }
        // Absolute value
        if (area < 0) area *= -1;
        // Half area as per formula
        area *= 0.5;
        return area;
    }

    /**
     * Implementation of the <code>comesBefore()</code> method in the <code>ComparePoly</code> interface.<br/>
     * Compares this <code>Polygon</code> object with a parsed <code>Object</code>.
     *
     * @param object The object being compared to
     * @return <code>true</code> - if this <code>Polygon</code> object has a smaller area<br/>
     * <code>false</code> - if this <code>Polygon</code> object has a larger or equal area
     * @throws ClassCastException if parsed <code>Object</code> is not an instance of <code>Polygon</code>
     **/
    @Override
    public boolean comesBefore(final Object object) throws ClassCastException {
        // Typecast passed object to a Polygon object if the object is an instance of the Polygon class
        if (object instanceof final Polygon otherPoly) {
            // Calculate areas of each Polygon object
            final double thisArea = calcArea(), thatArea = otherPoly.calcArea();
            // Calculate the absolute value of the difference between areas
            double difference = thisArea - thatArea;
            if (difference < 0) difference *= -1;
            if (difference <= (0.001 * (thisArea < thatArea ? thisArea : thatArea))) {
                // If difference is within 0.01% of the smaller area: compare distances
                return getDistance() < otherPoly.getDistance();
            } else {
                // Compare areas
                return thisArea < thatArea;
            }
        } else {
            // Throw Exception if object is not an instance of the Polygon class
            throw new ClassCastException(String.format("Cannot compare with type %s", object.getClass()));
        }
    }
}
