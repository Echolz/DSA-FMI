package utils;

import java.util.EmptyStackException;

public class LinkedList<T> {
    private Node<T> head;
    private Node<T> tail;
    private int size;

    public LinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public void addFirst(T value) {
        size++;
        if (setHead(value)) {
            return;
        }

        Node<T> node = new Node<>(value);

        head.setLeft(node);
        node.setRight(node);

        head = node;
    }

    public void addLast(T value) {
        size++;
        if (setHead(value)) {
            return;
        }

        Node<T> node = new Node<>(value);

        tail.setRight(node);
        node.setLeft(tail);
        tail = node;
    }

    public T removeFirst() {
        if (size == 0) {
            throw new EmptyStackException();
        }
        size--;

        T value = head.getValue();

        head = head.getRight();
        headRemoveLeft();

        return value;
    }

    public T removeLast() {
        if (size == 0) {
            throw new EmptyStackException();
        }
        size--;

        T value = tail.getValue();

        tail = tail.getLeft();
        tailRemoveRight();

        return value;
    }

    public T seeFirst() {
        if (size == 0) {
            throw new EmptyStackException();
        }

        return head.getValue();
    }

    public T seeLast() {
        if (size == 0) {
            throw new EmptyStackException();
        }

        return tail.getValue();
    }

    public int getSize() {
        return size;
    }

    private void tailRemoveRight() {
        if (tail == null) {
            return;
        }

        tail.setRight(null);
    }

    private void headRemoveLeft() {
        if (head == null) {
            return;
        }

        head.setLeft(null);
    }

    private boolean setHead(T value) {
        if (head != null) {
            return false;
        }

        Node<T> node = new Node<>(value);
        tail = head = node;
        return true;
    }
}
