// Part1_Stack.java

import java.util.Stack; //I will use the built in Java collections framework for this assignment

public class Part1_Stack { //new class for the

    public static void main(String[] args) { //my main method that uses an array of strings to create a stack of integers
        // Create a Stack instance
        Stack<Integer> stack = new Stack<>();

        // Test push() method
        stack.push(10); //pushing the integer 10 onto the stack
        stack.push(20); //now pushing 20
        stack.push(30); //pushing 30

        // Test peek() method
        System.out.println("Top element (peek): " + stack.peek()); //should print 30
        System.out.println("Stack after pop: " + stack); // [10, 20]

        // Test pop() method
        System.out.println("Popped element: " + stack.pop()); //this will remove the top element, 30, and print it

        // Test empty() method
        System.out.println("Is stack empty? " + stack.empty()); //this should print false

        // Test pop() until stack is empty
        stack.pop(); // Removes 20
        stack.pop(); // Removes 10
        System.out.println("Is stack empty after popping all elements? " + stack.empty()); // true because the stack is empty now
       
        // Edge case: Trying to pop from an empty stack (will throw EmptyStackException)
        try {
            stack.pop(); // This should cause an exception
        } catch (Exception e) {
            System.out.println("Exception caught: " + e); // Expected behavior.
        }
        // Add more test cases as needed...
    }
}