package com.SENG2200.assignment1.mypolygons;

import com.SENG2200.assignment1.polygon.Polygon;

public class MyPolygons {
    private final Node<Polygon> sentinel;
    private Node<Polygon> current;
    private int size;

    public MyPolygons() {
        sentinel = new Node<Polygon>();
        current = null;
        size = 0;
    }

    public MyPolygons(Polygon... polygons) {
        sentinel = new Node<Polygon>();
        size = 0;
        current = null;
        for (Polygon polygon : polygons) {
            append(polygon);
        }
    }

    public void append(Polygon item) {
        current = sentinel.getNext();
        sentinel.setNext(new Node<Polygon>(item));

        if (current != null) {
            current.setPrev(sentinel.getNext());
            sentinel.getNext().setNext(current);
        }

        sentinel.getNext().setPrev(sentinel);
        reset();
        size++;
    }

    public void prepend(Polygon item) {
        current = sentinel.getPrev();
        sentinel.setPrev(new Node<Polygon>(item));

        if (current != null) {
            current.setNext(sentinel.getPrev());
            sentinel.getPrev().setPrev(current);
        }

        sentinel.getPrev().setNext(sentinel);
        reset();
        size++;
    }

    public void insert(Polygon item) {
        for (int i = 0; i < size; i++) {
            if (current.getData().equals(item)) {
                final Node<Polygon> before = current.getPrev();
                current.setPrev(new Node<Polygon>(item));
                before.setNext(current.getPrev());
                current.getPrev().setPrev(before);
                current.getPrev().setNext(current);
                reset();
                return;
            }
        }
    }

    public void next() { current = current.getNext(); }

    public void reset() { current = sentinel.getNext(); }

    public Polygon remove() {
        final Node<Polygon> removed = sentinel.getNext();
        current = current.getNext();
        current.setPrev(sentinel);
        sentinel.setNext(current);
        reset();
        return removed.getData();
    }
}
