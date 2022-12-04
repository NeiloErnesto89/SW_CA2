package com.generics;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class SimpleGenericTester {

    public static void main(String[] args) {

        /* tester 03/12/22 */
        LinkedList<String> shoppingList = new LinkedList<>();
        shoppingList.add("apples");
        shoppingList.add("bananas");
        shoppingList.add("carrots");
        shoppingList.add(0, "dates");
        shoppingList.addFirst("peanuts"); //[0]
        System.out.println(shoppingList);

        ArrayList<Integer> moneyList = new ArrayList<>();
        moneyList.add(1); moneyList.add(2); moneyList.add(3);
        System.out.println(moneyList);

//        LinkedList aaList = new LinkedList();
//        aaList.addToStart(20); aaList.addToStart(5); aaList.addToStart(15);
//        aaList.addToStart(10);
//        aaList.printList();


//        GenericArrayList<Integer> ga1List = new GenericArrayList<>();
//        ga1List.add(15);ga1List.add(22);ga1List.add(35);
////        System.out.println(ga1List.get(1));
////        System.out.println(ga1List.remove(1));
//        printArrayList("ga1List", ga1List );

        /* generic array list person object tester */
        GenericArrayList<Person> myPersonList = new GenericArrayList<>();
        myPersonList.add(new Person(35, "Smith", "Niall"));
        myPersonList.add(new Person(24, "Mbappe", "Killian"));
        myPersonList.add(new Person(42, "Given", "Shay"));
        System.out.println(myPersonList.size()); // 3
        System.out.println(myPersonList.remove(2)); // returns person removed object
        System.out.println(myPersonList.get(1)); // returns obj @ index[1]
        System.out.println(myPersonList.toString());


        GenericArrayList<String> ga2List = new GenericArrayList<>();
        ga2List.add("Pierre");ga2List.add("Franck");ga2List.add("Thierry"); ga2List.add("Leroy");
        System.out.println(ga2List.contains("Pierre")); // true
        System.out.println(ga2List.remove(1)); // Franck & removed
        printArrayList("ga2List", ga2List ); // working for Generic Array Lists

        // LL
        GenericLinkedList<String> llList = new GenericLinkedList<>();
        llList.add("Johan");llList.add("Peter");llList.add("Wolfgang");
        printLinkedList("llList", llList); // working for Generic Linked Lists

        /* generic tester 03/12/22 */
        GenericLinkedList<Integer> llNumsList = new GenericLinkedList<>();
        llNumsList.addToStart(100);
//        llNumsList.addToStart(200);
        llNumsList.addToStart(300);
        llNumsList.add(400); llNumsList.add(450); llNumsList.add(500);
        llNumsList.remove(2); // remove 450
        System.out.println(llNumsList.toString());
        System.out.println(llNumsList.get(2));
//        llNumsList.getNodesIndex(200); // 2
//        llNumsList.getNode(0); //400
        printList("llNumsList", llNumsList); // working generic tests


        GenericStack<Integer> stackList = new GenericStack<>();
        System.out.println(stackList.empty()); // bool -> true
        stackList.push(30);
        stackList.push(20);
        stackList.push(10);
        System.out.println(stackList.empty()); // bool -> false after pushing
        stackList.push(5);
        System.out.println("peeking: "+ stackList.peek()); // 5
        System.out.println("popped elem: "+ stackList.pop()); //5
        System.out.println("peeking: "+ stackList.peek()); // 10
//        printList("stackList", stackList);
        System.out.println(stackList.toString()); //[30, 20, 10]

        /* testing stack iterator */
        Iterator<Integer> myStackIterator = stackList.iterator();
        while (myStackIterator.hasNext()) {
            System.out.println("next in the stack: " + myStackIterator.next());
        } // working iterator

        GenericQueue<String> queueList = new GenericQueue<>();
        System.out.println(queueList.empty());
        queueList.enqueue("Hello"); queueList.enqueue("There");
        System.out.println(queueList.empty());
        queueList.enqueue("Harold"); queueList.enqueue("How are you?");
        System.out.println(queueList.first()); // returns current first item 'Hello'
        System.out.println(queueList.dequeue()); // removes first item in Q i.e. 'Hello'
        System.out.println(queueList.toString());

        /* testing queue iterator */
        Iterator<String> myQueueIterator = queueList.iterator();
        int i = 0;
        while (myQueueIterator.hasNext()) {
            System.out.println("next in the queue: " + myQueueIterator.next() + " @ index: " + i );
            i++;
        } // working queue iterator


    }



    /* Utilising the IList interface as a param to allows to multiply list types
     * so, we are printing vis the interface */
    private static <T> void printList(String listName, IList<T> listToPrint) {
        System.out.println(listName + " contains:");
        for(int i = 0; i < listToPrint.size(); i++)
        {
            System.out.print(listToPrint.get(i) + " ");
        }
        System.out.println();
    }

    /* Unused print list methods for sperate types of list (array and linked) */
    private static <T> void printArrayList(String listName, GenericArrayList<T> listToPrint) {
        System.out.println(listName + " contains:");
        for (int i=0; i< listToPrint.size(); i++) {
            System.out.println(listToPrint.get(i) + " ");
        }
        System.out.println();
    }

    private static <T> void printLinkedList(String listName, GenericLinkedList<T> listToPrint) {
        System.out.println(listName + " contains:");
        for (int i=0; i< listToPrint.size(); i++) {
            System.out.println(listToPrint.get(i) + " ");
        }
        System.out.println();
    }


}

