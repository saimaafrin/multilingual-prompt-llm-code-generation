import java.lang.reflect.Array;

public class ArrayUtils {

    /**
     * Restituisce una copia dell'array fornito di dimensione 1 maggiore rispetto all'argomento. L'ultimo valore dell'array viene lasciato al valore predefinito.
     * @param array L'array da copiare, non deve essere <code>null</code>.
     * @param newArrayComponentType Se <code>array</code> è <code>null</code>, crea un array di dimensione 1 di questo tipo.
     * @return Una nuova copia dell'array di dimensione 1 maggiore rispetto all'input.
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
        // Esempio di utilizzo
        int[] originalArray = {1, 2, 3};
        int[] newArray = (int[]) copyArrayGrow1(originalArray, int.class);

        for (int i : newArray) {
            System.out.print(i + " ");
        }
    }
}