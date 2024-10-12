import java.util.Arrays;

public class MergeSort {

    // Function to merge two subarrays: left and right
    public static void merge(int[] arr, int[] left, int[] right) {
        int i = 0, j = 0, k = 0;
        
        // Merging the left and right subarrays into the main array
        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                arr[k++] = left[i++];
            } else {
                arr[k++] = right[j++];
            }
        }

        // Copy remaining elements of left subarray (if any)
        while (i < left.length) {
            arr[k++] = left[i++];
        }

        // Copy remaining elements of right subarray (if any)
        while (j < right.length) {
            arr[k++] = right[j++];
        }
    }

    // Merge sort function
    public static void mergeSort(int[] arr) {
        // Base case: If the array has 1 or 0 elements, it is already sorted
        if (arr.length < 2) {
            return;
        }

        // Find the middle index to divide the array into two halves
        int mid = arr.length / 2;

        // Create left and right subarrays
        int[] left = Arrays.copyOfRange(arr, 0, mid);
        int[] right = Arrays.copyOfRange(arr, mid, arr.length);

        // Recursively sort both halves
        mergeSort(left);
        mergeSort(right);

        // Merge the sorted halves
        merge(arr, left, right);
    }

    // Main function to test the merge sort
    public static void main(String[] args) {
        int[] arr = { 38, 27, 43, 3, 9, 82, 10 };

        System.out.println("Original Array: " + Arrays.toString(arr));

        // Call mergeSort to sort the array
        mergeSort(arr);

        System.out.println("Sorted Array: " + Arrays.toString(arr));
    }
}
