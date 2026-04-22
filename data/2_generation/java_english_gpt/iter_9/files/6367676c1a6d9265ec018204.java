public class ArrayConcatenation {

    /** 
     * Concatenate the given String arrays into one, with overlapping array elements included twice. 
     * The order of elements in the original arrays is preserved.
     * @param array1 the first array (can be <code>null</code>)
     * @param array2 the second array (can be <code>null</code>)
     * @return the new array (<code>null</code> if both given arrays were <code>null</code>)
     */
    public static String[] concatenateStringArrays(String[] array1, String[] array2) {
        if (array1 == null && array2 == null) {
            return null;
        }

        int length1 = (array1 != null) ? array1.length : 0;
        int length2 = (array2 != null) ? array2.length : 0;
        String[] result = new String[length1 + length2];

        int index = 0;
        if (array1 != null) {
            for (String s : array1) {
                result[index++] = s;
            }
        }
        if (array2 != null) {
            for (String s : array2) {
                result[index++] = s;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        String[] array1 = {"Hello", "World"};
        String[] array2 = {"World", "Java"};
        String[] result = concatenateStringArrays(array1, array2);
        
        for (String s : result) {
            System.out.println(s);
        }
    }
}