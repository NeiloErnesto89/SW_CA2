package com.generics;

import java.util.EmptyStackException;
import java.util.Iterator;

/*  stack backed by 'default' generic arraylist. LIFO data structure, so we focus on the 'end' (last in)
*  e.g. web browser <- back button 'pops' back. O(1) operation  */

public class GenericStack<T> implements IStack<T>, Iterable<T> { //

    private IList<T> stackData; //via requirement notes
//    private int top;
//    private int size;

    /* default constructor */
    public GenericStack() {
        stackData = new GenericArrayList<>(); //new genericAL obj
    }

    public GenericStack(IList<T> data) {
        stackData = data; // via generic IList
    }

    /* pushes an item onto the top of the curr stack*/
    @Override
    public void push(T element) {

        stackData.add(element); // 'push' or add element to the top of the stack

    }

    /* Via Stack Notes: pop() removes and returns the top element of the stack. An
     * ‘EmptyStackException’ exception is thrown if we call pop() when the
     * invoking stack is empty.*/
    @Override
    public T pop() {
        /* check if stack is empty, throw except if true */
        if (empty()) {
            throw new EmptyStackException();
        } else {
            /* get index of top elem to be popped
             * can access size(), get() etc.  */
            int index = stackData.size() - 1;
            T poppedElem = stackData.get(index); //retrieving elem to be popped
            stackData.remove(poppedElem); // calling remove() via GenericArrayList
            return poppedElem; // return 'popped' elem
        }
    }


    /* Returns the element on the top of the stack, but does not remove it */
    @Override
    public T peek() {
        if (empty()) {
            throw new EmptyStackException();
        } else {
            int index = stackData.size() - 1;
            T peekedElem = stackData.get(index);
            return peekedElem; // returns elem @ top of stack (but doesn't remove)
        }
    }

    /* It returns true if nothing is on the top of the stack. Else, returns false. */
    @Override
    public boolean empty() {
        /* here we can access stackData elem size() */
        return stackData.size() == 0; // True if empty
    }

    @Override
    public String toString() {
        return "GenericStack{" +
                "stackData=" + stackData +
                '}';
    }

    /* Returns an iterator over the elements in this list in proper sequence.*/
    @Override
    public Iterator<T> iterator() {
        return new GenericStackIterator<>(stackData); //pass in stackData
    }

    /* Iterator class logic */
    public class GenericStackIterator<T> implements Iterator<T> {

        IList<T> data;
        int index = 0; // checking index

        /* default constructor */
        public GenericStackIterator(IList<T> data) {
            this.data = data;
        }

//        @Override
//        public Iterator<T> iterator() {
//            return null;
//        }

        /* returns true if data has elems, else false*/
        @Override
        public boolean hasNext() {
            return data.size() > index; // must be greater than index
        }

        /* returns next elem in iterable - acts as loop */
        @Override
        public T next() {
            if (hasNext()) {
                return data.get(index++); // increment to get next elem via index
            } else {
                /* otherwise, throw index out of bounds exception */
                throw new IndexOutOfBoundsException();
            }
        }

    }
}
        //        public Iterator<T> iterator(data)
//        { return new ReverseArrayIterator(); }
//        private class ReverseArrayIterator implements Iterator<T>
//        {


