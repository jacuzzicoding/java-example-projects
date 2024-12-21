import java.util.HashMap;
import java.util.Map;

public class Part4_Map {
    public static void main(String[] args) {
        // Create a HashMap instance
        Map<String, Integer> map = new HashMap<>();

        // Test put() method
        System.out.println("Testing put() method:");
        map.put("One", 1); // Add key "One" with value 1
        map.put("Two", 2); // Add key "Two" with value 2
        map.put("Three", 3); // Add key "Three" with value 3
        System.out.println("Map after puts: " + map); // Should print {One=1, Two=2, Three=3} 

        // Test get() method
        System.out.println("\nTesting get() method:");
        System.out.println("Value for key 'Two': " + map.get("Two")); // Should print 2
        System.out.println("Value for non-existent key: " + map.get("Four")); // Should print null because the key doesn't exist

        // Test getOrDefault()
        System.out.println("\nTesting getOrDefault() method:");
        System.out.println("Value for 'Four' with default 0: " + map.getOrDefault("Four", 0)); // Returns 0 instead of null

        // Test containsKey() and containsValue()
        System.out.println("\nTesting containsKey() and containsValue():");
        System.out.println("Contains key 'One'? " + map.containsKey("One")); // Should print true
        System.out.println("Contains value 2? " + map.containsValue(2)); // Should print true

        // Test put() with existing key (replacement)
        System.out.println("\nTesting put() with existing key:");
        Integer oldValue = map.put("One", 100); // Replace value for key "One", oldValue will be 1
        System.out.println("Old value: " + oldValue); // Should print 1
        System.out.println("Map after replacement: " + map); // Should show "One"=100

        // Test putIfAbsent()
        System.out.println("\nTesting putIfAbsent():");
        map.putIfAbsent("One", 1); // Won't change anything as key exists
        map.putIfAbsent("Four", 4); // Will add new entry as key doesn't exist
        System.out.println("Map after putIfAbsent: " + map); // Should show new "Four"=4 entry

        // Test keySet(), values(), and entrySet()
        System.out.println("\nTesting collection views:");
        System.out.println("Keys: " + map.keySet()); // Shows all keys in the map
        System.out.println("Values: " + map.values()); // Shows all values in the map
        System.out.println("Entries: " + map.entrySet()); // Shows all key-value pairs

        // Test remove() methods
        System.out.println("\nTesting remove() methods:");
        map.remove("Two"); // Simple remove by key
        System.out.println("Map after removing 'Two': " + map);
        boolean removed = map.remove("Three", 3); // Conditional remove - only removes if value matches
        System.out.println("Was 'Three' removed? " + removed); // Should print true
        System.out.println("Map after conditional remove: " + map);

        // Test compute methods
        System.out.println("\nTesting compute methods:");
        map.compute("One", (k, v) -> v + 1); // Increment value of "One" by 1
        System.out.println("Map after compute: " + map);

        map.computeIfPresent("Four", (k, v) -> v * 2); // Double the value of "Four" if present
        System.out.println("Map after computeIfPresent: " + map);

        map.computeIfAbsent("Five", k -> 5); // Add "Five"=5 only if key doesn't exist
        System.out.println("Map after computeIfAbsent: " + map);

        // Test clear() and isEmpty()
        System.out.println("\nTesting clear() and isEmpty():");
        map.clear(); // Remove all entries from map
        System.out.println("Is map empty after clear? " + map.isEmpty()); // Should print true
    }
}