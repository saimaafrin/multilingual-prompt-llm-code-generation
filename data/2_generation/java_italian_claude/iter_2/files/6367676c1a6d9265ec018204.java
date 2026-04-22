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
        // Se entrambi gli array sono null, ritorna null
        if (array1 == null && array2 == null) {
            return null;
        }
        
        // Se uno degli array è null, ritorna una copia dell'altro array
        if (array1 == null) {
            return array2.clone();
        }
        if (array2 == null) {
            return array1.clone();
        }
        
        // Crea una lista per contenere tutti gli elementi
        List<String> result = new ArrayList<>();
        
        // Aggiungi tutti gli elementi del primo array
        for (String s : array1) {
            if (s != null) {
                result.add(s);
            }
        }
        
        // Aggiungi tutti gli elementi del secondo array
        for (String s : array2) {
            if (s != null) {
                result.add(s);
            }
        }
        
        // Converti la lista in array e ritorna
        return result.toArray(new String[0]);
    }
}