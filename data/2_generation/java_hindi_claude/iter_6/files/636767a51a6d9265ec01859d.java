import java.util.Arrays;

public class ArrayMatcher {
    private int[] internalArray;
    
    public ArrayMatcher(int[] array) {
        this.internalArray = array;
    }

    /**
     * Returns true if the contents of the internal array and the provided array match.
     * @param otherArray The array to compare against the internal array
     * @return boolean indicating if arrays match
     */
    public boolean matches(int[] otherArray) {
        if (otherArray == null || internalArray == null) {
            return false;
        }
        
        if (otherArray.length != internalArray.length) {
            return false;
        }
        
        return Arrays.equals(internalArray, otherArray);
    }
}