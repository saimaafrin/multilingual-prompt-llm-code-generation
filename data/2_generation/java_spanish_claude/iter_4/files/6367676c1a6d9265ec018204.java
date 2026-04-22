public class ArrayUtils {
    /**
     * Concatenar los arreglos de cadenas dados en uno solo, incluyendo los elementos de los arreglos que se superponen dos veces.
     * El orden de los elementos en los arreglos originales se preserva.
     * @param array1 el primer arreglo (puede ser <code>null</code>)
     * @param array2 el segundo arreglo (puede ser <code>null</code>) 
     * @return el nuevo arreglo (<code>null</code> si ambos arreglos dados eran <code>null</code>)
     */
    public static String[] concatenateStringArrays(String[] array1, String[] array2) {
        // Si ambos arrays son null, retornar null
        if (array1 == null && array2 == null) {
            return null;
        }
        
        // Si uno de los arrays es null, retornar una copia del otro
        if (array1 == null) {
            return array2.clone();
        }
        if (array2 == null) {
            return array1.clone();
        }
        
        // Crear nuevo array con la suma de las longitudes
        String[] result = new String[array1.length + array2.length];
        
        // Copiar elementos del primer array
        System.arraycopy(array1, 0, result, 0, array1.length);
        
        // Copiar elementos del segundo array
        System.arraycopy(array2, 0, result, array1.length, array2.length);
        
        return result;
    }
}