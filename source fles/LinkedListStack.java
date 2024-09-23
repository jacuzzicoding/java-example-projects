import java.util.EmptyStackException;

// This is an implementation of a stack using a singly linked list in Java
public class LinkedListStack<E> {
    private SinglyLinkedList<E> list; // The underlying linked list to store stack elements

    // Constructor to initialize an empty stack
    public LinkedListStack() {
        list = new SinglyLinkedList<>();
    }

    // Method to add an element to the top of the stack
    public void push(E element) {
        list.addFirst(element); // Add the element to the front of the list (top of the stack)
    }

    // Method to remove and return the top element from the stack
    public E pop() {
        if (isEmpty()) {
            throw new EmptyStackException(); // Throw an exception if the stack is empty
        }
        return list.removeFirst(); // Remove and return the first element of the list (top of the stack)
    }

    // Method to return the top element without removing it
    public E top() {
        if (isEmpty()) {
            throw new EmptyStackException(); // Throw an exception if the stack is empty
        }
        return list.getFirst(); // Return the first element of the list (top of the stack)
    }

    // Method to return the number of elements in the stack
    public int size() {
        return list.size(); // Return the size of the underlying list
    }

    // Method to check if the stack is empty
    public boolean isEmpty() {
        return list.isEmpty(); // Check if the underlying list is empty
    }

    //----------------TESTING-------------------------//
    // Main method for testing the LinkedListStack implementation
    public static void main(String[] args) {
        LinkedListStack<Integer> stack = new LinkedListStack<>();

        System.out.println("Testing push and top:");
        stack.push(10);
        stack.push(20);
        stack.push(30);
        System.out.println("Top element: " + stack.top());

        System.out.println("\nTesting pop:");
        System.out.println("Popped element: " + stack.pop());
        System.out.println("New top element: " + stack.top());

        System.out.println("\nTesting size:");
        System.out.println("Stack size: " + stack.size());

        System.out.println("\nTesting isEmpty:");
        System.out.println("Is stack empty? " + stack.isEmpty());

        System.out.println("\nPopping remaining elements:");
        while (!stack.isEmpty()) {
            System.out.println("Popped: " + stack.pop());
        }

        System.out.println("Is stack empty now? " + stack.isEmpty());

        // Test exception handling
        try {
            stack.pop();
        } catch (EmptyStackException e) {
            System.out.println("Correctly threw EmptyStackException when popping from empty stack");
        }
    }

    // Embedded SinglyLinkedList class to support the stack operations
    private static class SinglyLinkedList<E> {
        // Node class to represent elements in the linked list
        private static class Node<E> {
            private E element; // Element stored in the node
            private Node<E> next; // Reference to the next node in the list

            // Constructor to create a node with element "e" and next node "n"
            public Node(E e, Node<E> n) {
                element = e;
                next = n;
            }

            public E getElement() { return element; }
            public Node<E> getNext() { return next; }
            public void setNext(Node<E> n) { next = n; }
        }

        private Node<E> head; // Head of the list
        private Node<E> tail; // Tail of the list
        private int size; // Size of the list

        // Constructor to create an empty list
        public SinglyLinkedList() {
            head = null;
            tail = null;
            size = 0;
        }

        // Method to add an element to the beginning of the list
        public void addFirst(E e) {
            head = new Node<>(e, head);
            if (size == 0) // Check if the list was empty
                tail = head; // If the list was empty, the new node is both head and tail
            size++; // Increment the size of the list
        }

        // Method to remove the first element
        public E removeFirst() {
            if (isEmpty()) return null; // Check if the list is empty
            E answer = head.getElement();
            head = head.getNext(); // Update the head to the next node
            size--; // Decrement the size of the list
            if (size == 0)
                tail = null; // If the list is now empty, update the tail
            return answer;
        }

        // Method to get the first element
        public E getFirst() {
            if (isEmpty()) return null; // Check if the list is empty
            return head.getElement(); // Return the element stored in the head
        }

        // Method to check if the list is empty
        public boolean isEmpty() {
            return size == 0;
        }

        // Method to get the size of the list
        public int size() {
            return size;
        }
    }
}