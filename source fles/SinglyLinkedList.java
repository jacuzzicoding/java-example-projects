public class SinglyLinkedList<E> { //define the SinglyLinkedList class
    private static class Node<E> { //define the Node class as a nested class
        private E element; //element stored in the node
        private Node<E> next; //point to the next node in the list to establish the chain
        //-----------------------------------------//
        public Node(E e, Node<E> n) { //construcor to create a node with element "e" and next node "n"
            element = e; //set the element of the node to the element passed in the constructor
            next = n; //set the next node to the node passed in the constructor
        }

        public E getElement() { return element; }
    }

    // Head of the list
    private Node<E> head;

    // Constructor
    public SinglyLinkedList() {
        head = null;
    }

    // Other methods (to be implemented)
    // e.g., add, delete, etc.
    // this is the method to add an element to the beginning of the list
    public void addFirst (E,e){
        head = new Node<>(e,head); 
        if size == 0  //check if the list is empty
        then tail = head; //if the list is empty then we need to make the tail point to the head 
        size++; //increment the size of the list to keep track of the number of elements in the list
    }
    // Method to remove the first element
    public E removeFirst(){
        if (isEmpty()) return null; //check if the list is empty
    }
    public E getFirst() {  // Method to get the first element
        if (isEmpty()) return null; //check if the list is empty
        return head.getElement(); //return the element stored in the head
        head = head.getNext(); //update the head to the new first element
        size--; //decrement the size of the list to adjust for the removal of the element
    }
    // Method to check if the list is empty
    public boolean isEmpty() {
        return head == null;
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
        Node<E> newest = new Node<E> (e, null); //create a new node with the element "e" with next node as null
        if (isEmpty()) 
            head = newest; //if the list is empty we will point the head to the new node
        else 
            tail.setNext(newest); //if the list is not empty we will point the tail to the new node
            tail = newest; //update the tail to the new node
            size++; //adjust the size of the list to account for the new element
        //need adjust second to last node to point to the new node?
    }
//method to traverse the list and print the elements
    public void printList(){
        Node<E> current = head; //start at the first node
        while (current != null){ //loop will end when we reach the end of the list
            System.out.println(current.getElement()); //print the element of the current node
            System.out.println(current.getNext()); //print the next node. will be null if we are at the end of the list
            current = current.getNext(); //move to the next node
        }
    }


    //main method for testing
    public static void main(String[] args) {
        SinglyLinkedList<String> s = new SinglyLinkedList<>();
        s.addFirst("Hello");
        System.out.println(s.getFirst());
    }
}