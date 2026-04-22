import java.util.Arrays;

public class StringArrayUtil {
    /** 
     * Agrega la cadena dada al arreglo de cadenas proporcionado, devolviendo un nuevo arreglo que consiste en el contenido del arreglo de entrada más la cadena dada.
     * @param array el arreglo al que se va a agregar (puede ser <code>null</code>)
     * @param str la cadena a agregar
     * @return el nuevo arreglo (nunca <code>null</code>)
     */
    public static String[] addStringToArray(String[] array, String str) {
        if (array == null) {
            return new String[]{str};
        }
        String[] newArray = Arrays.copyOf(array, array.length + 1);
        newArray[array.length] = str;
        return newArray;
    }
}