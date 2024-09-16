//define the SinglyLinkedList class
public class SinglyLinkedList<E> {
    //node class
    private static class Node<E> {
        private E element;
        private Node<E> next;

        public Node(E e, Node<E> n) {
            element = e;
            next = n;
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
    tail = head; //if the list is empty then we need to make the tail point to the head 
    size++; //increment the size of the list to keep track of the number of elements in the list
}
  
    // Method to get the first element
    public E first() {
        if (isEmpty()) return null;
        return head.getElement();
    }

    // Method to check if the list is empty
    public boolean isEmpty() {
        return head == null;
    }

    //main method for testing
    public static void main(String[] args) {
        SinglyLinkedList<String> s = new SinglyLinkedList<>();
        s.addFirst("Hello");
        System.out.println(s.first());
    }
}