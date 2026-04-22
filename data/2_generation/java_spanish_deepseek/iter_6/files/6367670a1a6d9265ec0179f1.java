public class ArrayUtils {

    /**
     * <p>Convierte un arreglo de primitivos "shorts" a objetos.</p> 
     * <p>Este método devuelve <code>null</code> para un arreglo de entrada <code>null</code>.</p>
     * @param array  un arreglo de <code>short</code>
     * @return un arreglo de <code>Short</code>, <code>null</code> si el arreglo de entrada es nulo
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