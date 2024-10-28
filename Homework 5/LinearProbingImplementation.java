public class LinearProbingImplementation {
    private static final int TABLE_SIZE = 1009;  // Prime number slightly larger than 1000
    private WordEntry[] table;
    private int size;
    
    private static class WordEntry {
        String word;
        int count;
        
        WordEntry(String word) {
            this.word = word;
            this.count = 1;
        }
    }
    
    public LinearProbingImplementation() {
        table = new WordEntry[TABLE_SIZE];
        size = 0;
    }
    
    // Hash function using first letter as specified in assignment
    private int hash(String word) {
        if (word == null || word.isEmpty()) return 0;
        // Using first letter and word length to reduce collisions
        return ((word.charAt(0) - 'a') * 31 + word.length()) % TABLE_SIZE;
    }
    
    public void put(String word) {
        if (size >= TABLE_SIZE) {
            throw new IllegalStateException("Hash table is full");
        }
        
        int index = hash(word);
        
        // Linear probing until we find an empty slot or the word
        while (table[index] != null) {
            if (table[index].word.equals(word)) {
                table[index].count++;
                return;
            }
            index = (index + 1) % TABLE_SIZE;
        }
        
        // Found empty slot, insert new entry
        table[index] = new WordEntry(word);
        size++;
    }
    
    public Integer get(String word) {
        int index = hash(word);
        
        // Linear probe until we find the word or an empty slot
        int startIndex = index;
        while (table[index] != null) {
            if (table[index].word.equals(word)) {
                return table[index].count;
            }
            index = (index + 1) % TABLE_SIZE;
            if (index == startIndex) break;  // Wrapped around table
        }
        
        return null;  // Word not found
    }
    
    public int size() {
        return size;
    }
    
    public void processText(String text) {
        String[] words = text.split(" ");
        for (String word : words) {
            put(word);
        }
    }
    
    public void displayCounts() {
        System.out.println("Word Counts (Linear Probing):");
        System.out.println("---------------------------");
        for (WordEntry entry : table) {
            if (entry != null) {
                System.out.printf("%-20s: %d%n", entry.word, entry.count);
            }
        }
    }
    
    public static void main(String[] args) {
        LinearProbingImplementation counter = new LinearProbingImplementation();
        String text = "this is a slightly new test testing this program and once more this is only a test but this is also a longer test to show how linear probing handles more words than the other implementations. test test test haha test";
        counter.processText(text);
        counter.displayCounts();
        
        System.out.println("\nCount for word 'test': " + counter.get("test"));
        System.out.println("Total unique words: " + counter.size());
    }
}