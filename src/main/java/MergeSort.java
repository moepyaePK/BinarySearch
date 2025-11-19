import java.util.Arrays;

/**
 * Implements the Merge Sort algorithm for sorting an array of integers.
 * <p>
 * Merge Sort is a divide-and-conquer algorithm. It works by recursively
 * dividing the input array into two halves, sorting each half, and then
 * merging the two sorted halves to produce the final sorted array.
 * </p>
 * <p>
 * <b>Time Complexity:</b> O(n log n) in all cases (worst, average, and best),
 * where n is the number of elements in the array. The division of the array
 * takes O(log n) steps, and the merging process at each step takes O(n) time.
 * </p>
 * <p>
 * <b>Space Complexity:</b> O(n), as it requires additional memory proportional
 * to the size of the input array to store the temporary subarrays during the
 * merge step.
 * </p>
 */
public class MergeSort {

    /**
     * The main method to demonstrate the Merge Sort algorithm.
     * It creates an unsorted array, sorts it using the merge sort,
     * and prints the array before and after sorting.
     *
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        int[] data = {12, 11, 13, 5, 6, 7, 2, 19, 4};

        System.out.println("Unsorted array:");
        System.out.println(Arrays.toString(data));

        // Call the sort method
        MergeSort.sort(data);

        System.out.println("\nSorted array:");
        System.out.println(Arrays.toString(data));

        // Test with an empty array
        int[] emptyArray = {};
        System.out.println("\nTesting with an empty array:");
        System.out.println("Before: " + Arrays.toString(emptyArray));
        MergeSort.sort(emptyArray);
        System.out.println("After: " + Arrays.toString(emptyArray));

        // Test with a single-element array
        int[] singleElementArray = {42};
        System.out.println("\nTesting with a single-element array:");
        System.out.println("Before: " + Arrays.toString(singleElementArray));
        MergeSort.sort(singleElementArray);
        System.out.println("After: " + Arrays.toString(singleElementArray));
    }

    /**
     * Sorts an array of integers in ascending order using the Merge Sort algorithm.
     * This is the public entry point for the sorting process.
     * The sort is performed in-place.
     *
     * @param arr The array of integers to be sorted. If the array is null or has
     *            fewer than two elements, the method returns without any action.
     */
    public static void sort(int[] arr) {
        // A null array or an array with 0 or 1 elements is already sorted.
        if (arr == null || arr.length < 2) {
            return;
        }
        mergeSort(arr, 0, arr.length - 1);
    }

    /**
     * The recursive core of the Merge Sort algorithm. It divides the array
     * into two halves, recursively sorts them, and then merges them.
     *
     * @param arr   The array containing the subarray to be sorted.
     * @param left  The starting index of the subarray (inclusive).
     * @param right The ending index of the subarray (inclusive).
     */
    private static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            // Find the middle point to divide the array into two halves
            int mid = left + (right - left) / 2;

            // Recursively sort the first and second halves
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);

            // Merge the sorted halves
            merge(arr, left, mid, right);
        }
    }

    /**
     * Merges two sorted subarrays into a single sorted subarray.
     * The first subarray is arr[left..mid].
     * The second subarray is arr[mid+1..right].
     *
     * @param arr   The main array that contains the subarrays to be merged.
     * @param left  The starting index of the first subarray.
     * @param mid   The ending index of the first subarray.
     * @param right The ending index of the second subarray.
     */
    private static void merge(int[] arr, int left, int mid, int right) {
        // Calculate the sizes of the two temporary subarrays
        int n1 = mid - left + 1;
        int n2 = right - mid;

        // Create temporary arrays to hold the data of the two halves
        int[] leftArray = new int[n1];
        int[] rightArray = new int[n2];

        // Copy data from the main array to the temporary arrays
        System.arraycopy(arr, left, leftArray, 0, n1);
        System.arraycopy(arr, mid + 1, rightArray, 0, n2);

        // --- Merge the temporary arrays back into the main array arr[left..right] ---

        // Initial indices for the first, second, and merged subarrays
        int i = 0; // Index for leftArray
        int j = 0; // Index for rightArray
        int k = left; // Index for the merged subarray in arr

        // Compare elements from leftArray and rightArray and place the smaller one
        // into the correct position in the main array
        while (i < n1 && j < n2) {
            if (leftArray[i] <= rightArray[j]) {
                arr[k] = leftArray[i];
                i++;
            } else {
                arr[k] = rightArray[j];
                j++;
            }
            k++;
        }

        // --- Copy any remaining elements ---

        // If there are remaining elements in leftArray, copy them
        while (i < n1) {
            arr[k] = leftArray[i];
            i++;
            k++;
        }

        // If there are remaining elements in rightArray, copy them
        while (j < n2) {
            arr[k] = rightArray[j];
            j++;
            k++;
        }
    }
}