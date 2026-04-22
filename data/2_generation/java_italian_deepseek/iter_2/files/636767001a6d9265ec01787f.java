import java.util.Arrays;

/**
 * <p>Aggiunge al <code>toString</code> i dettagli di un array di <code>int</code>.</p>
 * @param buffer  il <code>StringBuffer</code> da popolare
 * @param fieldName  il nome del campo, tipicamente non utilizzato poiché già aggiunto
 * @param array  l'array da aggiungere al <code>toString</code>, non <code>null</code>
 */
protected void appendDetail(StringBuffer buffer, String fieldName, int[] array) {
    if (array == null) {
        throw new IllegalArgumentException("L'array non può essere null.");
    }
    
    buffer.append(Arrays.toString(array));
}