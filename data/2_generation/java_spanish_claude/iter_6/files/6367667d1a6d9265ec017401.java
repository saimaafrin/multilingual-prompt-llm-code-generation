import java.util.HashMap;
import java.util.Map;

public class StringUtils {

    /**
     * <p>Remueve el "escape" de cualquier literal de Java encontrado en el <code>String</code>. Por ejemplo, convertirá una secuencia de <code>'\'</code> y <code>'n'</code> en un carácter de nueva línea, a menos que el <code>'\'</code> esté precedido por otro <code>'\'</code>.</p>
     * @param str el <code>String</code> a procesar, puede ser nulo
     * @return un nuevo <code>String</code> sin carácteres "escape", <code>null</code> si la entrada es un string nulo
     */
    public static String unescapeJava(String str) throws Exception {
        if (str == null) {
            return null;
        }
        
        // Mapa de caracteres escapados de Java
        Map<String, String> escapeChars = new HashMap<>();
        escapeChars.put("\\n", "\n"); // nueva línea
        escapeChars.put("\\t", "\t"); // tab
        escapeChars.put("\\r", "\r"); // retorno de carro
        escapeChars.put("\\b", "\b"); // backspace
        escapeChars.put("\\f", "\f"); // form feed
        escapeChars.put("\\\"", "\""); // comilla doble
        escapeChars.put("\\'", "'");   // comilla simple
        escapeChars.put("\\\\", "\\"); // backslash
        
        StringBuilder result = new StringBuilder(str.length());
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '\\' && i + 1 < str.length()) {
                String escaped = str.substring(i, i + 2);
                if (escapeChars.containsKey(escaped)) {
                    result.append(escapeChars.get(escaped));
                    i++; // saltar el siguiente carácter ya que fue procesado
                } else {
                    // Si no es un carácter de escape válido, mantener el backslash
                    result.append(str.charAt(i));
                }
            } else {
                result.append(str.charAt(i));
            }
        }
        
        return result.toString();
    }
}