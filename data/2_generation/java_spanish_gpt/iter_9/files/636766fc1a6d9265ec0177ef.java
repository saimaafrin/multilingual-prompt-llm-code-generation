import java.util.Arrays;

public class Main {
    /**
     * Devuelve un nuevo arreglo de Strings sin elementos nulos. Método interno utilizado para normalizar listas de exclusión (arreglo y colecciones). Tenga en cuenta que {@link Arrays#sort(Object[])} lanzará un {@link NullPointerException} si un elemento del arreglo es <code>null</code>.
     * @param array El arreglo a verificar
     * @return El arreglo dado o un nuevo arreglo sin nulos.
     */
    static String[] toNoNullStringArray(Object[] array) {
        if (array == null) {
            return new String[0];
        }
        return Arrays.stream(array)
                     .filter(obj -> obj != null)
                     .map(Object::toString)
                     .toArray(String[]::new);
    }

    public static void main(String[] args) {
        Object[] inputArray = { "Hello", null, "World", null, "!" };
        String[] resultArray = toNoNullStringArray(inputArray);
        System.out.println(Arrays.toString(resultArray)); // Output: [Hello, World, !]
    }
}