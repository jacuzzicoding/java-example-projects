/define the SinglyLinked class
public class SinglyLinked<E> {
//node class
    private static class Node<E> {
        // Node implementation
    }
// define the SinglyLinkedList class
private E element;
private SinglyLinked<E> next;
public SinglyLinked(E e, SinglyLinked<E> n) {
    element = e;
    next = n;
}
public E getElement() { return element;}
}
private main;
public static void main(String[] args) {
    SinglyLinked<String> s = new SinglyLinked<String>("Hello", null);
    System.out.println(s.getElement());
}
 
    // SinglyLinkedList methods
    // (create, add, delete, etc.)

    // Main method for testing
    public static void main(String[] args) {
        // Test cases
    }
}