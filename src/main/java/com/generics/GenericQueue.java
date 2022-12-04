package com.generics;

/* Queues are FIFO (first in, first out) i.e. the first element added to the queue
 * will also be the first element to be removed */

import java.util.Iterator;
import java.util.NoSuchElementException;

public class GenericQueue<T> implements IQueue<T>, Iterable<T> {

    IList<T> queueData; //via requirements

    /* default constructors backed by GenericArrayList */
    public GenericQueue() {
        queueData = new GenericArrayList<>();
    }

    public GenericQueue(IList<T> data) {
        queueData = data; //assign data to qD
    }

    /**
     * Inserts the specified element into the queue
     * @param element the element argument.
     * uses underlining IList method implementations (add)
     */
    @Override
    public void enqueue(T element) {
        queueData.add(element);
    }
    /**
     * Retrieves and removes the head of this queue.
     *
     * @return the head of this queue - //throw NoSuchElementException as appropriate
     */

    @Override
    public T dequeue() {
        /* checking if list is empty */
        if (empty()) {
            throw new NoSuchElementException();
        }
        else {
            T dequeueData = queueData.get(0); // get first/head element in queue
            queueData.remove(dequeueData); // invoke remove elem
            return dequeueData; // like peekedElem in stack, return dequeue
        }
    }

    /**
     * Retrieves, but does not remove, the head of this queue.
     *
     * @return the head of this queue
     */
    @Override
    public T first() {
        if (empty()) {
            throw new NoSuchElementException();
        }
        else {
            T firstQueue = queueData.get(0); // retrieve first elem in Q
            return firstQueue;
        }
    }

    /**
     * Tests if this Queue is empty.
     * @return {@code true} if and only if this queue contains
     * no items; {@code false} otherwise.
     */
    @Override
    public boolean empty() {
        return queueData.size() == 0; // same as stackData size check
    }

    /* update for unit tests */
    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();
        for (int i = 0; i < queueData.size(); i++) {
            string.append(queueData.get(i)).append(","); // don't forget comma
        }
        return string.toString();
    }


//    @Override
//    public String toString() {
//        return "GenericQueue{" +
//                "queueData=" + queueData +
//                '}';
//    }

    /* Returns an iterator over the elements in this list in proper sequence.*/
    @Override
    public Iterator<T> iterator() {
        return new GenericQueueIterator<>(queueData); //pass in stackData
    }

    /* Iterator class logic */
    public class GenericQueueIterator<T> implements Iterator<T> {

        IList<T> data;
        int index = 0; // checking index

        /* default constructor */
        public GenericQueueIterator(IList<T> data) {
            this.data = data;
        }

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
