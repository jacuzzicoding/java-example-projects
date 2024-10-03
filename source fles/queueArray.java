import java.util.NoSuchElementException;

public class queueArray { //constructor i will use to make the queue
    //need class variables
        //pointers etc
    int[] queue; //this will be my array to store the elements
    int front; //this will be a pointer to the first element
    int rear; //this will point to the tail element
    int size; //this will track how many elements we have
    int capacity; //this will store the maximum size of the array

    //structure  x

    public void enqueue(int element) { //need to update this to be enqueue
        //check if size == capacity 
        if isFull() {
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
}
