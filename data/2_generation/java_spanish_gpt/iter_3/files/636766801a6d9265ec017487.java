import java.io.UnsupportedEncodingException;
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
        try {
            // Codificar '{' y '}' en formato percentil
            String encoded = s.replace("{", "%7B").replace("}", "%7D");
            return encoded;
        } catch (Exception e) {
            // Manejo de excepciones
            e.printStackTrace();
            return s; // Retornar la cadena original en caso de error
        }
    }

    public static void main(String[] args) {
        String input = "Hello {name}, welcome to {place}!";
        String encoded = encodeTemplateNames(input);
        System.out.println(encoded); // Salida: Hello %7Bname%7D, welcome to %7Bplace%7D!
    }
}