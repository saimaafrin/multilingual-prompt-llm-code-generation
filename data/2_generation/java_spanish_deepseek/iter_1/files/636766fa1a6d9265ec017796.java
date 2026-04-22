public class BooleanArrayConverter {

    /**
     * <p>Convierte un arreglo de booleanos primitivos a objetos.</p> 
     * <p>Este método devuelve <code>null</code> para un arreglo de entrada <code>null</code>.</p>
     * @param array  un arreglo de <code>boolean</code>
     * @return un arreglo de <code>Boolean</code>, <code>null</code> si el arreglo de entrada es nulo
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