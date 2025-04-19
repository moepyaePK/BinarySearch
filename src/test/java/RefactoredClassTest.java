import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;

class BinarySearchTest {

    @Test
    void testBubbleSort() {
        int[] arr = {5, 1, 4, 2, 8};
        int[] expected = {1, 2, 4, 5, 8};
        BinarySearch.bubbleSort(arr);
        assertArrayEquals(expected, arr);
    }

    @Test
    void testBubbleSortEmptyArray() {
        int[] arr = {};
        int[] expected = {};
        BinarySearch.bubbleSort(arr);
        assertArrayEquals(expected, arr);
    }

    @Test
    void testBubbleSortAlreadySorted() {
        int[] arr = {1, 2, 3, 4, 5};
        int[] expected = {1, 2, 3, 4, 5};
        BinarySearch.bubbleSort(arr);
        assertArrayEquals(expected, arr);
    }


    @Test
    void testBinarySearchExistingElement() {
        int[] arr = {2, 5, 10, 11, 12, 22, 25, 34, 64, 90};
        int target = 25;
        int expectedIndex = 6;
        int actualIndex = BinarySearch.binarySearch(arr, target);
        assertEquals(expectedIndex, actualIndex);
    }

    @Test
    void testBinarySearchNonExistingElement() {
        int[] arr = {2, 5, 10, 12, 22, 25, 34, 64, 90};
        int target = 15; 
        int expectedIndex = -1;
        int actualIndex = BinarySearch.binarySearch(arr, target);
        assertEquals(expectedIndex, actualIndex);
    }

    @Test
    void testBinarySearchEmptyArray() {
        int[] arr = {};
        int target = 5;
        int expectedIndex = -1;
        int actualIndex = BinarySearch.binarySearch(arr, target);
        assertEquals(expectedIndex, actualIndex);
    }

    @Test
    void testBinarySearchFirstElement() {
        int[] arr = {2, 5, 10, 12, 22, 25, 34, 64, 90};
        int target = 2;
        int expectedIndex = 0;
        int actualIndex = BinarySearch.binarySearch(arr, target);
        assertEquals(expectedIndex, actualIndex);
    }

    @Test
    void testBinarySearchLastElement() {
        int[] arr = {2, 5, 10, 12, 22, 25, 34, 64, 90};
        int target = 90;
        int expectedIndex = 8;
        int actualIndex = BinarySearch.binarySearch(arr, target);
        assertEquals(expectedIndex, actualIndex);

    }

    @Test
    void testBinarySearchDuplicateElements() {
        int[] arr = {2, 5, 5, 10, 12, 22, 25, 25, 34, 64, 90};
        int target = 5;
        int actualIndex = BinarySearch.binarySearch(arr, target);
        assertTrue(actualIndex == 1 || actualIndex == 2); 
    }


}
