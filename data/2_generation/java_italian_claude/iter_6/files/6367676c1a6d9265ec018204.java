import java.util.ArrayList;
import java.util.List;

public class ArrayUtils {
    /**
     * Concatenare i dati degli array di Stringa forniti in uno solo, includendo gli elementi sovrapposti due volte.
     * L'ordine degli elementi negli array originali è preservato.
     * @param array1 il primo array (può essere <code>null</code>)
     * @param array2 il secondo array (può essere <code>null</code>)
     * @return il nuovo array (<code>null</code> se entrambi gli array forniti erano <code>null</code>)
     */
    public static String[] concatenateStringArrays(String[] array1, String[] array2) {
        // If both arrays are null, return null
        if (array1 == null && array2 == null) {
            return null;
        }
        
        // If one array is null, return copy of the non-null array
        if (array1 == null) {
            return array2.clone();
        }
        if (array2 == null) {
            return array1.clone();
        }

        // Create list to store concatenated elements
        List<String> result = new ArrayList<>();
        
        // Add all elements from first array
        for (String s : array1) {
            if (s != null) {
                result.add(s);
            }
        }
        
        // Add all elements from second array
        for (String s : array2) {
            if (s != null) {
                result.add(s);
            }
        }
        
        // Convert list to array and return
        return result.toArray(new String[0]);
    }
}