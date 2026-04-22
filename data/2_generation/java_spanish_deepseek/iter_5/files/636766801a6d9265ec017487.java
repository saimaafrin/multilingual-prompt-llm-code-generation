import java.nio.charset.StandardCharsets;
import java.net.URLEncoder;

public class TemplateEncoder {

    /**
     * Codifica una cadena con nombres de parámetros de plantilla presentes, específicamente los caracteres '{' y '}' serán codificados en formato percentil.
     * @param s la cadena con cero o más nombres de parámetros de plantilla
     * @return la cadena con los nombres de parámetros de plantilla codificados.
     */
    public static String encodeTemplateNames(String s) {
        if (s == null) {
            return null;
        }

        StringBuilder encodedString = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c == '{' || c == '}') {
                try {
                    encodedString.append(URLEncoder.encode(String.valueOf(c), StandardCharsets.UTF_8.toString()));
                } catch (Exception e) {
                    // En caso de error, simplemente agregamos el carácter sin codificar
                    encodedString.append(c);
                }
            } else {
                encodedString.append(c);
            }
        }
        return encodedString.toString();
    }

    public static void main(String[] args) {
        String testString = "This is a {test} string with {template} parameters.";
        System.out.println(encodeTemplateNames(testString));
    }
}