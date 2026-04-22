import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.MatchResult;

public final class UriMatcher {

    /**
     * Confronta un URI con il modello.
     * @param uri l'uri da confrontare con il template.
     * @return il risultato della corrispondenza, altrimenti null se non si verifica alcuna corrispondenza.
     */
    public final MatchResult match(CharSequence uri) {
        // Definisci il pattern del template (esempio: "/api/v1/resource/{id}")
        String templatePattern = "/api/v1/resource/\\d+"; // Esempio di pattern per un URI con un ID numerico
        Pattern pattern = Pattern.compile(templatePattern);
        Matcher matcher = pattern.matcher(uri);

        // Se trova una corrispondenza, restituisci il risultato
        if (matcher.find()) {
            return matcher.toMatchResult();
        }

        // Altrimenti restituisci null
        return null;
    }

    public static void main(String[] args) {
        UriMatcher matcher = new UriMatcher();
        CharSequence uri = "/api/v1/resource/123";
        MatchResult result = matcher.match(uri);

        if (result != null) {
            System.out.println("URI matches the template: " + result.group());
        } else {
            System.out.println("No match found.");
        }
    }
}