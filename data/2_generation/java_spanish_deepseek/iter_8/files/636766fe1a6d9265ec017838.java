public class CharacterArrayConverter {

    /**
     * Convierte un array de objetos "Character" a primitivos.
     * Este método devuelve null para un arreglo de entrada null.
     *
     * @param array un arreglo de Character, puede ser null
     * @return un arreglo de char, null si el arreglo de entrada es nulo
     * @throws NullPointerException si el contenido del arreglo es null
     */
    public static char[] toPrimitive(final Character[] array) {
        if (array == null) {
            return null;
        }
        char[] result = new char[array.length];
        for (int i = 0; i < array.length; i++) {
            if (array[i] == null) {
                throw new NullPointerException("El contenido del arreglo no puede ser null.");
            }
            result[i] = array[i];
        }
        return result;
    }

    public static void main(String[] args) {
        Character[] testArray = {'a', 'b', 'c'};
        char[] primitiveArray = toPrimitive(testArray);
        for (char c : primitiveArray) {
            System.out.print(c + " ");
        }
    }
}