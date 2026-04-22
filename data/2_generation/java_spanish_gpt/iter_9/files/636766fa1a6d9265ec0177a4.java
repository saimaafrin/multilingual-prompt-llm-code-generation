public class ArrayConverter {
    
    /** 
     * <p>Convierte un arreglo de primitivos double a objetos.</p> 
     * <p>Este método devuelve <code>null</code> para un arreglo de entrada <code>null</code>.</p>
     * @param array  un arreglo de <code>double</code>
     * @return un arreglo de <code>Double</code>, <code>null</code> si el arreglo de entrada es nulo
     */
    public static Double[] toObject(final double[] array) {
        if (array == null) {
            return null;
        }
        Double[] result = new Double[array.length];
        for (int i = 0; i < array.length; i++) {
            result[i] = array[i]; // Autoboxing from double to Double
        }
        return result;
    }

    public static void main(String[] args) {
        double[] primitiveArray = {1.0, 2.0, 3.0};
        Double[] objectArray = toObject(primitiveArray);
        for (Double d : objectArray) {
            System.out.println(d);
        }
    }
}