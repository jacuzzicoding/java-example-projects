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
        if (size == capacity) {
            throw new IllegalStateException("Queue is currently full"); //if not, return an exception
        }
        rear = (rear + 1) % capacity; //we need to set the rear to where our new element will go
        queue[rear] = element; //add the element at the rear
        size++; //increase the size to allow the element to be added
    }

    //dequeue method will go here

    public int first() { //this will give me the first element
        if (isEmpty()) {
            throw new NoSuchElementException("The Queue is currently empty"); // Throw an exception if the queue is empty
        }
        return queue[front]; //this will return the front element of the queue
    }

    public boolean isEmpty() { //this will check if the queue is empty
        return size == 0; //return true if the queue is empty
    }

    //isfull method will go here

    //size method will go here
}
