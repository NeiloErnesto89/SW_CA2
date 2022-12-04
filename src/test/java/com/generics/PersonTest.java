package com.generics;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/* generated Person test file */
class PersonTest {

    private Person personTester; //person obj


    /* invoked before each test */
    @BeforeEach
    void setUp() {
        personTester = new Person(30, "Murphy", "Niall");
    }


    @Test
    void getFirstname() {
        assertEquals("Niall", personTester.getFirstname());
    }

    @Test
    void getSurname() {
        assertEquals("Murphy", personTester.getSurname());
    }

    @Test
    void getAge() {
        assertEquals(30, personTester.getAge());
    }

    /* FYI via person class -> The natural ordering will be determined by age in this example
    * so we are comparing object by order -> so personTester (age) 30, so as 30>15 for person1, 1 (positive)
    * is returned. 0 as it's equal and -1 for negative (30<52)*/
    @Test
    void compareTo() {
        Person person1 = new Person(15, "Murphy", "Niall");
        Person person2 = new Person(30, "Murphy", "Niall"); // same age 0
        Person person3 = new Person(52, "O'Hara", "Maureen");

        assertEquals(1, personTester.compareTo(person1));
        assertEquals(0, personTester.compareTo(person2));
        assertEquals(-1, personTester.compareTo(person3));
    }

    /* replicate toString output here */
    @Test
    void testToString() {
        String expectedString = "Person{" +
                "firstname='Niall" + '\'' +
                ", surname='Murphy" + '\'' +
                ", age=30" +
                '}';

        assertEquals(expectedString, personTester.toString());

    }
}