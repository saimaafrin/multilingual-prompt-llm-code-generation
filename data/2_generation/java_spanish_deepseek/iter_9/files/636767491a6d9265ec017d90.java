import java.util.Objects;

public class ArrayUtils {

    /**
     * Invierte el orden de los elementos en el rango especificado dentro del arreglo dado.
     * @param <V> el tipo de elementos en el arreglo
     * @param arr el arreglo
     * @param from el índice del primer elemento (inclusive) dentro del rango a invertir
     * @param to el índice del último elemento (inclusive) dentro del rango a invertir
     */
    public static final <V> void reverse(V[] arr, int from, int to) {
        Objects.requireNonNull(arr, "El arreglo no puede ser nulo.");
        if (from < 0 || to >= arr.length || from > to) {
            throw new IllegalArgumentException("Índices fuera de rango o inválidos.");
        }

        while (from < to) {
            V temp = arr[from];
            arr[from] = arr[to];
            arr[to] = temp;
            from++;
            to--;
        }
    }

    public static void main(String[] args) {
        // Ejemplo de uso
        Integer[] arr = {1, 2, 3, 4, 5};
        reverse(arr, 1, 3);
        for (Integer num : arr) {
            System.out.print(num + " ");
        }
        // Salida esperada: 1 4 3 2 5
    }
}