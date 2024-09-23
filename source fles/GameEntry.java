//code to declare an array
//example code based an based on the slides, showing Game leaderboard scores
//i will make my own highscore stack class


public class GameEntry {
    private String name;            //name of the person earning the score   
    private int score;              //score value
    /* contructs a game entry with given parameters */
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

    /* Implementing the HighScoreStack class here */ 
public class HighScoreStack {
        private GameEntry[] stack;
        private int top;
        private static final int CAPACITY = 10;  // Or any default size you prefer
    
        public HighScoreStack() {
            stack = new GameEntry[CAPACITY];
            top = -1;  // Stack is initially empty
        }
    
        // Implement stack operations here
    }

}
