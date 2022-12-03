package com.generics;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class GenericArrayList<T> implements IList<T> {

    /* buffer variable holds array data */
    private T[] buffer;

    /**
     * Index of next free location - will also help us to determine if the buffer is full
     */
    private int nextFreeLoc;

    /** This will change as buffer fills up and we allocate more and more storage space */
    private int currentCapacity;

    private static final int INITIAL_CAPACITY = 3;//nice and small so that we test it quickly


    /** Default Constructor */
    public GenericArrayList(){
        currentCapacity = INITIAL_CAPACITY;
        nextFreeLoc = 0;
        buffer = (T[]) new Object[currentCapacity]; // casting
    }

    @Override
    public void add(T elem) {

        growArrayIfNeeded(); // as per private "helper" method
        buffer[nextFreeLoc++] = elem;

    }

    /** Via Dermot
     * Add an element to a specified index. Make sure to avoid adding beyond the end of the
     * array (no gaps or bufferOverflows).
     * Also, remember to "grow" the managed array, if required. * @param index where to insert (ignore if greater than nextFreeLoc - otherwise you'll get gaps)
     * @param elem the data to insert
     */
    public void add(int index, T elem)
    {
        // if it's valid -> maybe better way to check
        if (index <= nextFreeLoc)
//        if (index > nextFreeLoc || index < 0)
        {
            //Make sure that we "grow" the array if needed.
            growArrayIfNeeded();

            //shuffle everything up from right to left //Note that this is a much easier mechanism to implement than trying to insert the new
            //element and then shuffle everything from left to right
            for (int i = nextFreeLoc; i > index; i--)
            {
                buffer[i] = buffer[i-1];
            }

            //Now everything has moved up we can simply insert the new element
            buffer[index] = elem;
            //Obviously, we've added an extra element so we must update to reflect this
            nextFreeLoc++;
        }
    }
    /* here are setting/replacing element at the given i (index) position
    * with another given element -> return prevElem formerly in the i position */
    @Override
    public T set(int index, T elem) {
        if (index <= nextFreeLoc) {
            for (int i=0; i <nextFreeLoc; i++) {
                T prevElem = buffer[i]; // assign prevElem as buf index
                buffer[i] = elem;

                return prevElem; // T
            }
        }
        else {
            return null; // needed?
        }
    return null; // needed?
    }



    /** Retrieve an element from 'i' position (index) in the list
     *
     * @param index the location to be return
     * @return the data at buffer[index]
     */
    public T get(int index)
    {
        if(index >= nextFreeLoc)
        {
            return null;
        }

        return buffer[index];
    }

    /**
     *
     * @return the size (i.e. the number of elements stored) in the list
     */
    @Override
    public int size() {
//        System.out.println(buffer.length);
        return nextFreeLoc;
    }


    /**
     * Remove the element at the specified index.
     *
     * @param index the index of the element that should be removed
     */
    @Override
    public T remove(int index) {
        /* here we remove element via index */
        //if it's valid
        if (index <= nextFreeLoc)
        {
            T removedElem = buffer[index];
            //Close the gap - move elements 1 position to the left
            for( int i = index; i<nextFreeLoc; i++)
            {
                this.growArrayIfNeeded(); // if needed
                buffer[i] = buffer[i+1];
            }

        nextFreeLoc--;
        return removedElem;
        }
//        return (T) buffer; // casting but should return some other (removed) variable?
    return null;
    }

    @Override
    public boolean remove(T elem) {
        /* here we remove element via element obj
        * code via dermot */
        boolean matchFound = false;
        for (int index = 0; index < nextFreeLoc && !matchFound; index++)
        {
            if(buffer[index].equals(elem))
            {
                matchFound = true;

                //Close the gap - move elements 1 position to the left
                for( int i = index; i<nextFreeLoc; i++)
                {
                    buffer[i] = buffer[i+1];
                }

                nextFreeLoc--;

            }
        }
        return matchFound; // false
    }

    /**
     * Private helper method to check if the currently allocated space is full.
     * If it is then it will allocate a bigger array, copy the contents, and set our
     * instance field (buffer) to refer to the newly allocated space.
     */
    private void growArrayIfNeeded()
    {
        if(nextFreeLoc == currentCapacity){
            //Allocate double the space - that will keep us going for a while
            T[] tempArr = (T[]) new Object[buffer.length * 2];

//            String[] tempArr = new String[buffer.length * 2];
            currentCapacity *= 2; // double
            //copy from the old space into the new
            for (int i = 0; i < buffer.length; i++){
                    tempArr[i] = buffer[i];
            }
            //Now, update so that our managed array points at the newly created array
            buffer = tempArr; //(T[]) no need to cast
        }
    }

    /**
     *
     * @return whether the list is empty or not
     */
    @Override
    public boolean isEmpty() {

        return (nextFreeLoc == 0);
    }

    /**
     *
     * @return the size (i.e. the number of elements stored) in the list
     */
//    public int size()
//    {
//        //System.out.println(buffer.length);
//        return nextFreeLoc;
//    }


    @Override
    public boolean contains(T element) {
        boolean matchFound = false;
        for (int index = 0; index < nextFreeLoc && !matchFound; index++){
            if(buffer[index].equals(element)){
                matchFound = true;
            }
        }
        return matchFound; // false
    }

    /* returning correct sequencing of list iteration for elements */
    @Override
    public Iterator<T> iterator() {
        return new GenericArrayListIteratorCheck(); // add class
    }

    @Override
    public String toString()
    {
        String data = "";
        for(int i = 0; i < nextFreeLoc; i++)
        {
            data += " " +buffer[i] + ",";
        }

        return "MyStringArrayList[" + data + " ]";
    }
     /* //This is IntelliJ's version of toString()
     @Override
     public String toString() {
     return "MyStringArrayList{" +
     "buffer=" + Arrays.toString(buffer) +
     '}';
     }*/

    /* new for a Generic iterator, as we want to return a true bool
    * to check if .next returns an element */
    class GenericArrayListIteratorCheck implements Iterator<T> {

        int pointer = 0; // elem being checked

        /* returns True if there is a free location
        * otherwise false if not */
        @Override
        public boolean hasNext() {
            return pointer < nextFreeLoc;
        }

        /* we simply iterate over and return element next in list (if True)
        * NoSuchElemException thrown if we have reached the limit*/
        @Override
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException(); // false, therefore throws
            }
            return buffer[pointer++];
        }
    }


    }

