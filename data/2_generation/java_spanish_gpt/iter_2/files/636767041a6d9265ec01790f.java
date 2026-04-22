public class ArrayConverter {
    
    /** 
     * <p>Convierte un arreglo de enteros primitivos a objetos.</p> <p>Este método devuelve <code>null</code> para un arreglo de entrada <code>null</code>.</p>
     * @param array  un arreglo de <code>int</code>
     * @return un arreglo de <code>Integer</code>, <code>null</code> si el arreglo de entrada es nulo
     */
    public static Integer[] toObject(final int[] array) {
        if (array == null) {
            return null;
        }
        
        Integer[] result = new Integer[array.length];
        for (int i = 0; i < array.length; i++) {
            result[i] = Integer.valueOf(array[i]);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] primitiveArray = {1, 2, 3, 4, 5};
        Integer[] objectArray = toObject(primitiveArray);
        
        // Print the result
        for (Integer num : objectArray) {
            System.out.println(num);
        }
    }
}