import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;

public class BinarySearchTest {

    @Test
    void testBinarySearch_emptyArray() {
        int[] arr = {};
        int target = 5;
        assertEquals(-1, BinarySearch.binarySearch(arr, target));
    }

    @Test
    void testBinarySearch_singleElementArray_found() {
        int[] arr = {5};
        int target = 5;
        assertEquals(0, BinarySearch.binarySearch(arr, target));
    }

    @Test
    void testBinarySearch_singleElementArray_notFound() {
        int[] arr = {5};
        int target = 10;
        assertEquals(-1, BinarySearch.binarySearch(arr, target));
    }

    @Test
    void testBinarySearch_multipleElements_found() {
        int[] arr = {2, 5, 8, 12, 16, 23, 38, 56, 72, 91};
        int target = 23;
        BinarySearch.quickSort(arr, 0, arr.length - 1);
        assertEquals(5, BinarySearch.binarySearch(arr, target));
    }

    @Test
    void testBinarySearch_multipleElements_notFound() {
        int[] arr = {2, 5, 8, 12, 16, 23, 38, 56, 72, 91};
        int target = 25;
        BinarySearch.quickSort(arr, 0, arr.length - 1);
        assertEquals(-1, BinarySearch.binarySearch(arr, target));
    }

    @Test
    void testBinarySearch_duplicateElements_found() {
        int[] arr = {2, 5, 8, 8, 12, 16, 23, 38, 56, 72, 91};
        int target = 8;
        BinarySearch.quickSort(arr, 0, arr.length - 1);
        int result = BinarySearch.binarySearch(arr, target);
        assertTrue(result == 2 || result == 3); 
    }


    @Test
    void testBinarySearch_firstElement() {
        int[] arr = {2, 5, 8, 12, 16, 23, 38, 56, 72, 91};
        int target = 2;
        BinarySearch.quickSort(arr, 0, arr.length - 1);
        assertEquals(0, BinarySearch.binarySearch(arr, target));
    }

    @Test
    void testBinarySearch_lastElement() {
        int[] arr = {2, 5, 8, 12, 16, 23, 38, 56, 72, 91};
        int target = 91;
        BinarySearch.quickSort(arr, 0, arr.length - 1);
        assertEquals(9, BinarySearch.binarySearch(arr, target));
    }

    @Test
    void testQuickSort_unsortedArray() {
        int[] arr = {11, 12, 22, 25, 34, 64, 90, 23, 55, 43, 76};
        int[] expected = {11, 12, 22, 23, 25, 34, 43, 55, 64, 76, 90};
        BinarySearch.quickSort(arr, 0, arr.length - 1);
        assertArrayEquals(expected, arr);
    }

    @Test
    void testQuickSort_sortedArray() {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int[] expected = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        BinarySearch.quickSort(arr, 0, arr.length - 1);
        assertArrayEquals(expected, arr);
    }

    @Test
    void testQuickSort_reverseSortedArray() {
        int[] arr = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        int[] expected = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        BinarySearch.quickSort(arr, 0, arr.length - 1);
        assertArrayEquals(expected, arr);
    }


    @Test
    void testQuickSort_emptyArray() {
        int[] arr = {};
        int[] expected = {};
        BinarySearch.quickSort(arr, 0, arr.length - 1); // Expect no exceptions
        assertArrayEquals(expected, arr);

    }

    @Test
    void testQuickSort_singleElementArray() {
        int[] arr = {5};
        int[] expected = {5};
        BinarySearch.quickSort(arr, 0, arr.length - 1);
        assertArrayEquals(expected, arr);
    }

}
