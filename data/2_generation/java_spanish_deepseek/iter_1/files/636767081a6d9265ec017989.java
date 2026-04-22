import java.util.Objects;

public class BooleanArrayConverter {

    /**
     * Convierte un array de objetos Boolean a primitivos.
     * Este método devuelve null para un array de entrada null.
     *
     * @param array un array de Boolean, puede ser null
     * @return un array de boolean, null si el array de entrada es nulo
     * @throws NullPointerException si el contenido del array es null
     */
    public static boolean[] toPrimitive(final Boolean[] array) {
        if (array == null) {
            return null;
        }
        boolean[] result = new boolean[array.length];
        for (int i = 0; i < array.length; i++) {
            result[i] = Objects.requireNonNull(array[i], "El elemento en la posición " + i + " es nulo");
        }
        return result;
    }
}