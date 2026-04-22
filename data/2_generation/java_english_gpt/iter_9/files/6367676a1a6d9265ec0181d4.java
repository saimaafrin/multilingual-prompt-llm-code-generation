public class StringArrayAppender {
    
    /** 
     * Append the given String to the given String array, returning a new array consisting of the input array contents plus the given String.
     * @param array the array to append to (can be <code>null</code>)
     * @param str the String to append
     * @return the new array (never <code>null</code>)
     */
    public static String[] addStringToArray(String[] array, String str) {
        int newSize = (array == null ? 0 : array.length) + 1;
        String[] newArray = new String[newSize];
        
        if (array != null) {
            System.arraycopy(array, 0, newArray, 0, array.length);
        }
        
        newArray[newSize - 1] = str;
        return newArray;
    }

    public static void main(String[] args) {
        String[] originalArray = {"Hello", "World"};
        String newString = "!";
        String[] newArray = addStringToArray(originalArray, newString);
        
        for (String s : newArray) {
            System.out.print(s + " ");
        }
    }
}