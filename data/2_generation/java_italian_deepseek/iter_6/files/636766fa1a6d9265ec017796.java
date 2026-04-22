public class BooleanArrayConverter {

    /**
     * Converte un array di booleani primitivi in oggetti.
     * Questo metodo restituisce null per un array di input null.
     *
     * @param array un array di boolean
     * @return un array di Boolean, null se l'array di input è null
     */
    public static Boolean[] toObject(final boolean[] array) {
        if (array == null) {
            return null;
        }
        Boolean[] result = new Boolean[array.length];
        for (int i = 0; i < array.length; i++) {
            result[i] = array[i];
        }
        return result;
    }

    public static void main(String[] args) {
        boolean[] primitiveArray = {true, false, true};
        Boolean[] objectArray = toObject(primitiveArray);
        for (Boolean b : objectArray) {
            System.out.println(b);
        }
    }
}