public class Main {
    public static int binarySearch(int arr[], int right, int left, int target){
        if(left>right){
            return -1;
        }
    int mid = left + (right - left) / 2;

    //Check the middle element to see if it is the target
    if (arr[mid] == target){
        return mid;
    }
    if (target < arr[mid]) {
        return binarySearch(arr, left,mid -1, target);
    }
    else{
        return binarySearch(arr, mid + 1, right, target);
    }
    }
    

}