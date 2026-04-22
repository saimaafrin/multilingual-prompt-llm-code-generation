import java.util.Objects;

public class ArrayUtils {

    // Public static empty array reference
    public static final Byte[] EMPTY_BYTE_ARRAY = new Byte[0];

    /**
     * <p>Técnica de programación defensiva para cambiar una referencia <code>null</code> por una vacía.</p>
     * <p>Este método devuelve un array vacío para un array de entrada <code>null</code>.</p>
     * <p>Como técnica de optimización de memoria, un array vacío pasado se sobrescribirá con las referencias vacías <code>public static</code> en esta clase.</p>
     * @param array  el array a verificar si es <code>null</code> o vacío
     * @return el mismo array, un array vacío <code>public static</code> si la entrada es <code>null</code> o vacía
     * @since 2.5
     */
    public static Byte[] nullToEmpty(final Byte[] array) {
        if (array == null || array.length == 0) {
            return EMPTY_BYTE_ARRAY;
        }
        return array;
    }

    // Example usage
    public static void main(String[] args) {
        Byte[] array1 = null;
        Byte[] array2 = new Byte[0];
        Byte[] array3 = new Byte[]{1, 2, 3};

        System.out.println(Objects.toString(nullToEmpty(array1))); // Output: []
        System.out.println(Objects.toString(nullToEmpty(array2))); // Output: []
        System.out.println(Objects.toString(nullToEmpty(array3))); // Output: [1, 2, 3]
    }
}