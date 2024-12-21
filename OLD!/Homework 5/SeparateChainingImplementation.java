import java.util.LinkedList;

// Helper class to store word and its count together
class WordEntry {
    String word;
    int count;
    
    // constructor initializes a new word with count of 1
    public WordEntry(String word) {
        this.word = word;
        this.count = 1;
    }
}

public class SeparateChainingImplementation {
    // array of linked lists to store the word entries, private so it can only be modified by this class
    private LinkedList<WordEntry>[] table;
    // keeps track of total number of unique words
    private int size;
    // initial size of hash table, one slot for each letter of the alphabet
    private static final int INITIAL_CAPACITY = 26;
    
    // constructor to initialize the hash table
    @SuppressWarnings("unchecked")
    public SeparateChainingImplementation() {
        // create array of LinkedLists
        table = new LinkedList[INITIAL_CAPACITY];
        // Initialize all buckets with empty linked lists
        for (int i = 0; i < INITIAL_CAPACITY; i++) {
            table[i] = new LinkedList<>();
        }
        size = 0;
    }
    
    // hash function that uses first letter of word as specified in assignment
    private int hash(String word) {
        // handle edge cases of null or empty strings
        if (word == null || word.isEmpty()) return 0;
        // Convert first letter to 0-25 range using ASCII math
        return (word.charAt(0) - 'a') % INITIAL_CAPACITY;
    }
    
    // adds a word to the hash table or increments its count if already present
    public void put(String word) {
        // get the index where this word should be stored
        int index = hash(word);
        
        // check if word already exists in the linked list at this index
        for (WordEntry entry : table[index]) {
            if (entry.word.equals(word)) {
                // word found, increment its count
                entry.count++;
                return;
            }
        }
        
        // word not found in the list, add new entry
        table[index].add(new WordEntry(word));
        size++; // increment total unique words counter
    }
    
    // returns the count of a given word, or null if word doesn't exist
    public Integer get(String word) {
        // get the index where this word should be stored
        int index = hash(word);
        
        // search the linked list at this index for the word
        for (WordEntry entry : table[index]) {
            if (entry.word.equals(word)) {
                return entry.count;
            }
        }
        
        // word not found in the table
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
        System.out.println("Word Counts (Separate Chaining):");
        System.out.println("------------------------------");
        // iterate through each bucket in the hash table
        for (LinkedList<WordEntry> bucket : table) {
            // iterate through each entry in the current bucket
            for (WordEntry entry : bucket) {
                // formatting output to align counts
                System.out.printf("%-20s: %d%n", entry.word, entry.count);
            }
        }
    }
    
    // main method to test the implementation
    public static void main(String[] args) {
        // create new instance of our hash table
        SeparateChainingImplementation counter = new SeparateChainingImplementation();
        // test string with multiple repeated words to demonstrate counting
        String text = "this is a test this is only a test but this is also a longer test to show how the separate chaining handles more words but still no punctuation only words and more words and tests with words and such";
        // process the test text
        counter.processText(text);
        // display all word counts
        counter.displayCounts();
        
        // demonstrate individual word lookup
        System.out.println("\nCount for word 'test': " + counter.get("test"));
        System.out.println("Total unique words: " + counter.size());
    }
}