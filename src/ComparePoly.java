/*
 *  SENG2200 Assignment 1
 *  Jaydon Cameron
 *  C3329145
 *  05/03/2021
 *  This file contains the ComparePoly interface.
 */

/**
 * A non-generic interface that is an alternate version of the <code>Comparable&#60;T&#62;</code> interface.<br/>
 * Contains the method <code>comesBefore()</code> that is implemented by the <code>Polygon</code> class.
 *
 * @see Polygon
 * @see Polygon#comesBefore(Object)
 **/
public interface ComparePoly {
    /**
     * Interface method for comparing two <code>Object</code> types.<br/>
     * Implemented by the <code>Polygon</code> class for comparing a <code>Polygon</code> object with a
     * parsed <code>Object</code>.
     *
     * @param object The <code>Object</code> that will be compared to
     * @throws ClassCastException If parsed <code>Object</code> could not be
     *                            typecast to the appropriate type
     * @see Polygon#comesBefore(Object)
     **/
    boolean comesBefore(final Object object) throws ClassCastException;
}
