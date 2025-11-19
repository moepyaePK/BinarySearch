import java.util.Arrays;

/**
 * Implements the Merge Sort algorithm for sorting an array of integers.
 * <p>
 * Merge Sort is a highly efficient, stable, comparison-based, divide-and-conquer
 * sorting algorithm. It works by recursively dividing the unsorted list into n
 * sublists, each containing one element (a list of one element is considered sorted),
 * and then repeatedly merging sublists to produce new sorted sublists until there
 * is only one sublist remaining. This will be the sorted list.
 * <p>
 * Time Complexity: O(n log n) in all cases (worst, average, and best).
 * Space Complexity: O(n) due to the temporary arrays used for merging.
 */
public class MergeSort {

    /**
     * The main public method to sort an array using the Merge Sort algorithm.
     * This method handles initial checks and starts the recursive sorting process.
     * The array is sorted in-place.
     *
     * @param array The integer array to be sorted. If the array is null or has
     *              fewer than two elements, the method returns without any action,
     *              as such arrays are already considered sorted.
     */
    public static void sort(int[] array) {
        // A null array or an array with 0 or 1 elements is already sorted.
        if (array == null || array.length <= 1) {
            return;
        }
        mergeSort(array, 0, array.length - 1);
    }

    /**
     * The recursive core of the Merge Sort algorithm. It divides the array into
     * two halves, sorts them recursively, and then merges them.
     *
     * @param array The array containing the subarray to sort.
     * @param left  The starting index of the subarray (inclusive).
     * @param right The ending index of the subarray (inclusive).
     */
    private static void mergeSort(int[] array, int left, int right) {
        if (left < right) {
            // Find the middle point to avoid overflow for large left and right values.
            int mid = left + (right - left) / 2;

            // Recursively sort the first and second halves.
            mergeSort(array, left, mid);
            mergeSort(array, mid + 1, right);

            // Merge the sorted halves.
            merge(array, left, mid, right);
        }
    }

    /**
     * Merges two sorted subarrays into a single sorted subarray.
     * The first subarray is {@code array[left..mid]}.
     * The second subarray is {@code array[mid+1..right]}.
     *
     * @param array The main array that contains the subarrays to be merged.
     * @param left  The starting index of the first subarray.
     * @param mid   The ending index of the first subarray.
     * @param right The ending index of the second subarray.
     */
    private static void merge(int[] array, int left, int mid, int right) {
        // Calculate the sizes of the two temporary subarrays.
        int n1 = mid - left + 1;
        int n2 = right - mid;

        // Create temporary arrays to hold the data of the two halves.
        int[] leftArray = new int[n1];
        int[] rightArray = new int[n2];

        // Copy data from the main array to the temporary arrays.
        System.arraycopy(array, left, leftArray, 0, n1);
        System.arraycopy(array, mid + 1, rightArray, 0, n2);

        // --- Merge the temporary arrays back into the original array ---

        // Initial indices for the left, right, and merged subarrays.
        int i = 0; // Index for leftArray
        int j = 0; // Index for rightArray
        int k = left; // Index for the merged section of the main array

        // Compare elements from leftArray and rightArray and place the smaller
        // one into the correct position in the main array.
        while (i < n1 && j < n2) {
            if (leftArray[i] <= rightArray[j]) {
                array[k] = leftArray[i];
                i++;
            } else {
                array[k] = rightArray[j];
                j++;
            }
            k++;
        }

        // After the main loop, one of the temporary arrays might still have
        // elements left. Copy these remaining elements.

        // Copy any remaining elements of leftArray.
        while (i < n1) {
            array[k] = leftArray[i];
            i++;
            k++;
        }

        // Copy any remaining elements of rightArray.
        while (j < n2) {
            array[k] = rightArray[j];
            j++;
            k++;
        }
    }

    /**
     * Main method to demonstrate the functionality of the Merge Sort algorithm
     * with various test cases.
     *
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        System.out.println("Merge Sort Demonstration");

        // Example 1: A standard unsorted array
        int[] arr1 = {12, 11, 13, 5, 6, 7};
        System.out.println("Original array: " + Arrays.toString(arr1));
        sort(arr1);
        System.out.println("Sorted array:   " + Arrays.toString(arr1));
        System.out.println();

        // Example 2: An array with duplicate elements
        int[] arr2 = {64, 34, 25, 12, 22, 11, 90, 22};
        System.out.println("Original array with duplicates: " + Arrays.toString(arr2));
        sort(arr2);
        System.out.println("Sorted array:                 " + Arrays.toString(arr2));
        System.out.println();

        // Example 3: An array that is already sorted
        int[] arr3 = {1, 2, 3, 4, 5, 6};
        System.out.println("Already sorted array: " + Arrays.toString(arr3));
        sort(arr3);
        System.out.println("Sorted array:         " + Arrays.toString(arr3));
        System.out.println();

        // Example 4: An array sorted in reverse order
        int[] arr4 = {10, 9, 8, 7, 6, 5};
        System.out.println("Reverse sorted array: " + Arrays.toString(arr4));
        sort(arr4);
        System.out.println("Sorted array:         " + Arrays.toString(arr4));
        System.out.println();

        // Example 5: An array with a single element
        int[] arr5 = {42};
        System.out.println("Single element array: " + Arrays.toString(arr5));
        sort(arr5);
        System.out.println("Sorted array:         " + Arrays.toString(arr5));
        System.out.println();

        // Example 6: An empty array
        int[] arr6 = {};
        System.out.println("Empty array: " + Arrays.toString(arr6));
        sort(arr6);
        System.out.println("Sorted array: " + Arrays.toString(arr6));
        System.out.println();

        // Example 7: A null array (should be handled gracefully)
        int[] arr7 = null;
        System.out.println("Null array: " + Arrays.toString(arr7));
        sort(arr7);
        System.out.println("Sorted array: " + Arrays.toString(arr7));
        System.out.println();
    }
}