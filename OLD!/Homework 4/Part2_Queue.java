import java.util.LinkedList;
import java.util.Queue;
import java.util.NoSuchElementException;

public class Part2_Queue {
    public static void main(String[] args) {
        // Create a Queue instance using LinkedList array implementation
        Queue<String> queue = new LinkedList<>();

        // Test offer() method (adds elements)
        System.out.println("Testing offer() method:");
        queue.offer("First");
        queue.offer("Second");
        queue.offer("Third");
        System.out.println("Queue after offers: " + queue); // [First, Second, Third]

        // Test peek() method
        System.out.println("\nTesting peek() method:");
        System.out.println("Front element (peek): " + queue.peek()); // Should be "First"
        System.out.println("Queue after peek: " + queue); // Should be the same because its just peek

        // Test poll() method
        System.out.println("\nTesting poll() method:");
        System.out.println("Removed element: " + queue.poll()); // Removes and returns "First"
        System.out.println("Queue after poll: " + queue); // [Second, Third]

        // Test element() method
        System.out.println("\nTesting element() method:");
        System.out.println("Front element: " + queue.element()); // Should be "Second"

        // Test size and isEmpty
        System.out.println("\nTesting size and isEmpty:");
        System.out.println("Queue size: " + queue.size());
        System.out.println("Is queue empty? " + queue.isEmpty());

        // Clear the queue
        queue.clear();
        System.out.println("\nQueue after clear(): " + queue);

        // Test edge cases
        System.out.println("\nTesting edge cases:");
        System.out.println("Poll from empty queue: " + queue.poll()); // Should return null

        try {
            queue.element(); // Should throw exception
        } catch (NoSuchElementException e) {
            System.out.println("Exception caught when calling element() on empty queue: " + e);
        }

        // Test adding null element to the queue to see if it throws an exception or not
        try {
            queue.offer(null);
            System.out.println("Null element added successfully");
        } catch (NullPointerException e) {
            System.out.println("Queue doesn't accept null elements");
        }
    }
}