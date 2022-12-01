package com.generics;

import java.util.Iterator;

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

        growArrayIfNeeded(); //I've farmed this out to a private "helper" method
        buffer[nextFreeLoc++] = elem;

    }

//    @Override
//    public void add(int index, T element) {
//
//    }

    /** Via Dermot
     * Add an element to a specified index. Make sure to avoid adding beyond the end of the
     * array (no gaps or bufferOverflows).
     * Also, remember to "grow" the managed array, if required. * @param index where to insert (ignore if greater than nextFreeLoc - otherwise you'll get gaps)
     * @param elem the data to insert
     */
    public void add(int index, T elem)
    {
        // if it's valid -> maybe better wayt to check
        if (index <= nextFreeLoc)
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

    @Override
    public T set(int index, T element) {
        return null;
    }

    @Override
    public T get(int index) {
        return null;
    }

    /**
     *
     * @return the size (i.e. the number of elements stored) in the list
     */
    @Override
    public int size() {
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
            //Close the gap - move elements 1 position to the left
            for( int i = index; i<nextFreeLoc; i++)
            {
                buffer[i] = buffer[i+1];
            }

            nextFreeLoc--;
        }
        return (T) buffer; // casting but should return some other (removed) variable?
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
        return matchFound;
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
            currentCapacity *= 2;
            //copy from the old space into the new
            for (int i = 0; i < buffer.length; i++){
                    tempArr[i] = buffer[i];
            }
            //Now, update so that our managed array points at the newly created array
            buffer = (T[]) tempArr;
        }
    }

    @Override
    public boolean isEmpty() {
        return (nextFreeLoc == 0);
    }




    @Override
    public boolean contains(T element) {
        boolean matchFound = false;
        for (int index = 0; index < nextFreeLoc && !matchFound; index++){
            if(buffer[index].equals(element)){
                matchFound = true;
            }
        }
        return matchFound;
    }

    @Override
    public Iterator<T> iterator() {
        return null;
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
    }

