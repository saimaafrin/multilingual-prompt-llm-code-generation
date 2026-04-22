import java.util.Objects;

public class DoubleArrayConverter {

    /**
     * <p>Convierte un array de objetos "Doubles" a primitivos.</p> 
     * <p>Este método devuelve <code>null</code> para un arreglo de entrada <code>null</code>.</p>
     * @param array  un arreglo de <code>Double</code>, puede ser <code>null</code>
     * @return un array de <code>double</code>, <code>null</code> si el arreglo de entrada es nulo
     * @throws NullPointerException si el contenido del arreglo es <code>null</code>
     */
    public static double[] toPrimitive(final Double[] array) {
        if (array == null) {
            return null;
        }
        
        double[] primitiveArray = new double[array.length];
        for (int i = 0; i < array.length; i++) {
            Objects.requireNonNull(array[i], "El contenido del arreglo no puede ser nulo");
            primitiveArray[i] = array[i];
        }
        
        return primitiveArray;
    }
}