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
        
        // Mapa de caracteres escapados comunes en Java
        Map<String, String> unescapeMap = new HashMap<>();
        unescapeMap.put("\\n", "\n"); // nueva línea
        unescapeMap.put("\\t", "\t"); // tab
        unescapeMap.put("\\r", "\r"); // retorno de carro
        unescapeMap.put("\\b", "\b"); // backspace
        unescapeMap.put("\\f", "\f"); // form feed
        unescapeMap.put("\\\"", "\""); // comilla doble
        unescapeMap.put("\\'", "'");   // comilla simple
        unescapeMap.put("\\\\", "\\"); // backslash
        
        StringBuilder result = new StringBuilder(str.length());
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '\\' && i + 1 < str.length()) {
                String escaped = str.substring(i, i + 2);
                if (unescapeMap.containsKey(escaped)) {
                    result.append(unescapeMap.get(escaped));
                    i++; // saltar el siguiente carácter ya que fue procesado
                } else if (str.charAt(i + 1) == 'u' && i + 5 < str.length()) {
                    // Procesar secuencias Unicode \uXXXX
                    String hex = str.substring(i + 2, i + 6);
                    try {
                        result.append((char) Integer.parseInt(hex, 16));
                        i += 5; // saltar los siguientes 5 caracteres
                    } catch (NumberFormatException e) {
                        throw new Exception("Secuencia Unicode inválida: \\u" + hex);
                    }
                } else {
                    // Si no es un escape válido, mantener el backslash
                    result.append(str.charAt(i));
                }
            } else {
                result.append(str.charAt(i));
            }
        }
        
        return result.toString();
    }
}