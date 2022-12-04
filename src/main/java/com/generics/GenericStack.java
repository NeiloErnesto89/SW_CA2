package com.generics;

//import java.util.Iterator;

import java.util.Iterator;

public class GenericStack<T> implements IStack<T> { //, Iterable<T>

    private IList<T> stackData; //via requirement notes

    /* default constructor */
    public GenericStack() {
        stackData = new GenericArrayList<>(); //new genericAL obj
    }
    public GenericStack(IList<T> data) {
        stackData = data; // via generic IList
    }

    @Override
    public void push(T element) {

        stackData.add(element); // 'push' or add element to the top of the stack

    }

    @Override
    public T pop() {
        if (!empty()) {
            return null;
        }

        return null;
    }

    @Override
    public T peek() {
        return null;
    }

    @Override
    public boolean empty() {
        return false;
    }

//    /* Returns an iterator over the elements in this list in proper sequence.*/
//    @Override
//    public Iterator<T> iterator() {
//
////        return new GenericLinkedList.GenericLinkedListIterator();
//        return new GenericStackIterator<>()
//    }
}
