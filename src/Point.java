/*
 *  SENG2200 Assignment 1
 *  Jaydon Cameron
 *  C3329145
 *  05/03/2021
 *  This file contains the Point class which is used to store the x and y coordinates for
 *  a vertex of a Polygon object
 */

/**
 * Used in a <code>Polygon</code> object to store the x and y values for the coordinates of a point/vertex
 **/
public class Point {
    // Instance variables
    private final double x, y;

    /**
     * <code>Class</code> Constructor specifying the values for the x and y coordinates
     *
     * @param x The <code>double</code> value for the x coordinate
     * @param y The <code>double</code> value for the y coordinate
     **/
    public Point(final double x, final double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Calculate the distance of this point from the origin (0,0)
     *
     * @return The value distance of this point from the origin as a <code>double</code>
     **/
    public double calcDistance() {
        return Math.sqrt(x * x + y * y);
    }

    /**
     * Get the x coordinate for this point
     *
     * @return The value of the x coordinate for this <code>Point</code> object as a <code>double</code>
     **/
    public double getX() {
        return x;
    }

    /**
     * Get the y coordinate for this point
     *
     * @return The value of the y coordinate for this <code>Point</code> object as a <code>double</code>
     **/
    public double getY() {
        return y;
    }


    /**
     * Get the point as a <code>String</code> in the format <span style="font-weight: 600;">(x , y)</span>
     *
     * @return The <code>Point</code> object as a <code>String</code>
     **/
    @Override
    public String toString() {
        return String.format("(%4.2f , %4.2f)", this.x, this.y);
    }


}
