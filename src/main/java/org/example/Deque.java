package org.example;

import java.util.Collection;

public interface Deque<E> {

    void addFirst(E e);

    void addLast(E e);

    E removeFirst();

    E removeLast();

    E getFirst();

    E getLast();

    boolean addAll(Collection<? extends E> c);

    boolean remove(Object o);

    boolean contains(Object o);

    int size();
}
