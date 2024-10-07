import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

public class Part3_List {
    public static void main(String[] args) {
        // Create an ArrayList instance
        List<Integer> list = new ArrayList<>();

        // Test add() method
        System.out.println("Testing add() method:");
        list.add(10);
        list.add(20);
        list.add(30);
        System.out.println("List after adds: " + list);

        // Test add() at specific index
        System.out.println("\nTesting add(index, element):");
        list.add(1, 15);
        System.out.println("List after adding 15 at index 1: " + list);

        // Test get() method
        System.out.println("\nTesting get() method:");
        System.out.println("Element at index 1: " + list.get(1));

        // Test set() method
        System.out.println("\nTesting set() method:");
        list.set(2, 25);
        System.out.println("List after setting index 2 to 25: " + list);

        // Test remove() methods
        System.out.println("\nTesting remove() methods:");
        list.remove(1); // Remove by index
        System.out.println("List after removing index 1: " + list);
        list.remove(Integer.valueOf(30)); // Remove by value
        System.out.println("List after removing value 30: " + list);

        // Test contains() method
        System.out.println("\nTesting contains() method:");
        System.out.println("Contains 25? " + list.contains(25));
        System.out.println("Contains 15? " + list.contains(15));

        // Test indexOf() method
        System.out.println("\nTesting indexOf() method:");
        System.out.println("Index of 25: " + list.indexOf(25));
        System.out.println("Index of 99 (not in list): " + list.indexOf(99));

        // Test iterator
        System.out.println("\nTesting iterator:");
        Iterator<Integer> iterator = list.iterator();
        System.out.print("Iterating through list: ");
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
        System.out.println();

        // Test subList
        list.add(35);
        list.add(40);
        System.out.println("\nTesting subList:");
        List<Integer> subList = list.subList(1, 3);
        System.out.println("SubList from index 1 to 3: " + subList);

        // Test edge cases
        System.out.println("\nTesting edge cases:");
        try {
            list.get(list.size()); // Should throw IndexOutOfBoundsException
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Exception caught when accessing invalid index: " + e);
        }

        // Test clear() and isEmpty()
        System.out.println("\nTesting clear() and isEmpty():");
        list.clear();
        System.out.println("Is list empty after clear? " + list.isEmpty());
    }
}