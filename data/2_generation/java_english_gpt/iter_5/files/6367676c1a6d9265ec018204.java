import java.util.ArrayList;
import java.util.List;

public class StringArrayConcatenator {
    
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

        List<String> resultList = new ArrayList<>();

        if (array1 != null) {
            for (String s : array1) {
                resultList.add(s);
            }
        }

        if (array2 != null) {
            for (String s : array2) {
                resultList.add(s);
            }
        }

        // Handle overlapping elements
        if (array1 != null && array2 != null) {
            for (String s : array2) {
                for (String s1 : array1) {
                    if (s.equals(s1)) {
                        resultList.add(s);
                    }
                }
            }
        }

        return resultList.toArray(new String[0]);
    }

    public static void main(String[] args) {
        String[] array1 = {"a", "b", "c"};
        String[] array2 = {"b", "c", "d"};
        String[] result = concatenateStringArrays(array1, array2);
        
        for (String s : result) {
            System.out.print(s + " ");
        }
    }
}