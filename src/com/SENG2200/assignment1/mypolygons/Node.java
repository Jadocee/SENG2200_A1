package com.SENG2200.assignment1.mypolygons;
import com.SENG2200.assignment1.polygon.Polygon;

public class Node<T> {
    private T data;
    private Node<T> next;
    private Node<T> prev;

    public Node(T data) {
        this.data = data;
        next = null;
        prev = null;
    }

    public Node() {
        data = null;
        next = null;
        prev = null;
    }

    public Node(T data, Node<T> next, Node<T> prev) {
        this.data = data;
        this.next = next;
        this.prev = prev;
    }


    public Node<T> getNext() { return next; }
    public Node<T> getPrev() { return prev; }
    public void setNext(Node<T> node) { next = node; }
    public void setPrev(Node<T> node) { prev = node; }

    public T getData() { return data; }
}
