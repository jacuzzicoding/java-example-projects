import java.util.EmptyStackException;

//code to declare an array
//example code based an based on the slides, showing Game leaderboard scores
//i will make my own highscore stack class

/*here will be the main entry point  */
public class Main {
    public static void main(String[] args) {
        // Create a HighScoreStack instance
        HighScoreStack highScores = new HighScoreStack();

        try {
            System.out.println("Testing push and top:");
            /* Add some GameEntry objects to the stack */
            highScores.push(new GameEntry("Alice", 100));
            highScores.push(new GameEntry("Bob", 150));
            highScores.push(new GameEntry("Charlie", 120));

            System.out.println("Top entry: " + highScores.top());     // Display the top element

            System.out.println("\nTesting pop:");
            System.out.println("Popped entry: " + highScores.pop());   // Pop an element from the stack

            System.out.println("\nTesting size:");
            System.out.println("Current stack size: " + highScores.size());    // Display the size of the stack

            System.out.println("\nTesting push after pop:");
            highScores.push(new GameEntry("David", 200)); // Push another element to the stack for testing

            System.out.println("New top entry: " + highScores.top());     // Display the new top element

            System.out.println("Updated stack size: " + highScores.size());    // Display the size of the stack

            System.out.println("\nTesting isEmpty:");
            System.out.println("Is stack empty? " + highScores.isEmpty());  // Check if the stack is empty

            System.out.println("\nTesting push to full stack:");
            // Fill the stack
            for (int i = 0; i < 7; i++) {
                highScores.push(new GameEntry("Player" + i, i * 10));
            }
            // This should cause a StackOverflowError
            highScores.push(new GameEntry("OverflowPlayer", 1000));

        } catch (StackOverflowError e) {
            System.out.println("StackOverflowError caught as expected: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }

        System.out.println("\nTesting pop from empty stack:");
        HighScoreStack emptyStack = new HighScoreStack();
        try {
            emptyStack.pop();
        } catch (EmptyStackException e) {
            System.out.println("EmptyStackException caught as expected.");
        }
    }
}

class GameEntry {
    private String name;            //name of the person earning the score   
    private int score;              //score value
    
    /* constructs a game entry with given parameters */
    public GameEntry(String n, int s) {
        name = n;
        score = s;
    }
    
    /* returns the name field */
    public String getName() { return name; }
    
    /* returns the score field */
    public int getScore() { return score; }
    
    /* returns a string representation of the entry */
    public String toString() {
        return "(" + name + ", " + score + ")";
    }
}

/* Implementing the HighScoreStack class here to make it a stack */ 
class HighScoreStack {
    private GameEntry[] stack;
    private int top;
    private static final int CAPACITY = 10;  // just using 10 for simplicity

    public HighScoreStack() {
        stack = new GameEntry[CAPACITY];   // Initializing the stack 
        top = -1;       //we will create an empty stack                                   
    }

    public void push(GameEntry entry) throws StackOverflowError {
        if (top == stack.length - 1) { //exception for if the stack is full
            throw new StackOverflowError("The stack is full. You cannot add more elements.");
        }
        top++; //increment the top pointer
        stack[top] = entry; // this will add the element to the top of the stack
    }

    public GameEntry pop() throws EmptyStackException {
        if (isEmpty()) {   //exception for if the stack is empty
            throw new EmptyStackException();
        }
        GameEntry entry = stack[top]; //this will remove the top element
        stack[top] = null; //this will remove the element from the stack
        top--; //decrement the top pointer
        return entry; //return the element that was removed
    }

    public GameEntry top() throws EmptyStackException { //this will return but not remove the top element
        if (isEmpty()) { //exception for if the stack is empty
            throw new EmptyStackException();
        }
        return stack[top]; //return the top element
    }

    public int size() { //this will return the size of the stack
        return top + 1;
    }

    public boolean isEmpty() { //this will check if the stack is empty
        return top == -1; //return true if the stack is empty
    }
}