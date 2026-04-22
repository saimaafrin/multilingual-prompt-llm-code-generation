import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.MatchResult;

public final class URIMatcher {

    /**
     * Compara una URI con el patrón.
     * @param uri la URI a comparar con la plantilla.
     * @return el resultado de la coincidencia, o null si no hay coincidencia.
     */
    public final MatchResult match(CharSequence uri) {
        // Define el patrón de la URI que se desea comparar
        String uriPattern = "your_pattern_here"; // Reemplaza con el patrón deseado
        Pattern pattern = Pattern.compile(uriPattern);
        Matcher matcher = pattern.matcher(uri);

        // Si hay coincidencia, devuelve el resultado
        if (matcher.matches()) {
            return matcher.toMatchResult();
        } else {
            return null;
        }
    }

    public static void main(String[] args) {
        URIMatcher matcher = new URIMatcher();
        CharSequence uri = "your_uri_here"; // Reemplaza con la URI que deseas comparar
        MatchResult result = matcher.match(uri);

        if (result != null) {
            System.out.println("Coincidencia encontrada: " + result.group());
        } else {
            System.out.println("No se encontró coincidencia.");
        }
    }
}