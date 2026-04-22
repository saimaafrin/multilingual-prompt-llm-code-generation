public class ArrayTrimmer {
    /**
     * Recorta los elementos del arreglo de Strings dado, llamando a <code>String.trim()</code> en cada uno de ellos.
     * @param array de Strings original
     * @return el arreglo resultante (del mismo tamaño) con elementos recortados
     */
    public static String[] trimArrayElements(String[] array) {
        if (array == null) {
            return null;
        }
        
        String[] result = new String[array.length];
        
        for (int i = 0; i < array.length; i++) {
            if (array[i] != null) {
                result[i] = array[i].trim();
            } else {
                result[i] = null;
            }
        }
        
        return result;
    }
}