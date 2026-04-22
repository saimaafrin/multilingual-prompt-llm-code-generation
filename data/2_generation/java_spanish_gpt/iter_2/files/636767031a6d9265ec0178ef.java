import java.lang.reflect.Array;

public class ArrayUtils {

    /** 
     * Devuelve una copia del array dado de tamaño 1 mayor que el argumento. El último valor del array se deja con el valor por defecto.
     * @param array El array a copiar, no debe ser <code>null</code>.
     * @param newArrayComponentType Si <code>array</code> es <code>null</code>, crea un array de tamaño 1 de este tipo.
     * @return Una nueva copia del array de tamaño 1 mayor que la entrada.
     */
    private static Object copyArrayGrow1(final Object array, final Class<?> newArrayComponentType) {
        if (array == null) {
            return Array.newInstance(newArrayComponentType, 1);
        }
        
        int length = Array.getLength(array);
        Object newArray = Array.newInstance(array.getClass().getComponentType(), length + 1);
        
        for (int i = 0; i < length; i++) {
            Array.set(newArray, i, Array.get(array, i));
        }
        
        return newArray;
    }

    public static void main(String[] args) {
        // Example usage
        Integer[] originalArray = {1, 2, 3};
        Object newArray = copyArrayGrow1(originalArray, Integer.class);
        
        // Print the new array
        for (int i = 0; i < Array.getLength(newArray); i++) {
            System.out.println(Array.get(newArray, i));
        }
    }
}