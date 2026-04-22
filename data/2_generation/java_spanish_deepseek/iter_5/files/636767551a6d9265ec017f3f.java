public class ArrayUtils {
    /**
     * Intercambia los dos elementos en los índices especificados en el arreglo dado.
     * @param <V> el tipo de elementos en el arreglo
     * @param arr el arreglo
     * @param i el índice del primer elemento
     * @param j el índice del segundo elemento
     */
    public static final <V> void swap(V[] arr, int i, int j) {
        if (arr == null || i < 0 || j < 0 || i >= arr.length || j >= arr.length) {
            throw new IllegalArgumentException("Índices fuera de rango o arreglo nulo.");
        }
        V temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        // Ejemplo de uso
        Integer[] array = {1, 2, 3, 4, 5};
        System.out.println("Antes del intercambio: " + java.util.Arrays.toString(array));
        swap(array, 1, 3);
        System.out.println("Después del intercambio: " + java.util.Arrays.toString(array));
    }
}