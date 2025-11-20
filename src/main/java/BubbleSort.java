import java.util.Arrays;

/**
 * Implements the Bubble Sort algorithm for sorting an array of integers.
 * <p>
 * Bubble Sort is a simple comparison-based sorting algorithm. It works by
 * repeatedly stepping through the list, comparing each pair of adjacent items,
 * and swapping them if they are in the wrong order. The pass through the list
is repeated until the list is sorted.
 * <p>
 * This implementation includes an optimization to stop the algorithm early if
 * the array becomes sorted before all passes are complete.
 * <p>
 * This class is a utility class and cannot be instantiated.
 */
public final class BubbleSort {

    /**
     * Private constructor to prevent instantiation of this utility class.
     */
    private BubbleSort() {
        // This class should not be instantiated.
    }

    /**
     * Sorts an array of integers in ascending order using the Bubble Sort algorithm.
     * The sort is performed in-place.
     * <p>
     * Time Complexity:
     * <ul>
     *     <li>Worst Case: O(n^2) - when the array is in reverse order.</li>
     *     <li>Average Case: O(n^2)</li>
     *     <li>Best Case: O(n) - when the array is already sorted (due to optimization).</li>
     * </ul>
     * Space Complexity: O(1) - as it sorts the array in-place.
     *
     * @param arr The array of integers to be sorted. Must not be null.
     * @throws IllegalArgumentException if the input array is null.
     */
    public static void sort(int[] arr) {
        if (arr == null) {
            throw new IllegalArgumentException("Input array cannot be null.");
        }

        int n = arr.length;
        if (n <= 1) {
            return; // An array with 0 or 1 element is already sorted.
        }

        boolean swapped;
        // Outer loop for passes. After each pass, the largest unsorted element is at its correct position.
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            // Inner loop for comparisons and swaps.
            // The range of j decreases with each pass as the largest elements are bubbled to the end.
            for (int j = 0; j < n - i - 1; j++) {
                // Compare adjacent elements
                if (arr[j] > arr[j + 1]) {
                    // Swap arr[j] and arr[j+1]
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }

            // OPTIMIZATION: If no two elements were swapped in the inner loop,
            // the array is already sorted, and we can break early.
            if (!swapped) {
                break;
            }
        }
    }

    /**
     * A main method to demonstrate the functionality of the Bubble Sort algorithm.
     * It creates a sample array, sorts it, and prints the result.
     *
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        // --- Test Case 1: General unsorted array ---
        int[] data = {64, 34, 25, 12, 22, 11, 90};
        System.out.println("Original array: " + Arrays.toString(data));
        sort(data);
        System.out.println("Sorted array:   " + Arrays.toString(data));
        System.out.println("----------------------------------------");

        // --- Test Case 2: Already sorted array (best case) ---
        int[] sortedData = {1, 2, 3, 4, 5, 6, 7};
        System.out.println("Original array (already sorted): " + Arrays.toString(sortedData));
        sort(sortedData);
        System.out.println("Sorted array:                   " + Arrays.toString(sortedData));
        System.out.println("----------------------------------------");

        // --- Test Case 3: Reverse sorted array (worst case) ---
        int[] reverseData = {9, 8, 7, 6, 5, 4, 3};
        System.out.println("Original array (reverse sorted): " + Arrays.toString(reverseData));
        sort(reverseData);
        System.out.println("Sorted array:                    " + Arrays.toString(reverseData));
        System.out.println("----------------------------------------");

        // --- Test Case 4: Array with duplicate elements ---
        int[] duplicatesData = {5, 1, 4, 2, 8, 5, 4};
        System.out.println("Original array (with duplicates): " + Arrays.toString(duplicatesData));
        sort(duplicatesData);
        System.out.println("Sorted array:                     " + Arrays.toString(duplicatesData));
        System.out.println("----------------------------------------");

        // --- Test Case 5: Empty array ---
        int[] emptyData = {};
        System.out.println("Original array (empty): " + Arrays.toString(emptyData));
        sort(emptyData);
        System.out.println("Sorted array:           " + Arrays.toString(emptyData));
        System.out.println("----------------------------------------");

        // --- Test Case 6: Single element array ---
        int[] singleElementData = {42};
        System.out.println("Original array (single element): " + Arrays.toString(singleElementData));
        sort(singleElementData);
        System.out.println("Sorted array:                    " + Arrays.toString(singleElementData));
        System.out.println("----------------------------------------");

        // --- Test Case 7: Null array (error handling) ---
        try {
            System.out.println("Attempting to sort a null array...");
            sort(null);
        } catch (IllegalArgumentException e) {
            System.out.println("Successfully caught expected exception: " + e.getMessage());
        }
    }
}