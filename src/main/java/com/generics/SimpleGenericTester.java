package com.generics;

import java.util.ArrayList;
import java.util.LinkedList;

public class SimpleGenericTester {

    public static void main(String[] args) {

        /* tester 03/12/22 */
        LinkedList<String> shoppingList = new LinkedList<>();
        shoppingList.add("apples");
        shoppingList.add("bananas");
        shoppingList.add("carrots");
        shoppingList.add(0, "dates");
        System.out.println(shoppingList);

        ArrayList<Integer> moneyList = new ArrayList<>();
        moneyList.add(1);
        moneyList.add(2);
        moneyList.add(3);
        System.out.println(moneyList);

        GenericArrayList<Integer> aList = new GenericArrayList<>();
        aList.add(15);aList.add(22);aList.add(35);
        printArrayList("aList", aList );

        GenericArrayList<String> bList = new GenericArrayList<>();
        bList.add("Pierre");bList.add("Franck");bList.add("Thierry");
        printArrayList("bList", bList ); // working for Generic Array Lists

        // LL
//        GenericLinkedList<String> llList = new GenericLinkedList<>();
//        llList.add("Johan");llList.add("Peter");llList.add("Wolfgang");
//        printLinkedList("llList", llList);
    }

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

