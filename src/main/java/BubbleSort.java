Okay, this is a great enhancement! Adding Bubble Sort will expand your collection of basic sorting algorithms.

Here's how we'll perform a comprehensive enhancement:

1.  **Create `BubbleSort.java`**: Implement the Bubble Sort algorithm with a `main` method for testing.
2.  **Update `README.md`**: Provide an overview of all algorithms, how to run them, and the repository structure.
3.  **Provide Git Commands**: Instructions on how to add these changes to your repository.

---

### Step 1: Create `BubbleSort.java`

Create a new file named `BubbleSort.java` in your repository's root directory (or an appropriate `src` folder if you have one).

```java
// File: BubbleSort.java

import java.util.Arrays;

/**
 * Implements the Bubble Sort algorithm.
 * Bubble Sort is a simple sorting algorithm that repeatedly steps
 * through the list, compares adjacent elements and swaps them if
 * they are in the wrong order. The pass through the list is repeated
 * until no swaps are needed, which indicates that the list is sorted.
 *
 * Time Complexity:
 *   - Best Case: O(n) (when the array is already sorted, with optimization)
 *   - Average Case: O(n^2)
 *   - Worst Case: O(n^2)
 * Space Complexity: O(1)
 */
public class BubbleSort {

    /**
     * Sorts an array of integers using the Bubble Sort algorithm.
     * The algorithm includes an optimization to stop early if no swaps
     * occur in a pass, indicating the array is sorted.
     *
     * @param arr The array of integers to be sorted.
     */
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        // Outer loop for passes
        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false; // Optimization: Flag to check if any swap happened in this pass

            // Inner loop for comparisons and swaps
            // The last 'i' elements are already in place, so we don't need to check them
            for (int j = 0; j < n - 1 - i; j++) {
                // If current element is greater than the next, swap them
                if (arr[j] > arr[j + 1]) {
                    // Swap arr[j] and arr[j+1]
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true; // A swap occurred
                }
            }

            // If no two elements were swapped by inner loop, then break
            // This means the array is already sorted
            if (!swapped) {
                System.out.println("No swaps in pass " + (i + 1) + ". Array is sorted early.");
                break;
            }
            System.out.println("Array after pass " + (i + 1) + ": " + Arrays.toString(arr)); // Optional: to see pass-by-pass
        }
    }

    /**
     * A helper method to print the elements of an array.
     *
     * @param arr The array to print.
     */
    public static void printArray(int[] arr) {
        System.out.println(Arrays.toString(arr));
    }

    /**
     * Main method to test the Bubble Sort algorithm.
     */
    public static void main(String[] args) {
        System.out.println("--- Bubble Sort Demonstration ---");

        // Test Case 1: General unsorted array
        int[] arr1 = {64, 34, 25, 12, 22, 11, 90};
        System.out.println("\nOriginal Array 1: ");
        printArray(arr1);
        bubbleSort(arr1);
        System.out.println("Sorted Array 1: ");
        printArray(arr1); // Expected: [11, 12, 22, 25, 34, 64, 90]

        // Test Case 2: Already sorted array (tests optimization)
        int[] arr2 = {1, 2, 3, 4, 5};
        System.out.println("\nOriginal Array 2 (already sorted): ");
        printArray(arr2);
        bubbleSort(arr2);
        System.out.println("Sorted Array 2: ");
        printArray(arr2); // Expected: [1, 2, 3, 4, 5]

        // Test Case 3: Reverse sorted array (worst case)
        int[] arr3 = {5, 4, 3, 2, 1};
        System.out.println("\nOriginal Array 3 (reverse sorted): ");
        printArray(arr3);
        bubbleSort(arr3);
        System.out.println("Sorted Array 3: ");
        printArray(arr3); // Expected: [1, 2, 3, 4, 5]

        // Test Case 4: Array with duplicate elements
        int[] arr4 = {3, 1, 4, 1, 5, 9, 2, 6};
        System.out.println("\nOriginal Array 4 (with duplicates): ");
        printArray(arr4);
        bubbleSort(arr4);
        System.out.println("Sorted Array 4: ");
        printArray(arr4); // Expected: [1, 1, 2, 3, 4, 5, 6, 9]

        // Test Case 5: Empty array
        int[] arr5 = {};
        System.out.println("\nOriginal Array 5 (empty): ");
        printArray(arr5);
        bubbleSort(arr5);
        System.out.println("Sorted Array 5: ");
        printArray(arr5); // Expected: []

        // Test Case 6: Single element array
        int[] arr6 = {42};
        System.out.println("\nOriginal Array 6 (single element): ");
        printArray(arr6);
        bubbleSort(arr6);
        System.out.println("Sorted Array 6: ");
        printArray(arr6); // Expected: [42]
    }
}
```

