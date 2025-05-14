package org.example;

import java.util.Collection;

public class MyDeque<E> implements Deque<E> {

    private Node<E> first;
    private Node<E> last;
    private int size;

    private static class Node<E> {
        E item;
        Node<E> next;
        Node<E> prev;

        Node(E element) {
            item = element;
        }
    }

    public MyDeque() {
        first = last = null;
        size = 0;
    }

    @Override
    public void addFirst(E e) {
        Node<E> newNode = new Node<>(e);
        if (first == null) {
            first = last = newNode;
        } else {
            newNode.next = first;
            first.prev = newNode;
            first = newNode;
        }
        size++;
    }

    @Override
    public void addLast(E e) {
        Node<E> newNode = new Node<>(e);
        if (last == null) {
            first = last = newNode;
        } else {
            newNode.prev = last;
            last.next = newNode;
            last = newNode;
        }
        size++;
    }

    @Override
    public E removeFirst() {
        if (first == null) {
            throw new IllegalStateException("Deque is empty");
        }
        E item = first.item;
        first = first.next;
        if (first == null) {
            last = null;
        } else {
            first.prev = null;
        }
        size--;
        return item;
    }

    @Override
    public E removeLast() {
        if (last == null) {
            throw new IllegalStateException("Deque is empty");
        }
        E item = last.item;
        last = last.prev;
        if (last == null) {
            first = null;
        } else {
            last.next = null;
        }
        size--;
        return item;
    }

    @Override
    public E getFirst() {
        if (first == null) {
            throw new IllegalStateException("Deque is empty");
        }
        return first.item;
    }

    @Override
    public E getLast() {
        if (last == null) {
            throw new IllegalStateException("Deque is empty");
        }
        return last.item;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        boolean modified = false;
        for (E element : c) {
            addLast(element);
            modified = true;
        }
        return modified;
    }

    @Override
    public boolean remove(Object o) {
        Node<E> current = first;
        while (current != null) {
            if (current.item.equals(o)) {
                if (current.prev == null) {
                    first = current.next;
                } else {
                    current.prev.next = current.next;
                }
                if (current.next == null) {
                    last = current.prev;
                } else {
                    current.next.prev = current.prev;
                }
                size--;
                return true;
            }
            current = current.next;
        }
        return false;
    }

    @Override
    public boolean contains(Object o) {
        Node<E> current = first;
        while (current != null) {
            if (current.item.equals(o)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    @Override
    public int size() {
        return size;
    }
}

//Тригеримо CI пайплайн