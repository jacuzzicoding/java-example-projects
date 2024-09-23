//code to declare an array
//example code based an based on the slides, showing Game leaderboard scores
//i will make my own highscore stack class


public class GameEntry {
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

    /* Implementing the HighScoreStack class here to make it a stack */ 
    public class HighScoreStack {
        private GameEntry[] stack;
        private int top;
        private static final int CAPACITY = 10;  // just using 10 for simplicity
    
        public HighScoreStack() {
            stack = new GameEntry [CAPACITY];   // Initializing the stack 
            top = -1;       //we will create an empty stack                                   
        }
    
        public void push(GameEntry entry) {
            if (top == stack.length - 1) { //exception for if the stack is full
                System.out.println(" The stack is full. You cannot add more elements. Use pop() to remove an element.");
                return;
            }
            top++; //increment the top pointer
            stack[top] = entry; // this will add the element to the top of the stack
        }
    
        public GameEntry pop() {
           if (isEmpty()) {   //exception for if the stack is empty
               System.out.println("The stack is empty. There are no elements to pop.");
               return null;  }
            GameEntry entry = stack[top]; //this will remove the top element
            stack[top] = null; //this will remove the element from the stack
            top--; //decrement the top pointer
            return entry; //return the element that was removed
        }
    
        public GameEntry top() {
            // Implement top operation
        }
    
        public int size() {
            // Implement size operation
        }
    
        public boolean isEmpty() {
            // Implement isEmpty operation
        }
    }
}