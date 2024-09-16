public class DoublyLinkedList<E> {
    private static class Node<E> { //define the Node class as a nested class
        private E element; //element stored in the node
        private Node<E> prev; //pointer to the previous node in the list
        private Node<E> next; //pointer to the next node in the list to establish the chain

        public Node(E e, Node<E> p, Node<E> n) { //constructor to create a node with element "e", previous node "p", and next node "n"
            element = e;
            prev = p; //doubly linked lists need this extra pointer
            next = n;
        }

        public E getElement() { return element; }
        public Node<E> getPrev() { return prev; }
        public Node<E> getNext() { return next; }
        public void setPrev(Node<E> p) { prev = p; }
        public void setNext(Node<E> n) { next = n; }

        // Create an empty node
        public Node() {
            this(null, null, null);
        }
    }

    // Header node
    private Node<E> header;
    // Trailer node
    private Node<E> trailer;
    // Size of the list
    private int size;

    // Constructor
    public DoublyLinkedList() { //setting up header and trailer sentinel nodes
        header = new Node<>(null, null, null);
        trailer = new Node<>(null, header, null);
        header.setNext(trailer);
        size = 0;
    }

    // Method to get the size of the list 
    public int size() { return size; }

    // Method to check if the list is empty
    public boolean isEmpty() { return size == 0; }

    // Method to get the first element in the list
    public E first() {
        if (isEmpty()) return null; //check if the list is empty
        return header.getNext().getElement(); //return the element stored in the first actual node
    }

    // Method to get last element in the list
    public E last() {
        if (isEmpty()) return null; //check if the list is empty
        return trailer.getPrev().getElement(); //return the element stored in the last actual node
    }

    // Method to add an element to the beginning of the list
    public void addFirst(E e) {
        addBetween(e, header, header.getNext());
    }

    // Method to add an element to the end of the list
    public void addLast(E e) {
        addBetween(e, trailer.getPrev(), trailer);
    }

    // Method to remove the first element
    public E removeFirst() {
        if (isEmpty()) return null; //check if the list is empty
        return remove(header.getNext());
    }

    // Method to remove the last element
    public E removeLast() {
        if (isEmpty()) return null; //check if the list is empty
        return remove(trailer.getPrev());
    }

    // Private method to add an element between two existing nodes
    private void addBetween(E e, Node<E> predecessor, Node<E> successor) {
        Node<E> newest = new Node<>(e, predecessor, successor);
        predecessor.setNext(newest);
        successor.setPrev(newest);
        size++; //increment the size of the list to keep track of the number of elements
    }

    // Private method to remove a given node from the list
    private E remove(Node<E> node) {
        Node<E> predecessor = node.getPrev();
        Node<E> successor = node.getNext();
        predecessor.setNext(successor);
        successor.setPrev(predecessor);
        size--; //decrement the size of the list to adjust for the removal of the element
        return node.getElement();
    }

    // Method to add a new node to a specified location (after a given node)
    public void addAfter(E e, Node<E> node) {
        if (node == null || node == trailer) { //if the node is null or trailer, we will add the new node to the end of the list
            addLast(e);
            return;
        }
        addBetween(e, node, node.getNext());
    }

    // Method to add a new node to a specified location (before a given node)
    public void addBefore(E e, Node<E> node) {
        if (node == null || node == header) { //if the node is null or header, we will add the new node to the beginning of the list
            addFirst(e);
            return;
        }
        addBetween(e, node.getPrev(), node);
    }

    // Method to delete any node in the linked list
    public E remove(E e) {
        if (isEmpty()) return null; 
        Node<E> current = header.getNext();
        while (current != trailer) {
            if (current.getElement().equals(e)) {
                return remove(current);
            }
            current = current.getNext();
        }
        return null; //if the element is not found, we will return null
    }

    //method to traverse the list and print the elements
    public void printList() {
        Node<E> current = header.getNext(); //start at the first actual node
        while (current != trailer) { //loop will end when we reach the trailer
            System.out.print(current.getElement() + " "); //print the element of the current node
            current = current.getNext(); //move to the next node
        }
        System.out.println(); 
    }

    //method to create an empty node
    public Node<E> createEmptyNode() {
        return new Node<>();
    }

    //method to create a node with a given value
    public Node<E> createNodeWithValue(E value) {
        return new Node<>(value, null, null);
    }

    //----------------TESTING-------------------------//
    public static void main(String[] args) {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();

        // Test isEmpty on a new list
        System.out.println("Is new list empty? " + list.isEmpty()); //showcasing the isEmpty method. should return true

        list.addFirst(3); //showcasing the addFirst method
        list.addFirst(2);
        list.addFirst(1);
        list.addLast(4); //showcasing the addLast method
        list.addLast(5);

        System.out.println("List after adding elements:");
        list.printList(); //showcasing the printList method

        System.out.println("Adding 0 after the second element:");
        list.addAfter(0, list.header.getNext().getNext()); //showcasing the addAfter method
        list.printList();

        System.out.println("Adding -1 before the third element:");
        list.addBefore(-1, list.header.getNext().getNext().getNext()); //showcasing the addBefore method
        list.printList();

        System.out.println("First element: " + list.first());
        System.out.println("Last element: " + list.last());
        System.out.println("Size of the list: " + list.size());

        System.out.println("Removed first element: " + list.removeFirst());
        System.out.println("List after removing first element:");
        list.printList();

        System.out.println("Removed last element: " + list.removeLast());
        System.out.println("List after removing last element:");
        list.printList();

        list.remove(0);
        System.out.println("List after removing 0:");
        list.printList();

        // Test creating an empty node
        Node<Integer> emptyNode = list.createEmptyNode(); //showcasing the createEmptyNode method
        System.out.println("Empty node created: " + (emptyNode != null));

        // Test creating a node with a value
        Node<Integer> valueNode = list.createNodeWithValue(42); //showcasing the createNodeWithValue method
        System.out.println("Node with value created: " + (valueNode != null && valueNode.getElement() == 42));
    }
}