import java.util.Objects;

public class ArrayUtils {

    // Referencia estática para un array vacío
    public static final Double[] EMPTY_DOUBLE_ARRAY = new Double[0];

    /**
     * Técnica de programación defensiva para cambiar una referencia <code>null</code> por una vacía.
     * Este método devuelve un array vacío para un array de entrada <code>null</code>.
     * Como técnica de optimización de memoria, un array vacío pasado será reemplazado por las referencias vacías <code>public static</code> en esta clase.
     * @param array  el array a verificar si es <code>null</code> o vacío
     * @return el mismo array, un array vacío <code>public static</code> si la entrada es <code>null</code> o vacía
     * @since 2.5
     */
    public static Double[] nullToEmpty(final Double[] array) {
        if (array == null || array.length == 0) {
            return EMPTY_DOUBLE_ARRAY;
        }
        return array;
    }
}