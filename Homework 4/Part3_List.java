import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

public class Part3_List {
    public static void main(String[] args) {
        // Create an ArrayList instance
        List<Integer> list = new ArrayList<>();

        // Test add() method
        System.out.println("Testing add() method:");
        list.add(10); //add element 10 to the list
        list.add(20); //add 20, list should now be [10, 20]
        list.add(30); //add 30, list should now be [10, 20, 30]
        System.out.println("List after adds: " + list); //should print [10, 20, 30]

        // Test add() at specific index
        System.out.println("\nTesting add(index, element):");
        list.add(1, 15); //add element 15 at the index 1
        System.out.println("List after adding 15 at index 1: " + list); //[10, 15, 20, 30]

        // Test get() method
        System.out.println("\nTesting get() method:"); 
        System.out.println("Element at index 1: " + list.get(1)); //should print 15 as we just set

        // Test set() method
        System.out.println("\nTesting set() method:");
        list.set(2, 25); // Set index 2 to 25
        System.out.println("List after setting index 2 to 25: " + list); //should print [10, 15, 25, 30]

        // Test remove() methods
        System.out.println("\nTesting remove() methods:");
        list.remove(1); // Remove by index //should remove 15
        System.out.println("List after removing index 1: " + list);
        list.remove(Integer.valueOf(30)); // Remove by value
        System.out.println("List after removing value 30: " + list);

        // Test contains() method
        System.out.println("\nTesting contains() method:");
        System.out.println("Contains 25? " + list.contains(25)); //should print true
        System.out.println("Contains 15? " + list.contains(15)); //should print false, as we just removed it

        // Test indexOf() method
        System.out.println("\nTesting indexOf() method:");
        System.out.println("Index of 25: " + list.indexOf(25)); //should print 2
        System.out.println("Index of 99 (not in list): " + list.indexOf(99));//should print -1 and not null (no exception either)

        // Test iterator
        System.out.println("\nTesting iterator:");
        Iterator<Integer> iterator = list.iterator(); // Create an iterator we will use to iterate through the list
        System.out.print("Iterating through list: ");
        while (iterator.hasNext()) { // While there are more elements in the list
            System.out.print(iterator.next() + " "); // Print the next element
        }
        System.out.println();

        // Test subList
        list.add(35); // Add elemenet 35 to the list
        list.add(40); // Add element 40 to the list
        System.out.println("\nTesting subList:"); // Print the subList from index 1 to 3
        List<Integer> subList = list.subList(1, 3); // Gets a subList from index 1 to 3
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