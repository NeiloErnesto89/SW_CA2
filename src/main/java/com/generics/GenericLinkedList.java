package com.generics;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* LinkedList key is the  link, which is a reference, to
* the next element in the list. Element are known as Nodes.
* Starting node is 'head' */

public class GenericLinkedList<T> implements IList<T> {

    private Node head = null; // head of list
    private Node tail = null;
    private int count;

    /* adding param element to the start of list */
    public void addToStart(T val)
    {
//        Node newNode = new Node(val);
        Node newNode = new Node(val);
        newNode.next = head; // next = null as it's start
        head = newNode; //replace head null with start val

        /* check size list -> if empty set tail as also newNode */
        if (size() == 0) {
            tail = newNode;
        }
        count++; // increment count to keep track
    }

    public void printLList()
    {
        //us this to "walk" or traverse the list
        Node current = head;
        while(current != null){
            System.out.print(current.data + ", ");
            current = current.next;
        }
    }

    @Override
    public void add(T elem) {
        Node end = tail; // tail Node ll
        Node newNode = new Node(elem);
        tail = newNode; //assign tail newNode

        if (end == null) {
            head = newNode;
        }
        else {
            end.next = newNode;
        }

        count++; // increment count -> maybe ship to helper method?

    }
    /* add elemenet @ index -> might also need: 'throws an IndexOutOfBoundsException
    * where appropriate' as per IList */
    @Override
    public void add(int index, T element) {

        /* check if index is in bounds? Maybe check OR logic w/ size()
        * if true, throw new exception  */
        if (index < 0 || index > size() ) {
            throw new IndexOutOfBoundsException("The Index is out of Bounds");
        }

        if (index == 0) {
            /* it must be the first (index) element */
            addToStart(element);
        }
        else if (index == size()) {
            add(element); // add to end
        }
        else {
            /* here we set the new node and shift the previous one down */
            Node newNode = new Node(element);
            Node previousNode = getNode(index -1); // previous hence -1
            Node nextNode = getNode((index));
            previousNode.next = newNode;
            nextNode.next = nextNode;

            count++; // increment (+1) count list size
        }


    }

    /* setting new ll node element at given index, replacing the elem at index*/
    @Override
    public T set(int index, T element) {

        Node currNode = getNode(index); // get node at given indexi

        if (currNode != null) {
        T previousData = currNode.data; //assign current node data to prev var
        currNode.data = element; // adding T elem data to curr
        return previousData;
        }
        else {
            return null;
        }

//        return null;
    }
    /* here we return element [index] position*/
    @Override
    public T get(int index) {
        if (index == size() - 1) {
            return tail.data; // return tail element data
        }
//        else
        Node node = getNode(index);

        if (node == null)
            return null;
        else
//            System.out.println("Here is data via get(): " + node.data);
            return node.data; // return nodes data

    }

    /* method to get node at a specific index in list */

    public Node getNode(int index) {
        /* check if out of bounds index */
        if ((index < 0) || (index >= size())) {
            throw new IndexOutOfBoundsException("The Index is out of Bounds");
        }

        Node curr = head; // current node is head
        /* while loop to check if current is not empty */
        int i = 0;
        while (curr != null) {

            if (i == index) {
//                System.out.println("Here is the node via getNode(): " + curr);
                return curr; // @index
            }
            curr = curr.next; // next node
            i++; // increment
        }
        return null;
    }

    /* simple method to return index of given elem */
    public int getNodesIndex(T elem) {

        Node curr = head;

        int i = 0;
        while (curr != null) {
            if (curr.data.equals(elem)) { //
                System.out.println("Here is nodes index: " + i);
                return i; // return computed index
            }
            curr = curr.next;
            i++; // increment i in while loop
        }
        return -1; //throw away
    }

    /* returns the int size (len) of the list*/
    @Override
    public int size() {
//        System.out.println("here is count :" + count);
        return count;
    }

    /* method to remove element at given index */
    @Override
    public T remove(int index) {

        Node removedNode = getNode(index); //get Node to be removed
        Node previousNode;

        if (index == 0 ) {
            previousNode = head.next;
            head = previousNode; // set head as prev node
        }
        else {
            previousNode = getNode((index - 1));
        }

        /* if index = 1 (1-1=0), we set tail as null */
        if (previousNode == null) {
            tail = null;
        }
        else if ((index + 1) >= size()) {
            previousNode.next = null;
            tail = previousNode;
        }
        else {
            previousNode = getNode((index + 1));
        }

        count--; // decrement count as node is removed
        System.out.println("removed element's replacement : " + removedNode.data);
        return removedNode.data;
    }

    /* remove element with param just the given element
    * we need to retrieve the index and call other remove method
    * return bool - true or false ir it was removed or not */
    @Override
    public boolean remove(T elem) {
        /* check if empty */
        if (isEmpty()) {
            return false;
        }

        int nodeIndex = getNodesIndex(elem);
        if (nodeIndex < 0 ) {
            return false;
        }
        remove(nodeIndex); // remove element via method w/ index
        return true; // bool

    }

    @Override
    public boolean isEmpty() {
        return size() == 0; // true if list is empty else false
    }

    /* check if list contains a particular element
    * returns bool if it was found or not*/
    @Override
    public boolean contains(T element) {
        System.out.println("Checking contains method with: " + element);
        return getNodesIndex(element) >= 0 ; // if number found, true
    }

    @Override
    public String toString() {
        Node curr = head;
        return "GenericLinkedList{" +
                "head=" + curr.data +
                ", tail=" + tail.data +
                ", count=" + count +
                '}';
    }



    /* Linked list Node via Dermot notes */
    private class Node {

        /* the current node's data/info (type any) */
        T data;

        /* next node in linked list but null if no next node */
        Node next;

        // Constructor to create a new node
        Node(T dataV) {
            data = dataV;
            next = null;
        }

        Node(T dataV, Node nextV) {
            data = dataV;
            next = nextV;

        }
        /* generate getters & setters*/
        public T getData() {
            return data;
        }

        public void setData(T dataV) {
            data = dataV;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node nextV) {
            next = nextV;
        }
    }

    /* Returns an iterator over the elements in this list in proper sequence.*/
    @Override
    public Iterator<T> iterator() {

        return new GenericLinkedListIterator();
    }


    //   some info:  https://stackoverflow.com/questions/40322092/using-generic-in-linkedlist-that-implements-iterable
    class GenericLinkedListIterator implements Iterator<T> {

        Node curr = head; // current head node

        @Override
        public boolean hasNext() {
            return curr != null; // True  curr is not empty
        }

        /* simply returns next element in the list */
        @Override
        public T next() {
            /* if hasNext is false (empty) */
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            T data = curr.data;
            curr = curr.next;
            return data;
        }
    }

}
