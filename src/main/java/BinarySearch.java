public class BubbleSort {

    public static void bubbleSort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }

        int n = arr.length;
        boolean swapped;
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr1 = {64, 34, 25, 12, 22, 11, 90};
        System.out.print("Original array: ");
        printArray(arr1);
        bubbleSort(arr1);
        System.out.print("Sorted array: ");
        printArray(arr1);

        int[] arr2 = {1, 2, 3, 4, 5}; // Already sorted
        System.out.print("Original array (already sorted): ");
        printArray(arr2);
        bubbleSort(arr2);
        System.out.print("Sorted array (already sorted): ");
        printArray(arr2);

        int[] arr3 = {5}; // Single element
        System.out.print("Original array (single element): ");
        printArray(arr3);
        bubbleSort(arr3);
        System.out.print("Sorted array (single element): ");
        printArray(arr3);

        int[] arr4 = {}; // Empty array
        System.out.print("Original array (empty): ");
        printArray(arr4);
        bubbleSort(arr4);
        System.out.print("Sorted array (empty): ");
        printArray(arr4);
    }

    private static void printArray(int[] arr) {
        if (arr == null) {
            System.out.println("null");
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