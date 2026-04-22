import java.util.Objects;

public class ArrayConverter {

    /**
     * <p>Converte un array di oggetti Integer in primitivi.</p>
     * <p>Questo metodo restituisce <code>null</code> per un array di input <code>null</code>.</p>
     * @param array  un array di <code>Integer</code>, può essere <code>null</code>
     * @return un array di <code>int</code>, <code>null</code> se l'array di input è nullo
     * @throws NullPointerException se il contenuto dell'array è <code>null</code>
     */
    public static int[] toPrimitive(final Integer[] array) {
        if (array == null) {
            return null;
        }
        int[] result = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            result[i] = Objects.requireNonNull(array[i], "Array element cannot be null");
        }
        return result;
    }

    public static void main(String[] args) {
        Integer[] testArray = {1, 2, 3, 4, 5};
        int[] primitiveArray = toPrimitive(testArray);
        for (int i : primitiveArray) {
            System.out.print(i + " ");
        }
    }
}