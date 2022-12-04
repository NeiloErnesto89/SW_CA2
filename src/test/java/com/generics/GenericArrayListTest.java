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
        assertThrows(IndexOutOfBoundsException.class, () -> stringGenericArrayList.add(4, "again"));
    }

    @Test
    void set() {
        stringGenericArrayList.add("one");
        assertEquals("one", stringGenericArrayList.set(0, "two"));
        assertEquals("two,", stringGenericArrayList.toString()); // true (don't forget comma)
        assertThrows(IndexOutOfBoundsException.class, () -> stringGenericArrayList.set(2, "Index can not be out of Bounds"));

    }

    @Test
    void get() {
        stringGenericArrayList.add("TestOne");
        stringGenericArrayList.add("TestTwo");
        assertEquals("TestOne", stringGenericArrayList.get(0));
        assertEquals("TestTwo", stringGenericArrayList.get(1));
        assertThrows(IndexOutOfBoundsException.class, () -> stringGenericArrayList.get(2));

    }

    @Test
    void size() {
        for (int i = 0; i < 20; i++) {
            assertEquals(i, integerGenericArrayList.size());
            integerGenericArrayList.add(i);
        }

    }

    @Test
    void remove() {
        /* via index */
        stringGenericArrayList.add("TestOne");
        stringGenericArrayList.add("TestTwo");

        assertEquals("TestTwo", stringGenericArrayList.remove(1));
        assertEquals(1, stringGenericArrayList.size());
        assertThrows(IndexOutOfBoundsException.class, () -> stringGenericArrayList.get(2));

    }

    @Test
    void testRemove() {
        /* via element */
        stringGenericArrayList.add("TestOne");
        stringGenericArrayList.add("TestTwo");

        assertTrue(stringGenericArrayList.remove("TestTwo"));
        assertEquals(1, stringGenericArrayList.size());

    }


    @Test
    void isEmpty() {
        assertTrue(stringGenericArrayList.isEmpty());
        stringGenericArrayList.add("TestOne");
        assertFalse(stringGenericArrayList.isEmpty());

    }

    @Test
    void contains() {
        stringGenericArrayList.add("TestOne");
        assertTrue(stringGenericArrayList.contains("TestOne"));
        assertFalse(stringGenericArrayList.contains("TestTwo"));

    }

    @Test
    void iterator() {
        stringGenericArrayList.add("Test0");
        stringGenericArrayList.add("Test1");
        stringGenericArrayList.add("Test2");
        stringGenericArrayList.add("Test3");
        stringGenericArrayList.add("Test4");

        int i = 0;
        for (String string: stringGenericArrayList ) {
            assertEquals("Test"+i, string);
            i++; // increment for loop
        }

        assertEquals(5, i); // working


    }

}