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
        private static final int CAPACITY = 10;  // Or any default size you prefer
    
        public HighScoreStack() {
            // Initialize the stack here
        }
    
        public void push(GameEntry entry) {
            // Implement push operation
        }
    
        public GameEntry pop() {
            // Implement pop operation
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