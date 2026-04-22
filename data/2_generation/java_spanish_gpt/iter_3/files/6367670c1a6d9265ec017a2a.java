public class ArrayConverter {

    /** 
     * <p>Convierte un arreglo de objetos "Integer" a primitivos.</p> <p>Este método devuelve <code>null</code> para un arreglo de entrada <code>null</code>.</p>
     * @param array  un arreglo de <code>Integer</code>, puede ser <code>null</code>
     * @return un arreglo de <code>int</code>, <code>null</code> si el arreglo de entrada es nulo
     * @throws NullPointerException si el contenido del arreglo es <code>null</code>
     */
    public static int[] toPrimitive(final Integer[] array) {
        if (array == null) {
            return null;
        }
        int[] primitiveArray = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            if (array[i] == null) {
                throw new NullPointerException("El contenido del arreglo no puede ser nulo");
            }
            primitiveArray[i] = array[i].intValue();
        }
        return primitiveArray;
    }

    public static void main(String[] args) {
        Integer[] integerArray = {1, 2, 3, 4, 5};
        int[] primitiveArray = toPrimitive(integerArray);
        for (int num : primitiveArray) {
            System.out.print(num + " ");
        }
    }
}