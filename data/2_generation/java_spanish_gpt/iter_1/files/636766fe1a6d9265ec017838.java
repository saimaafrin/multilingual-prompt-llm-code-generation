public class CharacterArrayConverter {

    /** 
     * <p>Convierte un array de objetos "Character" a primitivos.</p> <p>Este método devuelve <code>null</code> para un arreglo de entrada <code>null</code>.</p>
     * @param array  un arreglo de <code>Character</code>, puede ser <code>null</code>
     * @return un arreglo de <code>char</code>, <code>null</code> si el arreglo de entrada es nulo
     * @throws NullPointerException si el contenido del arreglo es <code>null</code>
     */
    public static char[] toPrimitive(final Character[] array) {
        if (array == null) {
            return null;
        }
        char[] result = new char[array.length];
        for (int i = 0; i < array.length; i++) {
            if (array[i] == null) {
                throw new NullPointerException("El contenido del arreglo no puede ser nulo");
            }
            result[i] = array[i];
        }
        return result;
    }

    public static void main(String[] args) {
        Character[] charArray = { 'a', 'b', 'c' };
        char[] primitiveArray = toPrimitive(charArray);
        for (char c : primitiveArray) {
            System.out.print(c + " ");
        }
    }
}