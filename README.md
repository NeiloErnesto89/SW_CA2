<h1 align="center">CA2 - Software Development: Data Structures & Algorithms  </h1>

<h2 align="center">Java Generics</h2>

*Student Name and Number: Neil S (L00177606)*

## **Project Brief**

The following project...

CA2 Requirements 

* Requirement 1: GenericArrayList and GenericLinkedList classes:
The GenericArrayList and GenericLinkedList classes
should implement the following interface 
* Requirement 2: Requirement 2: GenericStack and GenericQueue Classes:
Classes to implement are the IStack and IQueue interfaces given

* Use Maven in tandem with Junit as a build management tool to help us 
* undertake our testing. It gives us our structure

SRC folder subdivided into main & test (test acting as associated java folder, mirroring the java folder)
The goal of unit testing to test individual units/blocks of code (e.g. methods) within a class.
The idea is to commit to testing early and consistently. Rerun unit tests (regression) to check for potential knock on effects.

Mainly use pom.xml file (Maven) for adding dependencies 

1. Abstraction Example
```java
public abstract class Shape
```

Below is a snippet of working Unit Test code
```java
class GenericArrayListTest { 

@Test
    void add() {
    /* like string object but they can be modifed */
    StringBuilder stringExpected = new StringBuilder();
    StringBuilder integerExpected = new StringBuilder();

    /* simply add 10 str, 10 ints to GenericArrayList objs and checking against
     * expected result via StringBuilder */
    for (int i = 0; i < 10; i++) {
        stringGenericArrayList.add("A");
        stringExpected.append("A,");

        integerGenericArrayList.add(i);
        integerExpected.append(i).append(","); //need to append comma
    }

    assertEquals(stringExpected.toString(), stringGenericArrayList.toString());
    assertEquals(integerExpected.toString(), integerGenericArrayList.toString());

}
```


## Potential Improvements


## Credits
ATU Donegal Software Development Course Material

### Final Points

Written by Neil S(L00177606).

Thanks very much and please reach out if more information is needed.

> NOTE: This project was created for educational purposes.