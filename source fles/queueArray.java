import java.util.NoSuchElementException;

public class queueArray { //constructor i will use to make the queue
    //need class variables
        //pointers etc
    int[] queue; //this will be my array to store the elements
    int front; //this will be a pointer to the first element
    int rear; //this will point to the tail element
    int size; //this will track how many elements we have
    int capacity; //this will store the maximum size of the array

     // Constructor
     public queueArray(int capacity) {
        this.capacity = capacity;
        this.queue = new int[capacity];
        this.front = 0;
        this.rear = -1;
        this.size = 0;
    }

    public void enqueue(int element) { //need to update this to be enqueue
        //check if size == capacity 
        if (isFull()) {
            throw new IllegalStateException("Queue is currently full"); //if so, return an exception
        }
        rear = (rear + 1) % capacity; //we need to set the rear to where our new element will go
        queue[rear] = element; //add the element at the rear
        size++; //increase the size to allow the element to be added
    }

    public int dequeue() { //need to update this to be dequeue
        //check if size == empty 
        if (isEmpty()){
            throw new IllegalStateException("Queue is currently empty! No item to remove"); //if it is, return an exception
        }
        int dequeuedElement = queue[front]; //store the front element as the element we will remove
        front = (front + 1) % capacity; //move the front pointer and wrap around 
        size--; //decrease the size now that our element is gone
        return dequeuedElement; //return the removed element
    }


    public int first() { //this will give me the first element
        if (isEmpty()) {
            throw new NoSuchElementException("The Queue is currently empty"); // Throw an exception if the queue is empty
        }
        return queue[front]; //this will return the front element of the queue
    }

    public boolean isEmpty() { //this will check if the queue is empty
        return size == 0; //return true if the queue is empty
    }

    public boolean isFull() {
        return (size == capacity);
    }

    public int size() {
        return size;
    }
    // Test cases
    public static void main(String[] args) {
        queueArray queue = new queueArray(5);
    
        // Test 1: isEmpty on a new queue
        System.out.println("Test 1: " + (queue.isEmpty() ? "Passed" : "Failed"));
    
        // Test 2: Enqueue elements
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        System.out.println("Test 2: " + (queue.size() == 3 ? "Passed" : "Failed"));
    
        // Test 3: First element
        System.out.println("Test 3: " + (queue.first() == 1 ? "Passed" : "Failed"));
    
        // Test 4: Dequeue
        int dequeued = queue.dequeue();
        System.out.println("Test 4: " + (dequeued == 1 && queue.size() == 2 ? "Passed" : "Failed"));
    
        // Test 5: Enqueue to full capacity
        queue.enqueue(4);
        queue.enqueue(5);
        queue.enqueue(6); // Enqueue the fifth element
        try {
            queue.enqueue(7); // This should throw an exception
            System.out.println("Test 5: Failed");
        } catch (IllegalStateException e) {
            System.out.println("Test 5: Passed");
        }
    
        // Test 6: Dequeue until empty
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        System.out.println("Test 6: " + (queue.isEmpty() ? "Passed" : "Failed"));
    
        // Test 7: Dequeue from empty queue
        try {
            queue.dequeue(); // This should throw an exception
            System.out.println("Test 7: Failed");
        } catch (IllegalStateException e) {
            System.out.println("Test 7: Passed");
        }
    
        // Test 8: First on empty queue
        try {
            queue.first(); // This should throw an exception
            System.out.println("Test 8: Failed");
        } catch (NoSuchElementException e) {
            System.out.println("Test 8: Passed");
        }
    }    
}
