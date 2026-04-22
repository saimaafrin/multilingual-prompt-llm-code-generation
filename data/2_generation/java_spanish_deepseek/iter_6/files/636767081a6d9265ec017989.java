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
            if (array[i] == null) {
                throw new NullPointerException("El contenido del array no puede ser null.");
            }
            result[i] = array[i];
        }
        return result;
    }

    public static void main(String[] args) {
        // Ejemplo de uso
        Boolean[] booleanArray = {true, false, true};
        boolean[] primitiveArray = toPrimitive(booleanArray);
        for (boolean b : primitiveArray) {
            System.out.println(b);
        }
    }
}