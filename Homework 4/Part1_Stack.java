// Part1_Stack.java

import java.util.Stack; //I will use the built in Java collections framework for this assignment

public class Part1_Stack { //new class for the

    public static void main(String[] args) { //my main method that uses an array of strings to create a stack of integers
        // Create a Stack instance
        Stack<Integer> stack = new Stack<>();

        // Test push() method
        stack.push(10);
        stack.push(20);
        stack.push(30);

        // Test peek() method
        System.out.println("Top element (peek): " + stack.peek());

        // Test pop() method
        System.out.println("Popped element: " + stack.pop());

        // Test empty() method
        System.out.println("Is stack empty? " + stack.empty());

        // Add more test cases as needed...
    }
}