---

### Step 2: Update `README.md`

If you don't have a `README.md` yet, create one. If you do, update it to reflect the new algorithm and provide better context.

```markdown
# Algorithms Repository

This repository serves as a collection of fundamental algorithms implemented in Java.
It's designed for learning, reference, and demonstrating various approaches to common computational problems.

## Algorithms Included:

### 1. Binary Search (`BinarySearch.java`)
*   **Description**: An efficient algorithm for finding an item from a sorted list of items. It works by repeatedly dividing in half the portion of the list that could contain the item, until you've narrowed down the possible locations to just one.
*   **Time Complexity**: O(log n)
*   **Space Complexity**: O(1) for iterative, O(log n) for recursive (due to call stack).

### 2. Insertion Sort (`InsertionSort.java`)
*   **Description**: A simple sorting algorithm that builds the final sorted array (or list) one item at a time. It iterates through the input elements and removes one element from the input data, finds the location it belongs within the sorted list, and inserts it there.
*   **Time Complexity**:
    *   Best Case: O(n) (when the array is already sorted)
    *   Average Case: O(n^2)
    *   Worst Case: O(n^2)
*   **Space Complexity**: O(1)

### 3. Bubble Sort (`BubbleSort.java`) - *NEW!*
*   **Description**: A simple comparison-based sorting algorithm that repeatedly steps through the list, compares adjacent elements and swaps them if they are in the wrong order. The pass through the list is repeated until no swaps are needed, which indicates that the list is sorted. Includes an optimization to stop early if no swaps occur in a pass.
*   **Time Complexity**:
    *   Best Case: O(n) (when the array is already sorted, with optimization)
    *   Average Case: O(n^2)
    *   Worst Case: O(n^2)
*   **Space Complexity**: O(1)

## Repository Structure:

```
.
├── BinarySearch.java
├── InsertionSort.java
├── BubbleSort.java
└── README.md
```

## How to Compile and Run:

To compile and run any of the algorithms, navigate to the root of this repository in your terminal and use the Java Development Kit (JDK):

1.  **Compile**:
    ```bash
    javac <AlgorithmName>.java
    ```
    (e.g., `javac BubbleSort.java`)

2.  **Run**:
    ```bash
    java <AlgorithmName>
    ```
    (e.g., `java BubbleSort`)

Each Java file contains a `main` method with test cases to demonstrate its functionality.

## Future Enhancements:

*   Add more sorting algorithms (e.g., Merge Sort, Quick Sort, Selection Sort, Heap Sort).
*   Add more searching algorithms (e.g., Linear Search).
*   Implement data structures (e.g., LinkedList, Stack, Queue).
*   Add unit tests using a framework like JUnit.
*   Refactor common utility methods (like `printArray`) into a separate `Utils.java` file.

## Contributing:

Feel free to fork this repository, add new algorithms, improve existing ones, or fix bugs. Pull requests are welcome!
```

---

### Step 3: Provide Git Commands

Follow these steps in your terminal to add the new file and update the `README.md` to your Git repository:

1.  **Navigate to your repository:**
    ```bash
    cd /path/to/your/repository
    ```

2.  **Check the status (optional, but good practice):**
    ```bash
    git status
    ```
    You should see `BubbleSort.java` and `README.md` listed as untracked or modified.

3.  **Add the new file and the updated README to the staging area:**
    ```bash
    git add BubbleSort.java README.md
    ```
    (If you have other changes you want to commit, add them too, or use `git add .` to add all changes in the current directory and subdirectories.)

4.  **Commit your changes:**
    ```bash
    git commit -m "feat: Add Bubble Sort algorithm and update README.md"
    ```
    (Using `feat:` in the commit message is a common convention for new features.)

5.  **Push your changes to the remote repository (e.g., GitHub, GitLab):**
    ```bash
    git push origin main
    ```
    (Replace `main` with `master` if that's the name of your primary branch.)

---

You have now comprehensively enhanced your project by adding a new algorithm with proper documentation and clear instructions!