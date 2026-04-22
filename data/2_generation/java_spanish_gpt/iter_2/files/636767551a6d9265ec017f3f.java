public class ArrayUtils {
    /** 
     * Intercambia los dos elementos en los índices especificados en el arreglo dado.
     * @param <V> el tipo de elementos en el arreglo
     * @param arr el arreglo
     * @param i el índice del primer elemento
     * @param j el índice del segundo elemento
     */
    public static final <V> void swap(V[] arr, int i, int j) {
        if (arr == null) {
            throw new IllegalArgumentException("El arreglo no puede ser nulo.");
        }
        if (i < 0 || i >= arr.length || j < 0 || j >= arr.length) {
            throw new IndexOutOfBoundsException("Índices fuera de los límites del arreglo.");
        }
        V temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        Integer[] array = {1, 2, 3, 4, 5};
        swap(array, 1, 3);
        for (Integer num : array) {
            System.out.print(num + " ");
        }
    }
}