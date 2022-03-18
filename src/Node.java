/*
 *  SENG2200 Assignment 1
 *  Jaydon Cameron
 *  C3329145
 *  05/03/2021
 *  This file contains the Node class used in the MyPolygons class to store data in the
 *  circular doubly-linked list.
 */

/**
 * Stores <code>Polygon</code> objects in a linked-list data structure
 **/
public class Node {
    // Instance variables
    private final Polygon data;
    private Node next;
    private Node prev;

    /**
     * <code>Class</code> constructor that specifies the data of the <code>Node</code> object
     *
     * @param data <code>Polygon</code> object that will be stored in the newly instantiated
     *             <code>Node</code> object
     **/
    public Node(final Polygon data) {
        this.data = data;
        next = null;
        prev = null;
    }

    /**
     * <code>Class</code> constructor
     **/
    public Node() {
        data = null;
        next = null;
        prev = null;
    }

    /**
     * <code>Class</code> constructor that specifies the data, next, and previous, of the
     * <code>Node</code> object
     *
     * @param data <code>Polygon</code> object that will be stored in the newly instantiated
     *             <code>Node</code> object
     * @param next <code>Node</code> object that will be referenced by this node's <code>next</code>
     * @param prev <code>Node</code> object that will be referenced by this node's <code>prev</code>
     **/
    public Node(final Polygon data, final Node next, final Node prev) {
        this.data = data;
        this.next = next;
        this.prev = prev;
    }

    /**
     * Get the <code>Node</code> object that is next to this one<br/>
     * Pre-conditions: None<br/>
     * Post-conditions: The next <code>Node</code> object or <code>null</code> is returned
     *
     * @return The <code>Node</code> object referenced by this <code>Node</code> object's <code>next</code>
     * instance variable
     * @see #setNext(Node)
     **/
    public Node getNext() {
        return next;
    }

    /**
     * Set the <code>Node</code> object that is next to this one<br/>
     * Pre-conditions: None<br/>
     * Post-conditions: The reference to the next <code>Node</code> object is updated
     *
     * @param node <code>Node</code> object that will be linked to this
     *             <code>Node</code> object as <code>next</code>
     * @see #getNext()
     **/
    public void setNext(final Node node) {
        next = node;
    }

    /**
     * Get the <code>Node</code> object that is previous to this one<br/>
     * Pre-conditions: None<br/>
     * Post-conditions: The previous <code>Node</code> object or <code>null</code> is returned
     *
     * @return The <code>Node</code> object referenced by this <code>Node</code> object's <code>prev</code>
     * instance variable
     * @see #setPrev(Node)
     **/
    public Node getPrev() {
        return prev;
    }

    /**
     * Set the <code>Node</code> object that is previous to this one<br/>
     * Pre-conditions: None<br/>
     * Post-conditions: The reference to the previous <code>Node</code> object is updated
     *
     * @param node <code>Node</code> object that will be linked to this
     *             <code>Node</code> object as <code>prev</code>
     * @see #getPrev()
     **/
    public void setPrev(final Node node) {
        prev = node;
    }

    /**
     * Get the data of this node<br/>
     * Pre-conditions: None<br/>
     * Post-conditions: The data of this node is returned
     *
     * @return The <code>Polygon</code> object stored in the node
     **/
    public Polygon getData() {
        return data;
    }
}
