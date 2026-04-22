import java.util.ArrayList;
import java.util.List;

public class ArrayConcatenator {
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
            for (String element : array1) {
                resultList.add(element);
            }
        }

        if (array2 != null) {
            for (String element : array2) {
                resultList.add(element);
            }
        }

        // Add overlapping elements from array2 that are already in resultList
        if (array1 != null && array2 != null) {
            for (String element : array2) {
                for (String existingElement : array1) {
                    if (element.equals(existingElement)) {
                        resultList.add(element);
                    }
                }
            }
        }

        return resultList.toArray(new String[0]);
    }
}