import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

public class BinarySearchTest {

    @Test
    void testBinarySearch_emptyArray() {
        int[] arr = {};
        int target = 5;
        int expected = -1;
        int actual = BinarySearch.binarySearch(arr, target);
        assertEquals(expected, actual);
    }

    @Test
    void testBinarySearch_targetFound() {
        int[] arr = {1, 5, 10, 25, 50};
        int target = 25;
        BinarySearch.bubbleSort(arr);
        int expected = 3;
        int actual = BinarySearch.binarySearch(arr, target);
        assertEquals(expected, actual);
    }

    @Test
    void testBinarySearch_targetNotFound() {
        int[] arr = {1, 5, 10, 25, 50};
        int target = 15;
        BinarySearch.bubbleSort(arr);
        int expected = -1;
        int actual = BinarySearch.binarySearch(arr, target);
        assertEquals(expected, actual);
    }

    @Test
    void testBinarySearch_duplicateElements_targetFound() {
        int[] arr = {1, 5, 5, 10, 25, 25, 50};
        int target = 25;
        BinarySearch.bubbleSort(arr);
        int actual = BinarySearch.binarySearch(arr, target);
        assertTrue(actual == 4 || actual == 5); 
    }

    @Test
    void testBinarySearch_targetAtBeginning() {
        int[] arr = {1, 5, 10, 25, 50};
        int target = 1;
        BinarySearch.bubbleSort(arr);
        int expected = 0;
        int actual = BinarySearch.binarySearch(arr, target);
        assertEquals(expected, actual);
    }

    @Test
    void testBinarySearch_targetAtEnd() {
        int[] arr = {1, 5, 10, 25, 50};
        int target = 50;
        BinarySearch.bubbleSort(arr);
        int expected = 4;
        int actual = BinarySearch.binarySearch(arr, target);
        assertEquals(expected, actual);
    }


    @Test
    void testBubbleSort_alreadySorted() {
        int[] arr = {1, 2, 3, 4, 5};
        int[] expected = Arrays.copyOf(arr, arr.length);
        BinarySearch.bubbleSort(arr);
        assertArrayEquals(expected, arr);
    }

    @Test
    void testBubbleSort_reverseSorted() {
        int[] arr = {5, 4, 3, 2, 1};
        int[] expected = {1, 2, 3, 4, 5};
        BinarySearch.bubbleSort(arr);
        assertArrayEquals(expected, arr);
    }

    @Test
    void testBubbleSort_singleElement() {
        int[] arr = {5};
        int[] expected = {5};
        BinarySearch.bubbleSort(arr);
        assertArrayEquals(expected, arr);
    }

    @Test
    void testBubbleSort_duplicateElements() {
        int[] arr = {5, 2, 5, 1, 2};
        int[] expected = {1, 2, 2, 5, 5};
        BinarySearch.bubbleSort(arr);
        assertArrayEquals(expected, arr);
    }




}
