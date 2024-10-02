public class queueArray { //constructor i will use to make the queue
    //need class variables
        //pointers etc
    int[] queue; //this will be my array to store the elements
    int front; //this will be a pointer to the first element
    int rear; //this will point to the tail element
    int size; //this will track how many elements we have
    int capacity; //this will store the maximum size of the array
    //structure  x

    public void push(E element) { //need to update this to be enqueue
        list.addFirst(element); // Add the element to the front of the list (top of the stack)
    }

    //dequeue method will go here
    
    public E top() {
        if (isEmpty()) {
            throw new EmptyStackException(); // Throw an exception if the stack is empty
        }
        return list.getFirst(); // Return the first element of the list (top of the stack)
    }

    public boolean isEmpty() { //this will check if the queue is empty
        return top == -1; //return true if the stack is empty
    }
    //isfull
}
