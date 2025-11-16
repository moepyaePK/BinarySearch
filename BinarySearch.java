/**
 * Implements the Merge Sort algorithm for sorting an array of integers.
 * Merge Sort is a divide-and-conquer algorithm that divides an array into two halves,
 * recursively sorts them, and then merges the two sorted halves.
 * It has a time complexity of O(n log n) in all cases (best, average, worst).
 * It requires O(n) auxiliary space for the merging process.
 */
public class MergeSort {

    /**
     * Sorts an array of integers using the Merge Sort algorithm.
     * This is the public entry point for the sorting process.
     *
     * @param array The array of integers to be sorted.
     * @throws IllegalArgumentException if the input array is null.
     */
    public static void mergeSort(int[] array) {
        if (array == null) {
            throw new IllegalArgumentException("Input array cannot be null.");
        }
        if (array.length < 2) {
            // An array with 0 or 1 element is already sorted.
            return;
        }
        // Create a temporary array for merging. This array is crucial for Merge Sort's
        // O(n) space complexity and efficient merging.
        int[] temp = new int[array.length];
        mergeSort(array, temp, 0, array.length - 1);
    }

    /**
     * Recursive helper method to perform the Merge Sort.
     * Divides the array into two halves, sorts them recursively, and then merges them.
     *
     * @param array The original array to be sorted.
     * @param temp  A temporary array used for merging. It must be at least the same size as 'array'.
     * @param left  The starting index of the sub-array to be sorted.
     * @param right The ending index of the sub-array to be sorted.
     */
    private static void mergeSort(int[] array, int[] temp, int left, int right) {
        if (left < right) {
            // Calculate mid-point to avoid potential integer overflow for very large 'left' and 'right'
            int mid = left + (right - left) / 2;

            // Recursively sort the left half
            mergeSort(array, temp, left, mid);
            // Recursively sort the right half
            mergeSort(array, temp, mid + 1, right);
            // Merge the two sorted halves
            merge(array, temp, left, mid, right);
        }
    }

    /**
     * Merges two sorted sub-arrays into a single sorted sub-array.
     * The two sub-arrays are array[left...mid] and array[mid+1...right].
     *
     * @param array The original array containing the sub-arrays to be merged.
     * @param temp  A temporary array used to hold elements during the merge process.
     *              It must contain the original values of array[left...right] before merging.
     * @param left  The starting index of the first sub-array.
     * @param mid   The ending index of the first sub-array and (mid+1) is the start of the second.
     * @param right The ending index of the second sub-array.
     */
    private static void merge(int[] array, int[] temp, int left, int mid, int right) {
        // Copy the relevant portion of the original array to the temporary array.
        // This ensures that we have the original values of the two sub-arrays
        // available for comparison without being overwritten during the merge.
        System.arraycopy(array, left, temp, left, right - left + 1);

        int i = left;       // Initial index for the first half (in temp array)
        int j = mid + 1;    // Initial index for the second half (in temp array)
        int k = left;       // Initial index for placing merged elements back into the original array

        // Merge the two halves back into the original array by comparing elements from 'temp'
        while (i <= mid && j <= right) {
            if (temp[i] <= temp[j]) {
                array[k] = temp[i];
                i++;
            } else {
                array[k] = temp[j];
                j++;
            }
            k++;
        }

        // Copy any remaining elements of the first half (if the second half was exhausted first)
        while (i <= mid) {
            array[k] = temp[i];
            i++;
            k++;
        }

        // No need to copy remaining elements of the second half, as they are already in their
        // correct sorted positions in `array` if the first half was exhausted first.
        // (This is because `System.arraycopy` initially copied them, and they haven't been touched yet).
        // However, if we strictly follow the pattern of copying remaining elements, it would be:
        // while (j <= right) {
        //     array[k] = temp[j];
        //     j++;
        //     k++;
        // }
        // But the current implementation is also correct because if `i > mid` and `j <= right`,
        // then `temp[j...right]` are already in `array[k...right]` from the initial `System.arraycopy`
        // if `k` has advanced to `j`'s position.
        // A simpler way to think about it is that if the left half is exhausted, the remaining
        // elements in the right half of `temp` are already in their correct sorted order
        // and are effectively already in `array` at the correct positions relative to `k`.
    }

    /**
     * Main method to demonstrate the Merge Sort algorithm.
     * Initializes various arrays, sorts them using mergeSort, and prints the results.
     * Includes tests for null, empty, and single-element arrays.
     *
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        int[] arr1 = {38, 27, 43, 3, 9, 82, 10};
        System.out.println("Original array 1:");
        printArray(arr1);

        try {
            mergeSort(arr1);
            System.out.println("Sorted array 1:");
            printArray(arr1);

            int[] arr2 = {5, 4, 3, 2, 1};
            System.out.println("\nOriginal array 2:");
            printArray(arr2);
            mergeSort(arr2);
            System.out.println("Sorted array 2:");
            printArray(arr2);

            int[] emptyArr = {};
            System.out.println("\nOriginal empty array:");
            printArray(emptyArr);
            mergeSort(emptyArr);
            System.out.println("Sorted empty array:");
            printArray(emptyArr);

            int[] singleElementArr = {5};
            System.out.println("\nOriginal single element array:");
            printArray(singleElementArr);
            mergeSort(singleElementArr);
            System.out.println("Sorted single element array:");
            printArray(singleElementArr);

            int[] nullArr = null;
            System.out.println("\nAttempting to sort a null array...");
            mergeSort(nullArr); // This should throw IllegalArgumentException
        } catch (IllegalArgumentException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    /**
     * Helper method to print the elements of an integer array.
     * Handles null and empty arrays gracefully.
     *
     * @param arr The array to be printed.
     */
    private static void printArray(int[] arr) {
        if (arr == null) {
            System.out.println("null");
            return;
        }
        if (arr.length == 0) {
            System.out.println("[]");
            return;
        }
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }
}
