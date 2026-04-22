import java.util.Objects;

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
        
        // Replace '{' with '%7B' and '}' with '%7D'
        return s.replace("{", "%7B")
                .replace("}", "%7D");
    }
}