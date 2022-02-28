package com.SENG2200.assignment1.mypolygons;

import com.SENG2200.assignment1.polygon.Polygon;

public class MyPolygons {
    private final Node<Polygon> sentinel;
    private Node<Polygon> current;
    private int size;


    /**
     * <code>Class</code> constructor
     **/
    public MyPolygons() {
        sentinel = new Node<Polygon>();
        current = null;
        size = 0;
    }

    /**
     * <code>Class</code> constructor specifying the initial set of <code>Polygon</code> objects
     * to be in the list.
     **/
    public MyPolygons(final Polygon... polygons) {
        sentinel = new Node<Polygon>();
        size = 0;
        current = null;
        for (Polygon polygon : polygons) {
            append(polygon);
        }
    }


    /**
     * Get the size of the list
     * @return The number of <code>Node</code> objects in the list
     **/
    public int getSize() { return size; }

    /**
     * Check if the list is empty
     * @return <code>true</code> if the list is empty<br/>
     * <code>false</code> if the list has one or more items
     **/
    public boolean isEmpty() { return size == 0; }

    /**
     * Add item to end of list
     * @param item A <code>Polygon</code> object to be appended to the end of the list
     **/
    public void append(final Polygon item) {
        current = new Node<Polygon>(item, sentinel, sentinel.getPrev());
        sentinel.getPrev().setNext(current);
        sentinel.setPrev(current);
        size++;
        reset();
    }

    /**
     * Add item to start of list
     * @param item <code>Polygon</code> object to be prepended to the list
     **/
    public void prepend(final Polygon item) {
        current = new Node<Polygon>(item, sentinel.getNext(), sentinel);
        sentinel.getNext().setPrev(current);
        sentinel.setNext(current);
        size++;
        reset();
    }

//    public void insert(final Polygon item, final Node predecessor, final Node successor) {
//        Node<Polygon> newNode = new Node<Polygon>(item, predecessor, successor);
//        predecessor.setNext(newNode);
//        successor.setPrev(newNode);
//    }

    /**
     * Add item before a specified item
     * @param item A <code>Polygon</code> object to be inserted before the specified item in the list
     * @param before The <code>Polygon</code> object that will be used to insert the item before it
     **/
    public void insert(final Polygon item, final Polygon before) {
        while (current != sentinel) {
//            if (current.getData().equals()) {
//                final  Node<Polygon> newNode = new Node<Polygon>(item, current)
//            }
        }
    }

    /**
     *  Step to the next item (updates the <code>current</code> member variable)
     **/
    public void next() { current = current.getNext(); }

    /**
     *  Reset the <code>current</code> member variable to the start of the list.
     **/
    public void reset() { current = sentinel.getNext(); }

    /**
     *  Remove and return an item from the head of the list.
     *  @return The payload (or data) of the removed <code>Node</code> object
     **/
    public Polygon remove() throws Exception{
        if (isEmpty()) { throw new Exception("List is empty"); }

        final Node<Polygon> removed = sentinel.getNext();
        current = current.getNext();
        current.setPrev(sentinel);
        sentinel.setNext(current);
        size--;

        reset();
        return removed.getData();
    }
}
