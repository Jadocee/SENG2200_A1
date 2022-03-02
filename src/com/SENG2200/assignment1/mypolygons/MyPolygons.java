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
        sentinel.setNext(sentinel);
        sentinel.setPrev(sentinel);
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

    /**
     * Add item before a specified item
     * @param item A <code>Polygon</code> object to be inserted before the specified item in the list
     * @param before The <code>Polygon</code> object that will be used to insert the item before it
     **/
    public void insert(final Polygon item, final Polygon before) {
        while (current != sentinel) {
            if (current.getNext().getData().equals(before)) {
                Node<Polygon> newNode = new Node<Polygon>(item, current.getNext(), current);
                current.getNext().setPrev(newNode);
                current.setNext(newNode);
                size++;
                break;
            } else next();
        }
        reset();
    }

    /**
     *  Step to the next item (updates the <code>current</code> member variable)
     **/
    public void next() { current = current.getNext(); }

    /**
     *  Reset the <code>current</code> member variable to the first item in the list.
     **/
    public void reset() { current = sentinel.getNext(); }

    /**
     *  Remove and return an item from the head of the list.
     *  @return The payload (or data) of the removed <code>Node</code> object
     **/
    public Polygon remove() throws Exception{
        if (isEmpty()) { throw new Exception("List is empty"); }

        final Polygon data = current.getData();
        current = current.getNext();
        current.setPrev(sentinel);
        sentinel.setNext(current);
        size--;
        reset();
        return data;
    }

    public String print() {
        StringBuilder stringBuilder = new StringBuilder();
        while (current != sentinel) {
            stringBuilder.append(current.getData().toString() + "\n");
            next();
        }
        reset();
        return stringBuilder.toString();
    }
}
