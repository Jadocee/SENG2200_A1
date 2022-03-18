/*
 *  SENG2200 Assignment 1
 *  Jaydon Cameron
 *  C3329145
 *  05/03/2021
 *  This file contains the MyPolygons class that implements a circular doubly-linked list data
 *  structure to store Polygon objects
 */

/**
 * Implements a circular doubly-linked list data structure for storing Polygon objects
 **/
public class MyPolygons {

    // instance variables
    private final Node sentinel;
    private Node current;
    private int size;


    /**
     * <code>Class</code> constructor
     **/
    public MyPolygons() {
        sentinel = new Node();
        sentinel.setNext(sentinel);
        sentinel.setPrev(sentinel);
        current = sentinel;
        size = 0;
    }

    /**
     * <code>Class</code> constructor specifying the initial set of <code>Polygon</code> objects
     * to be in the list.
     **/
    public MyPolygons(final Polygon... polygons) {
        sentinel = new Node();
        sentinel.setNext(sentinel);
        sentinel.setPrev(sentinel);
        size = 0;
        current = sentinel;
        for (final Polygon polygon : polygons) {
            append(polygon);
        }
    }

    /**
     * Get the size of the list<br/>
     * Pre-conditions: None<br/>
     * Post-conditions: Size of the list is returned
     *
     * @return The number of <code>Node</code> objects in the list
     **/
    public int getSize() {
        return size;
    }

    /**
     * Check if the list is empty<br/>
     * Pre-conditions: None<br/>
     * Post-conditions: A boolean representing whether the list contains an item is returned
     *
     * @return <code>true</code> if the list is empty<br/>
     * <code>false</code> if the list has one or more items
     **/
    public boolean isEmpty() {
        return size == 0;
    }


    /**
     * Adds a <code>Polygon</code> object to the end of list<br/>
     * Pre-conditions: None<br/>
     * Post-conditions: Polygon object is added to the end of the list
     *
     * @param item A <code>Polygon</code> object to be appended to the end of the list
     *             Pre-conditions:
     **/
    public void append(final Polygon item) {
        // Set current as a new Node object
        current = new Node(item, sentinel, sentinel.getPrev());
        // Update node at the end of the list to have it's next as the new node
        sentinel.getPrev().setNext(current);
        // Update sentinel node's prev to be the new node
        sentinel.setPrev(current);
        // Increment size
        size++;
        // Reset current to start of the list
        reset();
    }

    /**
     * Adds a <code>Polygon</code> object to the start of list<br/>
     * Pre-conditions: None<br/>
     * Post-conditions: Polygon object is added to the start of the list
     *
     * @param item <code>Polygon</code> object to be prepended to the list
     **/
    public void prepend(final Polygon item) {
        // Create new Node object and add next and prev nodes
        current = new Node(item, sentinel.getNext(), sentinel);
        // Update other nodes to point to the new node
        sentinel.getNext().setPrev(current);
        sentinel.setNext(current);
        size++;
        reset();
    }

    /**
     * Insert an item before a specified item (i.e., the <code>Node</code> object that <code>current</code>
     * is pointing to)<br/>
     * Pre-conditions: None<br/>
     * Post-conditions: Polygon object is inserted before the Node object referenced by current
     *
     * @param item A <code>Polygon</code> object to be inserted before the specified item in the list
     **/
    public void insert(final Polygon item) {
        Node newNode = new Node(item, current, current.getPrev());
        current.getPrev().setNext(newNode);
        current.setPrev(newNode);
        size++;
    }

    /**
     * Add item to list; maintaining increasing order<br/>
     * Pre-conditions: None<br/>
     * Post-conditions: Polygon object is added to the list in increasing order of area
     *
     * @param item A <code>Polygon</code> object to be added to the list
     **/
    public void insertInOrder(final Polygon item) {
        if (isEmpty()) {
            // Add to the end of list if empty
            append(item);
            // skip rest of method and return to caller
            return;
        }

        while (current != sentinel) {
            try {
                // break loop if current is the node to insert before
                if (item.comesBefore(current.getData())) break;
                    // traverse list
                else next();
            } catch (Exception e) {
                // Print exception message
                System.out.println(e.getMessage());
            }
        }
        // insert the item before current
        insert(item);
        // reset current to the start of the list
        reset();
    }

    /**
     * Step to the next item (updates the <code>current</code> member variable)<br/>
     * Pre-conditions: List is not empty<br/>
     * Post-conditions: current is updated to reference the next node in the list
     **/
    public void next() {
        current = current.getNext();
    }

    /**
     * Reset the <code>current</code> member variable to the first item in the list.<br/>
     * Pre-conditions: None<br/>
     * Post-conditions: current is updated to reference the node located at the start of the list
     **/
    public void reset() {
        current = sentinel.getNext();
    }

    /**
     * Remove and return an item from the head of the list.<br/>
     * Pre-conditions: List is not empty<br/>
     * Post-conditions: current node is removed from the list and it's data is returned
     *
     * @return The payload (or data) of the removed <code>Node</code> object
     * @throws Exception If the list is empty
     **/
    public Polygon remove() throws Exception {
        if (isEmpty()) {
            // Throws Exception if there is nothing to remove
            throw new Exception("List is empty");
        }

        // Gets data from the object to be removed
        final Polygon data = current.getData();
        // Update both nodes either side of the to-be-removed node to ignore it
        current = current.getNext();
        current.setPrev(sentinel);
        sentinel.setNext(current);
        // decrement size
        size--;
        // Reset current to start of list
        reset();
        // Return data of the now removed node
        return data;
    }

    /**
     * Gets the data of each <code>Polygon</code> objects a <code>String</code>.<br/>
     * Pre-conditions: None<br/>
     * Post-conditions: The contents of the list is returned as a <code>String</code> object, or if the list
     * is empty: the message "empty" is returned
     *
     * @return A <code>String</code> object containing the vertices and calculated area of each <code>Polygon</code>
     * object.<br/>
     * The data of each <code>Polygon</code> object is printed as the format:<br/>
     * <p style="font-weight: 700; text-align: left;">
     * [point<sub>0</sub>point<sub>1</sub>...point<sub>n-2</sub>]: area
     * </p>
     **/
    @Override
    public String toString() {
        // Return "empty" if list is empty
        if (isEmpty()) return "empty";
        // Create new StringBuilder object for concatenating strings
        StringBuilder stringBuilder = new StringBuilder();
        // Traverse list by updating current until its address is the same as sentinel
        while (current != sentinel) {
            // Append each Polygon to the StringBuilder
            stringBuilder.append(current.getData().toString() + "\n");
            // Update current to move to next node
            next();
        }
        // Reset current to start of list
        reset();
        // Return concatenated string
        return stringBuilder.toString();
    }
}
