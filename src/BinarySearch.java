public class BinarySearch {
    // Main binary search function that matches the required signature
    public int binarySearch(int[] arr, int k) {
        // Call the recursive helper function with initial bounds
        return binarySearchHelper(arr, 0, arr.length - 1, k);
    }
    
    // Recursive helper function
    private int binarySearchHelper(int[] arr, int left, int right, int target) {
        // Base case: if bounds cross, element not found
        if (left > right) {
            return -1;
        }
        
        // Calculate middle index
        int mid = left + (right - left) / 2;
        
        // If element found at mid, return its index
        if (arr[mid] == target) {
            return mid;
        }
        
        // If target is less than middle element, search left half
        if (target < arr[mid]) {
            return binarySearchHelper(arr, left, mid - 1, target);
        }
        
        // If target is greater than middle element, search right half
        return binarySearchHelper(arr, mid + 1, right, target);
    }
    
    // Main method for testing
    public static void main(String[] args) {
        BinarySearch bs = new BinarySearch();
        
        // Test case from assignment
        int[] arr = {12, 45, 67, 89};
        
        // Test cases
        System.out.println("Searching for 67: " + bs.binarySearch(arr, 67));  // Should print 2
        System.out.println("Searching for 31: " + bs.binarySearch(arr, 31));  // Should print -1
    }
}