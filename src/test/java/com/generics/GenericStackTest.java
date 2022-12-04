package com.generics;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GenericStackTest {

    @Test
    void push() {
        /* using genericArray int*/
        GenericArrayList<Integer> gAList = new GenericArrayList<>();
        gAList.add(1);
        gAList.add(2);
        gAList.add(3);

        /* calling generic stack obj */
        GenericStack<Integer> stackList = new GenericStack<>(gAList); // adding items to stack
        stackList.push(4);
        stackList.push(5);
        stackList.pop(); // pop 5

        assertEquals("1,2,3,4,", stackList.toString());

    }

    @Test
    void pop() {

        GenericArrayList<Integer> gAList = new GenericArrayList<>();
        gAList.add(100);
        gAList.add(200);
        gAList.add(300);
        gAList.add(330);

        /* calling generic stack obj */
        GenericStack<Integer> stackList = new GenericStack<>(gAList); // adding items to stack
        assertEquals(330, stackList.pop());
        assertEquals("100,200,300,", stackList.toString());


    }

    @Test
    void peek() {
        GenericArrayList<Integer> gAList = new GenericArrayList<>();
        gAList.add(100);
        gAList.add(200);
        gAList.add(300);
        gAList.add(330);

        /* calling generic stack obj */
        GenericStack<Integer> stackList = new GenericStack<>(gAList);
        assertEquals(330, stackList.peek());
        assertEquals("100,200,300,330,", stackList.toString());

    }

    @Test
    void empty() {
        GenericStack<Integer> stackList = new GenericStack<>();
        assertTrue(stackList.empty());
        stackList.push(1000);
        assertFalse(stackList.empty());
    }

    @Test
    void iterator() {
        GenericStack<Integer> stackList = new GenericStack<>();
        stackList.push(0);
        stackList.push(1);
        stackList.push(2);

        int i = 0;
        for (Integer j: stackList ) {
            assertEquals(i, j);
            i++; // increment for loop
        }

        assertEquals(3, i); // working for num of loops

    }


}