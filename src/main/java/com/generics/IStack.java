package com.generics;

/* A stack is LIFO (last in, first out). It is a linear data struct & an
* abstract data type. Main operations are push & pop. Push adds element
* to the top of the stack (or initialises empty stack). Pop removes element from
* top of stack. If the stack is full (not enough memory/space) to add an element, it
* is in a state of overflow, hence StackOverFLow */

public interface IStack <T> {
    /**
     * Pushes an item onto the top of this stack
     * @param element the element argument.
     */
    public void push(T element);
    /**
     * Removes the object at the top of this stack and returns that
     * object as the value of this function.
     *
     * @return The object at the top of this stack
     */
    public T pop(); //throw EmptyStackException as appropriate
    /**
     * Looks at the object at the top of this stack without removing it
     * from the stack.
     *
     * @return the object at the top of this stack
     */
    public T peek(); //throw EmptyStackException as appropriate
    /**
     * Tests if this stack is empty.
     *
     * @return {@code true} if and only if this stack contains
     * no items; {@code false} otherwise.
     */
    public boolean empty();


}
