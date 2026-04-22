import java.util.Arrays;

public class ArrayUtils {

    /**
     * <p>Clona un arreglo devolviendo un resultado con tipo convertido y manejando <code>null</code>.</p>
     * <p>Este método devuelve <code>null</code> para un arreglo de entrada <code>null</code>.</p>
     * @param array  el arreglo a clonar, puede ser <code>null</code>
     * @return el arreglo clonado, <code>null</code> si la entrada es <code>null</code>
     */
    public static char[] clone(final char[] array) {
        if (array == null) {
            return null;
        }
        return Arrays.copyOf(array, array.length);
    }

    public static void main(String[] args) {
        char[] original = {'a', 'b', 'c'};
        char[] cloned = clone(original);
        System.out.println(Arrays.toString(cloned)); // Output: [a, b, c]

        char[] nullArray = null;
        char[] clonedNull = clone(nullArray);
        System.out.println(clonedNull); // Output: null
    }
}