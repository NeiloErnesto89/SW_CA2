package com.generics;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GenericLinkedListTest {

    @Test
    void addToStart() {
    }

    @Test
    void printLList() {
    }

    @Test
    void add() {

        GenericLinkedList<String> linkedList = new GenericLinkedList<>();
        linkedList.add("Test0");
        linkedList.add("Test1");
        linkedList.add("Test2");
        linkedList.add("Test3");
        assertEquals("Test0,Test1,Test2,Test3,", linkedList.toString());
        assertEquals(4, linkedList.size());
    }

    @Test
    void testAdd() {
        GenericLinkedList<String> linkedList = new GenericLinkedList<>();
        linkedList.add("try");
        linkedList.add("to");
        linkedList.add("test");
        linkedList.add(2, "TEST");
        assertEquals("try,to,TEST,", linkedList.toString());

    }

    @Test
    void set() {
        GenericLinkedList<String> linkedList = new GenericLinkedList<>();
        linkedList.add("try");
        linkedList.add("attempt to test");
        assertEquals("attempt to test", linkedList.set(1, "step completed"));
        assertEquals("try,step completed,", linkedList.toString());
    }

    @Test
    void get() {
        GenericLinkedList<String> linkedList = new GenericLinkedList<>();
        linkedList.add("testOne");
        linkedList.add("testTwo");

        assertEquals("testOne", linkedList.get(0));
        assertEquals("testTwo", linkedList.get(1));
        assertThrows(IndexOutOfBoundsException.class, () -> linkedList.get(2)); // testing index
    }


    @Test
    void size() {
        GenericLinkedList<String> linkedList = new GenericLinkedList<>();
        /* for loop checking size test */
        for(int i = 0; i < 20; ++i) {
            assertEquals(i, linkedList.size());
            linkedList.add("a"); // passed 44ms
        }
    }

    @Test
    void remove() {
        /* index */
        GenericLinkedList<String> linkedList = new GenericLinkedList<>();
        linkedList.add("Test0");
        linkedList.add("Test1");
        linkedList.add("Test2");
        linkedList.add("Test3");


        assertEquals("Test2", linkedList.remove(2));
        assertEquals(3, linkedList.size());

    }

    @Test
    void testRemove() {
        /* remove elem*/
        GenericLinkedList<String> linkedList = new GenericLinkedList<>();
        linkedList.add("Test0");
        linkedList.add("Test1");
        linkedList.remove("Test0");
        assertEquals("Test1,", linkedList.toString());

    }

    @Test
    void isEmpty() {
        GenericLinkedList<String> linkedList = new GenericLinkedList<>();
        assertTrue(linkedList.isEmpty());
        linkedList.add("Test");
        assertFalse((linkedList.isEmpty()));
    }

    @Test
    void contains() {

        GenericLinkedList<String> linkedList = new GenericLinkedList<>();
        linkedList.add("Test0");
        linkedList.add("Test1");
        assertTrue(linkedList.contains("Test0"));
        assertTrue(linkedList.contains("Test1"));
        assertFalse(linkedList.contains("Test2"));

    }


    @Test
    void iterator() {

        GenericLinkedList<String> linkedList = new GenericLinkedList<>();
        linkedList.add("Test0");
        linkedList.add("Test1");
        linkedList.add("Test2");
        linkedList.add("Test3");
        linkedList.add("Test4"); // building list

        StringBuilder stringExpected = new StringBuilder(); //invoke new SB
        for (String string: linkedList) {
            stringExpected.append(string).append(","); // comma
        }
        assertEquals("Test0,Test1,Test2,Test3,Test4,", stringExpected.toString());
    }
}