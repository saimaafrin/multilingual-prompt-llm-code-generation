public class StringUtils {
    /**
     * Convierte el objeto dado en una cadena con comillas simples si es una cadena; manteniendo el objeto tal como está en caso contrario.
     * @param obj el objeto de entrada (por ejemplo, "miCadena") 
     * @return la cadena entre comillas (por ejemplo, "'miCadena'"), o el objeto de entrada tal como está si no es una cadena
     */
    public static Object quoteIfString(Object obj) {
        if (obj instanceof String) {
            return "'" + obj + "'";
        }
        return obj;
    }
}