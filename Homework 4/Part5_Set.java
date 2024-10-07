import java.util.HashSet;
import java.util.Set;

public class Part5_Set {
    public static void main(String[] args) {
        // Create a HashSet instance
        Set<String> set = new HashSet<>();

        // Test add() method with fruit because i am hungry
        System.out.println("Testing add() method:");
        set.add("Apple"); // Add first element
        set.add("Banana"); // Add second element
        set.add("Cherry"); // Add third element
        System.out.println("Set after adds: " + set); // Order may vary as HashSet doesn't maintain insertion order

        // Test adding duplicate element
        System.out.println("\nTesting duplicate addition:");
        boolean added = set.add("Apple"); // Try to add "Apple" again
        System.out.println("Was duplicate 'Apple' added? " + added); // Should print false
        System.out.println("Set after attempting to add duplicate: " + set); // Should be unchanged

        // Test contains() method
        System.out.println("\nTesting contains() method:");
        System.out.println("Contains 'Apple'? " + set.contains("Apple")); // Should print true
        System.out.println("Contains 'Orange'? " + set.contains("Orange")); // Should print false

        // Test size() method
        System.out.println("\nTesting size() method:");
        System.out.println("Set size: " + set.size()); // Should print 3

        // Test remove() method
        System.out.println("\nTesting remove() method:");
        boolean removed = set.remove("Banana"); // Remove "Banana" from set
        System.out.println("Was 'Banana' removed? " + removed); // Should print true
        System.out.println("Set after removal: " + set); // Should show set without "Banana"

        // Test iteration
        System.out.println("\nTesting iteration:");
        System.out.print("Iterating through set: ");
        for (String element : set) { // Using enhanced for loop to iterate
            System.out.print(element + " "); // Print each element
        }
        System.out.println();

        // Test addAll() for union
        Set<String> otherSet = new HashSet<>(); // Create another set for testing set operations
        otherSet.add("Cherry"); // Add some elements, including one that's already in our first set
        otherSet.add("Date"); // Add unique element
        otherSet.add("Elderberry"); // Add another unique element
        System.out.println("\nTesting addAll() (union):");
        set.addAll(otherSet); // Combine both sets
        System.out.println("Set after union: " + set); // Should show all unique elements from both sets

        // Test retainAll() for intersection
        Set<String> intersectSet = new HashSet<>();
        intersectSet.add("Cherry"); // Add element that exists in main set
        intersectSet.add("Date"); // Add element that exists in main set
        intersectSet.add("Fig"); // Add element that doesn't exist in main set
        System.out.println("\nTesting retainAll() (intersection):");
        set.retainAll(intersectSet); // Keep only elements that exist in both sets
        System.out.println("Set after intersection: " + set); // Should only show common elements

        // Test removeAll() for difference
        Set<String> removeSet = new HashSet<>();
        removeSet.add("Cherry"); // Add element to remove
        System.out.println("\nTesting removeAll() (difference):");
        set.removeAll(removeSet); // Remove all elements that exist in removeSet
        System.out.println("Set after difference: " + set); // Should show remaining elements

        // Test clear() and isEmpty()
        System.out.println("\nTesting clear() and isEmpty():");
        set.clear(); // Remove all elements
        System.out.println("Is set empty after clear? " + set.isEmpty()); // Should print true

        // Test null handling
        System.out.println("\nTesting null handling:");
        try {
            set.add(null); // Try to add null value
            System.out.println("Null element added successfully"); // Will print if HashSet accepts null
        } catch (NullPointerException e) {
            System.out.println("Set doesn't accept null elements"); // Will print if HashSet rejects null
        }
    }
}