public class InsertionSort {

    /**
     * Sorts an array of integers using the Insertion Sort algorithm.
     * Insertion sort builds the final sorted array (or list) one item at a time.
     * It is much less efficient on large lists than more advanced algorithms
     * such as quicksort, heapsort, or merge sort. However, it is efficient
     * for small data sets.
     *
     * @param arr The array of integers to be sorted.
     */
    public void sort(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; ++i) {
            int key = arr[i]; // The element to be inserted into the sorted part
            int j = i - 1;

            // Move elements of arr[0..i-1], that are greater than key,
            // to one position ahead of their current position
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }