import java.util.Arrays;

public class StringArrayCopy {

    /** 
     * This method creates a copy of the provided array, and ensures that all the strings in the newly created array contain only lower-case letters. <p> Using this method to copy string arrays means that changes to the src array do not modify the dst array.
     */
    private static String[] copyStrings(final String[] src) {
        if (src == null) {
            return null;
        }
        
        String[] dst = new String[src.length];
        for (int i = 0; i < src.length; i++) {
            dst[i] = src[i] != null ? src[i].toLowerCase() : null;
        }
        return dst;
    }

    public static void main(String[] args) {
        String[] original = {"Hello", "World", "JAVA", null, "Programming"};
        String[] copied = copyStrings(original);
        
        System.out.println("Original: " + Arrays.toString(original));
        System.out.println("Copied: " + Arrays.toString(copied));
    }
}