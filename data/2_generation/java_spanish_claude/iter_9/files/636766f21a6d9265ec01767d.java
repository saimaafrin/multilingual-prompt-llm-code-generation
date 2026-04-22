package utils;

public class StringUtils {
    /**
     * Convierte un objeto a String; si el objeto es nulo, devuelve nulo, de lo contrario, devuelve toString();
     * @param object Objeto a convertir a String
     * @return String representación del objeto o null si el objeto es nulo
     */
    public static String toString(Object object) {
        return object == null ? null : object.toString();
    }
}