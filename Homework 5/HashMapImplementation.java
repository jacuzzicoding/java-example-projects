import java.util.HashMap;
import java.util.Map;

public class HashMapImplementation {
    // creating a hashmap object to store the word count, private so it can only be modified by this class
    private HashMap<String, Integer> wordCount;
    
    // here is the constructor
    public HashMapImplementation() {
        wordCount = new HashMap<>();
    }

    // main method
    public static void main(String[] args) {
        HashMapImplementation counter = new HashMapImplementation();
        // Example usage with a longer test case
        String text = "this is a test this is only a test but this is also a longer test to show how the hashmap handles more words";
        counter.processText(text);
        counter.displayCounts();
        
        // demonstrating individual word lookup
        System.out.println("\nCount for word 'test': " + counter.get("test"));
        System.out.println("Total unique words: " + counter.size());
    }

    // Required methods from the assignment
    public void put(String word) {
        // this will put the word in the hashmap, if it is already there, increment the count by 1
        // using getOrDefault to handle the case when the word is not in the map yet
        wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
    }

    public Integer get(String word) {
        // returns the count of the word, or null if word doesn't exist
        return wordCount.get(word);
    }

    public int size() {
        // returns the number of unique words
        return wordCount.size();
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
        // using Map.Entry to iterate over both keys and values efficiently
        System.out.println("Word Counts:");
        System.out.println("------------");
        for (Map.Entry<String, Integer> entry : wordCount.entrySet()) {
            // formatting output to align counts
            System.out.printf("%-20s: %d%n", entry.getKey(), entry.getValue());
        }
    }
    
    // helper method to check if hashmap is empty
    public boolean isEmpty() {
        // returns true if no words have been added yet
        return wordCount.isEmpty();
    }
    
    // helper method to clear all counts
    public void clear() {
        // removes all entries from the hashmap
        wordCount.clear();
    }
    
    // helper method to check if a word exists in our counts
    public boolean containsWord(String word) {
        // returns true if the word has been counted at least once
        return wordCount.containsKey(word);
    }
}