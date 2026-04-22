public class BooleanArrayConverter {

    /**
     * <p>Converte un array di oggetti Boolean in primitivi.</p>
     * <p>Questo metodo restituisce <code>null</code> per un array di input <code>null</code>.</p>
     * @param array  un array di <code>Boolean</code>, può essere <code>null</code>
     * @return un array di <code>boolean</code>, <code>null</code> se l'array di input è nullo
     * @throws NullPointerException se il contenuto dell'array è <code>null</code>
     */
    public static boolean[] toPrimitive(final Boolean[] array) {
        if (array == null) {
            return null;
        }
        boolean[] result = new boolean[array.length];
        for (int i = 0; i < array.length; i++) {
            if (array[i] == null) {
                throw new NullPointerException("Element at index " + i + " is null.");
            }
            result[i] = array[i];
        }
        return result;
    }

    public static void main(String[] args) {
        // Example usage
        Boolean[] booleanArray = { true, false, true };
        boolean[] primitiveArray = toPrimitive(booleanArray);
        for (boolean b : primitiveArray) {
            System.out.println(b);
        }
    }
}