package com.generics;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GenericQueueTest {

    @Test
    void enqueue() {
        GenericQueue<Integer> myQueue = new GenericQueue<>();
        myQueue.enqueue(100);
        assertEquals("100,", myQueue.toString());
    }

    @Test
    void dequeue() {
        GenericQueue<Integer> myQueue = new GenericQueue<>();
        myQueue.enqueue(100);
        myQueue.enqueue(200);
        assertEquals(100, myQueue.dequeue());
        assertEquals("200,", myQueue.toString()); // boom, working
    }

    @Test
    void first() {
        GenericQueue<Integer> myQueue = new GenericQueue<>();
        myQueue.enqueue(100);
        myQueue.enqueue(200);
        assertEquals(100, myQueue.first());
    }

    @Test
    void empty() {
        GenericQueue<Integer> myQueue = new GenericQueue<>();
        assertTrue(myQueue.empty());
        myQueue.enqueue(100);
        assertFalse(myQueue.empty());

    }

    @Test
    void iterator() {
        GenericQueue<Integer> myQueue = new GenericQueue<>();
        myQueue.enqueue(0);
        myQueue.enqueue(1);
        myQueue.enqueue(2);
        myQueue.enqueue(3);

        int i = 0;
        for (Integer j: myQueue ) {
            assertEquals(i, j);
            i++; // increment for loop
        }

        assertEquals(4, i); // working

    }
}