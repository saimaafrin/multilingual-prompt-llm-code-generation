import java.lang.reflect.Array;

public class ArrayUtils {
    /**
     * Devuelve una copia del array dado de tamaño 1 mayor que el argumento. El último valor del array se deja con el valor por defecto.
     * @param array El array a copiar, no debe ser <code>null</code>.
     * @param newArrayComponentType Si <code>array</code> es <code>null</code>, crea un array de tamaño 1 de este tipo.
     * @return Una nueva copia del array de tamaño 1 mayor que la entrada.
     */
    private static Object copyArrayGrow1(final Object array, final Class<?> newArrayComponentType) {
        if (array != null) {
            int arrayLength = Array.getLength(array);
            Object newArray = Array.newInstance(array.getClass().getComponentType(), arrayLength + 1);
            System.arraycopy(array, 0, newArray, 0, arrayLength);
            return newArray;
        }
        return Array.newInstance(newArrayComponentType, 1);
    }
}