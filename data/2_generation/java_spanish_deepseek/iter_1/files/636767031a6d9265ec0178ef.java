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
        System.arraycopy(array, 0, newArray, 0, length);
        return newArray;
    }

    public static void main(String[] args) {
        // Ejemplo de uso
        int[] originalArray = {1, 2, 3};
        int[] newArray = (int[]) copyArrayGrow1(originalArray, int.class);

        System.out.println("Original Array: " + java.util.Arrays.toString(originalArray));
        System.out.println("New Array: " + java.util.Arrays.toString(newArray));
    }
}