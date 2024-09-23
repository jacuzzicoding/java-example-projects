// This is a simple implementation of a singly linked list in Java
public class SinglyLinkedList<E> { //define the SinglyLinkedList class
    private static class Node<E> { //define the Node class as a nested class
        private E element; //element stored in the node
        private Node<E> next; //point to the next node in the list to establish the chain
        //-----------------------------------------//
        public Node(E e, Node<E> n) { //constructor to create a node with element "e" and next node "n"
            element = e; //set the element of the node to the input element
            next = n; //establish the next node in the list
        }

        public E getElement() { return element; }
        public Node<E> getNext() { return next; }
        public void setNext(Node<E> n) { next = n; }
        // Create an empty node
    public Node() {
            this(null, null);
}
    }

    // Head of the list
    private Node<E> head;
    // Tail of the list
    private Node<E> tail;
    // Size of the list
    private int size;

    // Constructor
    public SinglyLinkedList() { //setting head and tail to null and size to 0 becasue the list is currently empty
        head = null;
        tail = null;
        size = 0;
    }

    // this is the method to add an element to the beginning of the list
    public void addFirst(E e) { 
        head = new Node<>(e, head);
        if (size == 0)  //check if the list is empty
            tail = head; //if the list is empty then we need to make the tail point to the head 
        size++; //increment the size of the list to keep track of the number of elements in the list
    }

    // Method to remove the first element
    public E removeFirst() {
        if (isEmpty()) return null; //check if the list is empty
        E answer = head.getElement();
        head = head.getNext(); //update the head to the new first element
        size--; //decrement the size of the list to adjust for the removal of the element
        if (size == 0)
            tail = null;
        return answer;
    }

    public E getFirst() {  // Method to get the first element
        if (isEmpty()) return null; //check if the list is empty
        return head.getElement(); //return the element stored in the head
    }

    // Method to check if the list is empty
    public boolean isEmpty() {
        return size == 0;
    }

    // Method to get last element in the list
    public E getLast() {
        if (isEmpty()) return null; //check if the list is empty
        return tail.getElement(); //return the element stored in the tail
    }

    // Method to get the size of the list 
    public int size() {
        return size; 
    }

    // Method to add an element to the end of the list
    public void addLast(E e) {
        Node<E> newest = new Node<>(e, null); //create a new node with the element "e" with next node as null
        if (isEmpty()) 
            head = newest; //if the list is empty we will point the head to the new node
        else 
            tail.setNext(newest); //if the list is not empty we will point the tail to the new node
        tail = newest; //update the tail to the new node
        size++; //adjust the size of the list to account for the new element
    }

    //method to traverse the list and print the elements
    public void printList() {
        Node<E> current = head; //start at the first node
        while (current != null) { //loop will end when we reach the end of the list
            System.out.print(current.getElement() + " "); //print the element of the current node
            current = current.getNext(); //move to the next node
        }
        System.out.println(); 
    }

    // Method to add a new node to a specified location (after a given node)
    public void addAfter(E e, Node<E> node) { //so once we find the node we want to add after, we can add the new node using this method
        if (node == null) { //if the node is null, we will add the new node to the beginning of the list
            addFirst(e);
            return;
        }
        Node<E> newest = new Node<>(e, node.getNext()); //create a new node with our content and point it to the next node of the given node
        node.setNext(newest); //update the next node pointer
        if (tail == node) //if the given node is the tail, we will update the tail pointer
            tail = newest;
        size++; //incrememt size
    }

    // Method to delete any node in the linked list
    public E remove(E e) { //we will remove the node with the element "e"
        if (isEmpty()) return null; 
        if (head.getElement().equals(e)) return removeFirst(); //if the element is in the head, we will remove the head

        Node<E> prev = head;
        Node<E> current = head.getNext();
        while (current != null && !current.getElement().equals(e)) {
            prev = current;
            current = current.getNext();
        }

        if (current != null) {
            prev.setNext(current.getNext()); //if the element is found, we will update the next pointer of the previous node to the next node of the current node. hope i wrote that out right
            size--; //decrement the size of the list
            if (current == tail) //if the current node is the tail, we will update the tail pointer to the previous node so it is the new tail
                tail = prev; 
            return current.getElement();
        }
        return null; //if the element is not found, we will return null
    }

    //method to create an empty node
    public Node<E> createEmptyNode() {
    return new Node<>();
    }
    //  method to create a node with a given value
    public Node<E> createNodeE(E value) {
        return new Node<>(value, null);
    }

//----------------TESTING-------------------------//

 public static void main(String[] args) {
    SinglyLinkedList<String> s = new SinglyLinkedList<>(); //using strings for this test, showing .addFirst, .addLast, .printList, and .remove.
    s.addFirst("code");
    s.addFirst("my");
    s.addFirst("Testing");
    s.addLast("!");
    System.out.println("List after adding elements:");
    s.printList();
    System.out.println("First element: " + s.getFirst());
    System.out.println("Last element: " + s.getLast());
    System.out.println("Size of the list: " + s.size());
    System.out.println("Removed first element: " + s.removeFirst());
    System.out.println("List after removing first element:");
    s.printList();
    s.remove("my");
    System.out.println("List after removing 'my':");
    s.printList();


    System.out.println("\n--- More Test Cases ---");

    SinglyLinkedList<Integer> list = new SinglyLinkedList<>(); //using int this time
    // Test isEmpty on a new list
    System.out.println("Is new list empty? " + list.isEmpty()); //showcasing the isEmpty method. should return true
    list.addFirst(3); //showcasing the addFirst method
    list.addFirst(2);
    list.addFirst(1);
    list.addLast(4); //showcasing the addLast method
    list.addLast(5);
    System.out.println("List after adding elements:");
    list.printList(); //showcasing the printList method
    System.out.println("Adding 0 after the second element to show .addAfter:");
    list.addAfter(0, list.head.getNext()); //showcasing the addAfter method
    list.printList(); 

    // Test creating an empty node
    Node<Integer> emptyNode = list.createEmptyNode(); //showcasing the createEmptyNode method
    System.out.println("Empty node created: " + (emptyNode != null)); 
 
    // Test creating a node with a value
    Node<Integer> valueNode = list.createNodeE(42); //showcasing the createNodeE method
    System.out.println("Node with value created: " + (valueNode != null && valueNode.getElement() == 42));
}
}