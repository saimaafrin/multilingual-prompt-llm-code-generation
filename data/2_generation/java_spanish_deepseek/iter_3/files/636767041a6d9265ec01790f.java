import java.util.stream.IntStream;

public class ArrayConverter {

    /**
     * <p>Convierte un arreglo de enteros primitivos a objetos.</p> 
     * <p>Este método devuelve <code>null</code> para un arreglo de entrada <code>null</code>.</p>
     * @param array  un arreglo de <code>int</code>
     * @return un arreglo de <code>Integer</code>, <code>null</code> si el arreglo de entrada es nulo
     */
    public static Integer[] toObject(final int[] array) {
        if (array == null) {
            return null;
        }
        return IntStream.of(array).boxed().toArray(Integer[]::new);
    }
}