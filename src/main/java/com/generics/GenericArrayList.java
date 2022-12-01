package com.generics;

import java.util.Iterator;

public class GenericArrayList<T> implements IList<T> {

    /* buffer variable holds array data */
    private T[] buffer;

    private int nextFreeLoc;
    private int currentCapacity;


    /* default constructor */
    public GenericArrayList(T[] buffer, int nextFreeLoc, int currentCapacity) {
        this.buffer = buffer;
        this.nextFreeLoc = nextFreeLoc;
        this.currentCapacity = currentCapacity;
    }

    @Override
    public void add(T elem) {

    }

    @Override
    public void add(int index, T element) {

    }

    @Override
    public T set(int index, T element) {
        return null;
    }

    @Override
    public T get(int index) {
        return null;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public T remove(int index) {
        return null;
    }

    @Override
    public boolean remove(T elem) {
        return false;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean contains(T element) {
        return false;
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }
}
