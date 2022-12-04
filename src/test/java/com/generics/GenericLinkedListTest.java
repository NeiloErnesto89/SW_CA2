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
    }

    @Test
    void set() {
    }

    @Test
    void get() {
    }

    @Test
    void getNode() {
    }

    @Test
    void getNodesIndex() {
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
    void testToString() {
    }

    @Test
    void iterator() {
    }
}