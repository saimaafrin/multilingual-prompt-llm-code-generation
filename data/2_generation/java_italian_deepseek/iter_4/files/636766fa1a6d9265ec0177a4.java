public class DoubleArrayConverter {

    /**
     * Converte un array di double primitivi in oggetti.
     * Questo metodo restituisce null per un array di input null.
     *
     * @param array un array di double
     * @return un array di Double, null se l'array di input è null
     */
    public static Double[] toObject(final double[] array) {
        if (array == null) {
            return null;
        }
        Double[] result = new Double[array.length];
        for (int i = 0; i < array.length; i++) {
            result[i] = array[i];
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