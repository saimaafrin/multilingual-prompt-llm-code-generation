public class ShortArrayConverter {

    /**
     * Converte un array di short primitivi in oggetti.
     * Questo metodo restituisce null per un array di input null.
     *
     * @param array un array di short
     * @return un array di Short, null se l'array di input è nullo
     */
    public static Short[] toObject(final short[] array) {
        if (array == null) {
            return null;
        }
        Short[] result = new Short[array.length];
        for (int i = 0; i < array.length; i++) {
            result[i] = array[i];
        }
        return result;
    }

    public static void main(String[] args) {
        short[] primitiveArray = {1, 2, 3, 4, 5};
        Short[] objectArray = toObject(primitiveArray);
        for (Short s : objectArray) {
            System.out.println(s);
        }
    }
}