package com.generics;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GenericArrayListTest {

    GenericArrayList<String> stringGenericArrayList;
    GenericArrayList<Integer> integerGenericArrayList;
//    GenericArrayList<Person> personGenericArrayList = new GenericArrayList<>();


    /* ran before each test */
    @BeforeEach
    void setUp() {
    /* create Generic Array Lists to run test */
     stringGenericArrayList  = new GenericArrayList<>();
     integerGenericArrayList = new GenericArrayList<>();
//     personGenericArrayList = new GenericArrayList<>();
    }

    @Test
    void add() {
        /* like string object but they can be modifed */
        StringBuilder stringExpected = new StringBuilder();
        StringBuilder integerExpected = new StringBuilder();

        /* simply add 10 str, 10 ints to GenericArrayList objs and checking against
        * expected result via StringBuilder */
        for (int i = 0; i < 10; i++ ) {
            stringGenericArrayList.add("A");
            stringExpected.append("A,");

            integerGenericArrayList.add(i);
            integerExpected.append(i).append(","); //need to append comma
        }

        assertEquals(stringExpected.toString(), stringGenericArrayList.toString());
        assertEquals(integerExpected.toString(), integerGenericArrayList.toString());

    }

    @Test
    void testAdd() {
        stringGenericArrayList.add("try");
        stringGenericArrayList.add("to");
        stringGenericArrayList.add(2, "tester");
        assertEquals("try,to,tester,", stringGenericArrayList.toString());


    }

    @Test
    void set() {
    }

    @Test
    void get() {
    }

    @Test
    void size() {
    }

    @Test
    void remove() {
    }

    @Test
    void testRemove() {
    }

    @Test
    void isEmpty() {
    }

    @Test
    void contains() {
    }

    @Test
    void iterator() {
    }

    @Test
    void testToString() {
    }
}