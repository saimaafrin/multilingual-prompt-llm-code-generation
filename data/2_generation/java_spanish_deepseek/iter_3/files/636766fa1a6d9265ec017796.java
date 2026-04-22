public class BooleanArrayConverter {

    /**
     * Convierte un arreglo de booleanos primitivos a objetos.
     * Este método devuelve null para un arreglo de entrada null.
     * @param array un arreglo de boolean
     * @return un arreglo de Boolean, null si el arreglo de entrada es nulo
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