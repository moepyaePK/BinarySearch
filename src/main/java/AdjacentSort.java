/**
 * Implements the Adjacent Sort algorithm, also known as Bubble Sort.
 *
 * <p>Adjacent Sort is a simple comparison-based sorting algorithm. It repeatedly
 * steps through the list, compares each pair of adjacent items, and swaps them
 * if they are in the wrong order. The pass through the list is repeated until
 * the list is sorted. The algorithm gets its name from the way smaller or
 * larger elements "bubble" to the top of the list.
 *
 * <p>This implementation includes an optimization that stops the algorithm
 * early if a pass completes with no swaps, indicating the array is already sorted.
 *
 * @see <a href="https://en.wikipedia.org/wiki/Bubble_sort">Bubble Sort (Wikipedia)</a>
 */
public class AdjacentSort {

    /**
     * The main method serves as a driver to demonstrate the Adjacent Sort algorithm.
     * It initializes an unsorted array, sorts it using the {@code sort} method,
     * and prints the array before and after sorting.
     *
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        int[] data = {64, 34, 25, 12, 22, 11, 90, 5};

        System.out.println("Unsorted Array:");
        printArray(data);

        // Perform the adjacent sort
        sort(data);

        System.out.println("\nSorted Array (using Adjacent Sort):");
        printArray(data);

        // Demonstrate with an already sorted array
        int[] sortedData = {1, 2, 3, 4, 5, 6};
        System.out.println("\nAlready Sorted Array:");
        printArray(sortedData);
        sort(sortedData);
        System.out.println("\nAfter Sorting:");
        printArray(sortedData);

        // Demonstrate with an empty array
        int[] emptyData = {};
        System.out.println("\nEmpty Array:");
        printArray(emptyData);
        sort(emptyData);
        System.out.println("\nAfter Sorting:");
        printArray(emptyData);
    }

    /**
     * Sorts an array of integers in ascending order using the Adjacent Sort (Bubble Sort) algorithm.
     *
     * <p>The method iterates through the array, comparing and swapping adjacent elements
     * until the entire array is sorted. The process is optimized to terminate early if
     * the array becomes sorted before all passes are complete.
     *
     * <p>This method handles {@code null} or arrays with fewer than two elements gracefully
     * by returning immediately, as no sorting is needed.
     *
     * @param arr The array of integers to be sorted. The array is sorted in-place.
     */
    public static void sort(int[] arr) {
        // If the array is null or has 0 or 1 elements, it's already sorted.
        if (arr == null || arr.length < 2) {
            return;
        }

        int n = arr.length;
        boolean swapped;

        // Outer loop for passes through the array.
        // After each pass, the next largest element is in its correct final position.
        for (int i = 0; i < n - 1; i++) {
            swapped = false;

            // Inner loop for comparing adjacent elements.
            // The range of comparison shrinks with each pass (n - i - 1).
            for (int j = 0; j < n - i - 1; j++) {
                // If the current element is greater than the next one, swap them.
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }

            // OPTIMIZATION: If no swaps occurred in the inner loop, the array is sorted.
            if (!swapped) {
                break;
            }
        }
    }

    /**
     * A utility method to print the elements of an integer array.
     *
     * @param arr The array to be printed. Handles {@code null} arrays by printing "null".
     */
    public static void printArray(int[] arr) {
        if (arr == null) {
            System.out.println("null");
            return;
        }
        System.out.println(java.util.Arrays.toString(arr));
    }
}