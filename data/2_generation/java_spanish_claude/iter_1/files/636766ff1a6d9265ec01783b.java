public class StringUtils {
    /**
     * Obtiene una subcadena de la cadena especificada evitando excepciones.
     * @param str Cadena de entrada
     * @param start Índice inicial
     * @param end Índice final
     * @return Subcadena o cadena vacía si los parámetros son inválidos
     */
    public static String sub(String str, int start, int end) {
        if (str == null || str.isEmpty()) {
            return "";
        }
        
        // Ajustar índices si están fuera de rango
        start = Math.max(0, start);
        end = Math.min(str.length(), end);
        
        // Validar que start sea menor que end
        if (start >= end) {
            return "";
        }
        
        return str.substring(start, end);
    }
}