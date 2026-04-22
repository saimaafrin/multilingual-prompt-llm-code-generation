import java.util.Objects;

public class BooleanArrayConverter {

    /** 
     * <p>Convierte un array de objetos Boolean a primitivos.</p> 
     * <p>Este método devuelve <code>null</code> para un array de entrada <code>null</code>.</p>
     * @param array  un array de <code>Boolean</code>, puede ser <code>null</code>
     * @return un array de <code>boolean</code>, <code>null</code> si el array de entrada es nulo
     * @throws NullPointerException si el contenido del array es <code>null</code>
     */
    public static boolean[] toPrimitive(final Boolean[] array) {
        if (array == null) {
            return null;
        }
        boolean[] result = new boolean[array.length];
        for (int i = 0; i < array.length; i++) {
            if (array[i] == null) {
                throw new NullPointerException("El contenido del array no puede ser nulo");
            }
            result[i] = array[i];
        }
        return result;
    }

    public static void main(String[] args) {
        Boolean[] booleanArray = {true, false, null, true};
        try {
            boolean[] primitiveArray = toPrimitive(booleanArray);
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
        }
    }
}