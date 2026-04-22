import java.util.Arrays;

public class ArrayReverser {
    
    public static <V> void reverseRange(V[] arr, int from, int to) {
        if (arr == null || from < 0 || to >= arr.length || from > to) {
            throw new IllegalArgumentException("Invalid input parameters");
        }
        
        while (from < to) {
            // Swap elements at from and to indices
            V temp = arr[from];
            arr[from] = arr[to]; 
            arr[to] = temp;
            
            from++;
            to--;
        }
    }
    
    // Example usage:
    public static void main(String[] args) {
        Integer[] numbers = {1, 2, 3, 4, 5, 6, 7, 8};
        System.out.println("Before: " + Arrays.toString(numbers));
        
        reverseRange(numbers, 2, 5);
        System.out.println("After: " + Arrays.toString(numbers));
        
        String[] words = {"apple", "banana", "cherry", "date", "elderberry"};
        System.out.println("Before: " + Arrays.toString(words));
        
        reverseRange(words, 1, 3);
        System.out.println("After: " + Arrays.toString(words));
    }
}