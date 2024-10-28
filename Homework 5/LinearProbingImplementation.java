public class LinearProbingImplementation {
    // size of hash table, using prime number slightly over 1000 as required in assignment
    private static final int TABLE_SIZE = 1009;
    // array to store the word entries, private so it can only be modified by this class
    private WordEntry[] table;
    // keeps track of number of unique words
    private int size;
    
    // private inner class to store word-count pairs
    private static class WordEntry {
        String word;
        int count;
        
        // constructor initializes a new word with count of 1
        WordEntry(String word) {
            this.word = word;
            this.count = 1;
        }
    }
    
    // constructor to initialize the hash table
    public LinearProbingImplementation() {
        table = new WordEntry[TABLE_SIZE];
        size = 0;
    }
    
    // hash function using first letter and length to reduce collisions
    private int hash(String word) {
        // handle edge cases of null or empty strings
        if (word == null || word.isEmpty()) return 0;
        // using first letter and word length with multiplication to better distribute values
        return ((word.charAt(0) - 'a') * 31 + word.length()) % TABLE_SIZE;
    }
    
    // adds a word to the hash table or increments its count if already present
    public void put(String word) {
        // check if table is full before adding
        if (size >= TABLE_SIZE) {
            throw new IllegalStateException("Hash table is full");
        }
        
        // get initial index for this word
        int index = hash(word);
        
        // linear probing: keep checking next slot until we find an empty spot or the word
        while (table[index] != null) {
            // if word found, increment count and return
            if (table[index].word.equals(word)) {
                table[index].count++;
                return;
            }
            // move to next slot (wrapping around to start if needed)
            index = (index + 1) % TABLE_SIZE;
        }
        
        // found empty slot, insert new entry
        table[index] = new WordEntry(word);
        size++; // increment total unique words counter
    }
    
    // returns the count of a given word, or null if word doesn't exist
    public Integer get(String word) {
        // get initial index for this word
        int index = hash(word);
        
        // save starting point to detect if we've checked entire table
        int startIndex = index;
        
        // keep checking slots until we find the word or an empty slot
        while (table[index] != null) {
            // if word found, return its count
            if (table[index].word.equals(word)) {
                return table[index].count;
            }
            // move to next slot
            index = (index + 1) % TABLE_SIZE;
            // break if we've wrapped around to where we started
            if (index == startIndex) break;
        }
        
        // word not found in table
        return null;
    }
    
    // returns the number of unique words in the hash table
    public int size() {
        return size;
    }
    
    // helper method to process entire text at once instead of word by word
    public void processText(String text) {
        // split the text into words using space as delimiter as specified in assignment
        String[] words = text.split(" ");
        // process each word using our put method
        for (String word : words) {
            put(word);
        }
    }
    
    // helper method to display the counts of all words
    public void displayCounts() {
        System.out.println("Word Counts (Linear Probing):");
        System.out.println("---------------------------");
        // iterate through the entire table
        for (WordEntry entry : table) {
            // only display non-null entries (words that were added)
            if (entry != null) {
                // formatting output to align counts
                System.out.printf("%-20s: %d%n", entry.word, entry.count);
            }
        }
    }
    
    // main method to test the implementation
    public static void main(String[] args) {
        // create new instance of our hash table
        LinearProbingImplementation counter = new LinearProbingImplementation();
        // test string with multiple repeated words to demonstrate counting
        String text = "this is a slightly new test testing this program and once more this is only a test but this is also a longer test to show how linear probing handles more words than the other implementations. test test test haha test";
        // process the test text
        counter.processText(text);
        // display all word counts
        counter.displayCounts();
        
        // demonstrate individual word lookup
        System.out.println("\nCount for word 'test': " + counter.get("test"));
        System.out.println("Total unique words: " + counter.size());
    }
}